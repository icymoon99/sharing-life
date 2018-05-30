package com.rias.sharing.life.hotel.service.impl;

import com.rias.sharing.life.common.util.SnowFlakeUtil;
import com.rias.sharing.life.hotel.service.SnowFlakeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @name: SnowFlakeService
 * @author: lucifinier
 * @date: 2018/5/26 09:26
 * @description: TODO
 */
@Service
@Slf4j
public class SnowFlakeServiceImpl implements SnowFlakeService {
    @Autowired
    SnowFlakeUtil snowFlakeUtil;

    @Override
    public Long GetId() {
        return snowFlakeUtil.creatId();
    }
}
