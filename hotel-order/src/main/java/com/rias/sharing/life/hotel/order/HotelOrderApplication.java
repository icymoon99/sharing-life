package com.rias.sharing.life.hotel.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.rias.sharing.life.hotel.order.dao.mapper")
public class HotelOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelOrderApplication.class, args);
    }
}
