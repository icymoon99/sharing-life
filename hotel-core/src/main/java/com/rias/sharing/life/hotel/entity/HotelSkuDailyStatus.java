package com.rias.sharing.life.hotel.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @name: HotelSkuDailyStatus
 * @author: lucifinier
 * @date: 2018/5/6 14:25
 * @description: TODO
 */
@Data
public class HotelSkuDailyStatus {
    /**
     * id
     */
    private Long id;
    /**
     * sku id
     */
    private Long SkuId;
    /**
     * 日期
     */
    private LocalDate date;
    /**
     * 状态
     */
    private Integer status;
}
