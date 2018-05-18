package com.rias.sharing.life.merchant.service;

import com.rias.sharing.life.merchant.vo.TakenkVo;
import com.rias.sharing.life.merchant.vo.TokenQueryVo;

import java.util.Map;

/**
 * @Description:人力资源服务层
 * @author:yangyu
 * @date:2018/4/25
 */
public interface HrLoginService {

    Map<String, String> sendCodeByPhone(TokenQueryVo phoneLoginQuery);

    TakenkVo saveTaken(Long id);

    TakenkVo autoLogin(Long id);
}
