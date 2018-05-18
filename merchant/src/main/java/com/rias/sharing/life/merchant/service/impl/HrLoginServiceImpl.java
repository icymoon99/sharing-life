package com.rias.sharing.life.merchant.service.impl;

import com.rias.sharing.life.common.util.SnowFlakeUtil;
import com.rias.sharing.life.common.util.StringUtil;
import com.rias.sharing.life.merchant.constants.HrStatusEnum;
import com.rias.sharing.life.merchant.dao.HrDao;
import com.rias.sharing.life.merchant.entity.Hr;
import com.rias.sharing.life.merchant.service.HrLoginService;
import com.rias.sharing.life.merchant.vo.HrVo;
import com.rias.sharing.life.merchant.vo.TakenkVo;
import com.rias.sharing.life.merchant.vo.TokenQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @Description:人力资源实现
 * @author:yangyu
 * @date:2018/4/25
 */
@Service
public class HrLoginServiceImpl implements HrLoginService {
    private static final Logger logger = LoggerFactory.getLogger(HrLoginServiceImpl.class);

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
    public Map<String, String> sendCodeByPhone(TokenQueryVo query) {

        Hr hr = jztHrDao.getByPhone(query.getPhone());

        // 查询是有已经存在用户并且可以登陆，是则发送验证码
        if (null == hr) {
            return new HashMap<String, String>() {{
                put("id", null);
                put("status", String.valueOf(HrStatusEnum.MERCHANT_NO.getIndex()));
            }};
        }

        if (hr.getStatus() == HrStatusEnum.MERCHANT_AUDIT_SUCCESS.getIndex()) {
            //TODO 发送短信验证码loginQuery.getMsgCode

        }

        return new HashMap<String, String>() {{
            put("id", String.valueOf(hr.getId()));
            put("status", String.valueOf(hr.getStatus()));
        }};
    }

    @Override
    public TakenkVo saveTaken(Long id) {
        TakenkVo takenkVo =new TakenkVo();
        String taken = StringUtil.get32UUID();
        takenkVo.setTaken(taken);

        Hr hr = jztHrDao.getById(id);
        if (null == hr) {
            takenkVo.setId(null);
        } else {
            takenkVo.setId(id);
            takenkVo.setVo(HrVo.make(hr));
        }

        //把taken放redis
        stringRedisTemplate.opsForValue().set("plantform:atuh:token:usr-id:" + takenkVo.getId(),
                taken, Long.parseLong(tokenTimeout), TimeUnit.DAYS);
        return takenkVo;
    }

    @Override
    public TakenkVo autoLogin(Long id) {
        boolean hasToken = stringRedisTemplate.hasKey("plantform:atuh:token:usr-id:" + id);

        // 不存在token
        if (false == hasToken) {
            return null;
        }

        // TODO  查询用户关联的商户已经审核通过

        // 存在则刷新token，重新计时
        return this.saveTaken(id);
    }
}
