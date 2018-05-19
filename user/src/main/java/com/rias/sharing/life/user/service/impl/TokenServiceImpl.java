package com.rias.sharing.life.user.service.impl;

import com.rias.sharing.life.common.exception.GlobalException;
import com.rias.sharing.life.common.result.CodeMsg;
import com.rias.sharing.life.common.util.SnowFlakeUtil;
import com.rias.sharing.life.common.util.StringUtil;
import com.rias.sharing.life.user.dao.UserDao;
import com.rias.sharing.life.user.entity.User;
import com.rias.sharing.life.user.service.TokenService;
import com.rias.sharing.life.user.service.aliyun.AcsService;
import com.rias.sharing.life.user.vo.PhoneCodeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @name: TokenServiceImpl
 * @author: lucifinier
 * @date: 2018/4/24 17:51
 * @description: 登陆服务类
 */
@Service
@Slf4j
public class TokenServiceImpl implements TokenService {
    private static final String CACHE_PRIFIX = "user:login:atuh:token:id:";

    @Autowired
    AcsService acsService;
    @Autowired
    UserDao userDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private SnowFlakeUtil snowFlakeUtil;

    @Value("${user.default.nick-name}")
    String nickName;
    @Value("${user.default.img-url}")
    String imgUr;
    @Value("${user.default.sex}")
    int sex;
    @Value("${user.token.time-day}")
    String tokenTimeout;

    @Override
    public User checkPhoneStatus(PhoneCodeVo phoneCodeVo) {
        User user = userDao.getUserByPhone(phoneCodeVo.getPhone());

        if (!Optional.ofNullable(user).isPresent()) {
            // 生成一条用户记录
            userDao.saveUser(this.createDefault(phoneCodeVo.getPhone()));
            log.debug(user.toString());

            //取出id
            user = userDao.getUserByPhone(phoneCodeVo.getPhone());
            log.debug(user.toString());
        }

        // 发送手机验证码
        if (!acsService.sendValidateCode(phoneCodeVo.getPhone(), phoneCodeVo.getCode(), String.valueOf(user.getId()))) {
            throw new GlobalException(CodeMsg.PHONE_CODE_SEND_FAIL);
        }

        return user;
    }

    /**
     * @Description:生成一条默认的用户记录
     * @author:张磊
     * @date:2018/4/28
     */
    private User createDefault(String phone) {
        User user = new User();

        user.setId(snowFlakeUtil.creatId());
        user.setNickName(this.nickName);
        user.setPhone(phone);
        user.setSex(this.sex);
        user.setImgUrl(this.imgUr);
        user.setBirthday(LocalDate.now());

        return user;
    }

    @Override
    public String createTokenByUserId(long userId) {
        String taken = StringUtil.get32UUID();

        //把taken放redis
        stringRedisTemplate.opsForValue().set(CACHE_PRIFIX + userId,
                taken, Long.parseLong(tokenTimeout), TimeUnit.DAYS);

        return taken;
    }

    @Override
    public String refreshTokenByUserId(long userId) {
        if (!stringRedisTemplate.hasKey(CACHE_PRIFIX + userId)) {
            log.error("redis key: " + CACHE_PRIFIX + userId);
            throw new GlobalException(CodeMsg.TOKEN_ERROR);
        }

        return this.createTokenByUserId(userId);
    }

}
