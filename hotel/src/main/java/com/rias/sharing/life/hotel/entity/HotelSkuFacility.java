package com.rias.sharing.life.hotel.entity;

import lombok.Data;

/**
 * @name: HotelSkuFacility
 * @author: lucifinier
 * @date: 2018/5/6 14:04
 * @description: 酒店设备表
 */
@Data
public class HotelSkuFacility {
    /**
     * id
     */
    private Long id;
    /**
     * sku id
     */
    private Long skuId;
    /**
     * 设备名称
     */
    private Integer facility;
}
