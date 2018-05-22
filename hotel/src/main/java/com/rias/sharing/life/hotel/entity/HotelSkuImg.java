package com.rias.sharing.life.hotel.entity;

import lombok.Data;

/**
 * @name: HotelSkuImg
 * @author: lucifinier
 * @date: 2018/5/6 14:11
 * @description: 酒店图片
 */
@Data
public class HotelSkuImg {
    /**
     * id
     */
    private Long id;
    /**
     * sku id
     */
    private Long skuId;
    /**
     * 图片地址
     */
    private String imgUrl;
}
