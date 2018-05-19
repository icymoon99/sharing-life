package com.rias.sharing.life.merchant.service;

import com.rias.sharing.life.merchant.vo.HrVo;
import com.rias.sharing.life.merchant.vo.TakenVo;
import com.rias.sharing.life.merchant.vo.PhoneCodeVo;

/**
 * @Description:人力资源服务层
 * @author:yangyu
 * @date:2018/4/25
 */
public interface TokenService {

    HrVo checkPhoneStatus(PhoneCodeVo phoneLoginQuery);

    TakenVo createToken(Long id);

    TakenVo refreshToken(Long id);
}
