package com.rias.sharing.life.hotel.gateway.scheduler;

import com.rias.sharing.life.hotel.gateway.service.HotelOrdefStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @name: HotelOrderScheduler
 * @author: lucifinier
 * @date: 2018/5/16 17:42
 * @description: TODO
 */
@Slf4j
@Component
public class HotelOrderScheduler {
    @Autowired
    HotelOrdefStatusService hotelOrdefStatusService;
    /**
     * @Description:每分钟执行一次
     * @author:郑鹏宇
     * @date:2018/4/19
     */
/*    @Scheduled(fixedRate = 60000)
    public void handleExpireOrder() {
        try {
            hotelOrdefStatusService.handleExpireOrder();
        } catch (Exception e) {
            log.error("handle expire order failed.", e);
        }
    }*/
}
