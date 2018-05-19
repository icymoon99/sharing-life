package com.rias.sharing.life.user.service;

import com.rias.sharing.life.user.entity.User;
import com.rias.sharing.life.user.vo.PhoneCodeVo;

/**
 * @name: TokenService
 * @author: lucifinier
 * @date: 2018/4/24 17:51
 * @description: 登陆服务接口
 */
public interface TokenService {
    User checkPhoneStatus(PhoneCodeVo phoneCodeVo);

    String createTokenByUserId(long userId);

    String refreshTokenByUserId(long userId);
}
