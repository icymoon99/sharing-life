package com.rias.sharing.life.merchant.service.impl;

import com.rias.sharing.life.common.util.SnowFlakeUtil;
import com.rias.sharing.life.common.util.StringUtil;
import com.rias.sharing.life.merchant.dao.HrDao;
import com.rias.sharing.life.merchant.entity.Hr;
import com.rias.sharing.life.merchant.service.TokenService;
import com.rias.sharing.life.merchant.vo.HrVo;
import com.rias.sharing.life.merchant.vo.TakenVo;
import com.rias.sharing.life.merchant.vo.PhoneCodeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;


/**
 * @Description:人力资源实现
 * @author:yangyu
 * @date:2018/4/25
 */
@Service
public class TokenServiceImpl implements TokenService {
    private static final Logger logger = LoggerFactory.getLogger(TokenServiceImpl.class);

    @Autowired
    HrDao jztHrDao;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SnowFlakeUtil snowFlakeUtil;

    @Value("${merchant.hr.token.time-day}")
    String tokenTimeout;
    @Value("${merchant.hr.msgcode.time-sec}")
    String msgcodeTimeout;

    /**
     * @Description:hr发送手机验证码
     * @author:yangyu
     * @date:2018/5/03
     */
    @Override
    public HrVo checkPhoneStatus(PhoneCodeVo query) {
        Hr hr = jztHrDao.getByPhone(query.getPhone());
        if (!Optional.ofNullable(hr).isPresent()) {
            return null;
        }

        HrVo vo = HrVo.make(hr);

        //TODO 发送短信验证码loginQuery.getMsgCode

        return vo;
    }

    @Override
    public TakenVo createToken(Long id) {
        Hr hr = jztHrDao.getById(id);
        if (!Optional.ofNullable(hr).isPresent()) {
            return null;
        }

        TakenVo takenVo =new TakenVo();
        takenVo.setTaken(StringUtil.get32UUID());
        takenVo.setId(id);
        takenVo.setVo(HrVo.make(hr));

        //把taken放redis
        stringRedisTemplate.opsForValue().set("plantform:atuh:token:usr-id:" + takenVo.getId(),
                takenVo.getTaken(), Long.parseLong(tokenTimeout), TimeUnit.DAYS);
        return takenVo;
    }

    @Override
    public TakenVo refreshToken(Long id) {
        boolean hasToken = stringRedisTemplate.hasKey("plantform:atuh:token:usr-id:" + id);

        // 不存在token
        if (false == hasToken) {
            return null;
        }

        // TODO  查询用户关联的商户已经审核通过

        // 存在则刷新token，重新计时
        return this.createToken(id);
    }
}
