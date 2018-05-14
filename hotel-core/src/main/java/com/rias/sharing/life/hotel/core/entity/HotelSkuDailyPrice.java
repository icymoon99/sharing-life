package com.rias.sharing.life.hotel.core.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @name: HotelSkuPrice
 * @author: lucifinier
 * @date: 2018/5/6 14:13
 * @description: 酒店日价格
 */
@Data
public class HotelSkuDailyPrice {
    /**
     * id
     */
    private Long id;
    /**
     * sku id
     */
    private Long sku_id;
    /**
     * 日期
     */
    private LocalDate date;
    /**
     * 价格
     */
    private Integer price;
}
