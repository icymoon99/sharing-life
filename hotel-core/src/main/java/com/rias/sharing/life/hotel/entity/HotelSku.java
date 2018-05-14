package com.rias.sharing.life.hotel.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

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
     * 版本号默认为0
     */
    private Integer version = 0;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private LocalDateTime createTime = LocalDateTime.now();
    /**
     * 修改人
     */
    private String editor;
    /**
     * 修改时间
     */
    private LocalDateTime editTime = LocalDateTime.now();
    /**
     * 描述
     */
    private String remark;
    /**
     * 是否删除
     */
    private Boolean isDelete = Boolean.FALSE;
    /**
     * 酒店名称
     */
    private String skuName;
    /**
     * 商户id
     */
    private Long merchantId;
    /**
     * 酒店地址
     */
    private String address;
    /**
     * 酒店位置编号
     */
    private Long regionId;
    /**
     * 酒店位置经度，单位0.000001
     */
    private Long lng;
    /**
     * 酒店位置维度，单位0.000001
     */
    private Long lat;
    /**
     * 房间价格（默认价格/首日价格）
     */
    private Integer roomPrice;
    /**
     * 房间状态（默认状态/总状态）
     */
    private Integer roomStatus;
    /**
     * 是否上架
     */
    private Boolean onSale;
    /**
     * 房间设施
     */
    List<HotelSkuFacility> facilities;
    /**
     * 日价
     */
    List<HotelSkuDailyPrice> dailyPrices;
    /**
     * 日状态
     */
    List<HotelSkuDailyStatus> dailyStatuses;
}