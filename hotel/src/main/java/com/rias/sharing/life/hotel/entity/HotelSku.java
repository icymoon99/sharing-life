package com.rias.sharing.life.hotel.entity;

import lombok.Data;

/**
 * @Description:酒店属性表
 * @author:郑鹏宇
 * @date:2018/3/19
 */
@Data
public class HotelSku {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 酒店名称
     */
    private String skuName;
    /**
     * 酒店位置编号
     */
    private Long regionId;
    /**
     * 酒店地址
     */
    private String address;
    /**
     * 酒店位置经度，单位0.000001
     */
    private Integer lng;
    /**
     * 酒店位置维度，单位0.000001
     */
    private Integer lat;
    /**
     * 商户id
     */
    private Long merchantId;
    /**
     * 房间价格 单位0.01元（默认价格/首日价格）
     */
    private Integer roomPrice;
    /**
     * 房间押金 单位0.01元
     */
    private Integer roomBond;
    /**
     * 房间状态（默认状态/总状态）
     */
    private Integer roomStatus;
    /**
     * 是否上架
     */
    private Boolean onSale;
    /**
     * 标签
     */
    private Long tagId;
}
