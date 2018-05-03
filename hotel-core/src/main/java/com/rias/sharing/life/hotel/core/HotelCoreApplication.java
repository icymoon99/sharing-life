package com.rias.sharing.life.hotel.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.rias.sharing.life.hotel.core.dao.mapper")
public class HotelCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelCoreApplication.class, args);
    }
}
