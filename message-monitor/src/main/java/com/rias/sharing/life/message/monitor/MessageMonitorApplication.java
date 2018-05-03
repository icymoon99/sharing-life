package com.rias.sharing.life.message.monitor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@MapperScan("com.rias.sharing.life.message.monitor.dao.mapper")
public class MessageMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageMonitorApplication.class, args);
    }
}
