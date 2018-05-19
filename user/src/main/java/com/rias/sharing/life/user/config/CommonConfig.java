package com.rias.sharing.life.user.config;

import com.rias.sharing.life.common.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @name: CommonConfig
 * @author: lucifinier
 * @date: 2018/5/18 15:42
 * @description: TODO
 */
@Configuration
public class CommonConfig {
    @Value("${snow-flake.date-center.id}")
    private long datacenterId;
    @Value("${snow-flake.machine.id}")
    private long machineId;

    @Bean
    public SnowFlakeUtil getSnowFlakeUtil() {
        return new SnowFlakeUtil(datacenterId, machineId);
    }
}
