package com.rias.sharing.life.hotel.order.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Description:酒店订单模型
 * @author:张磊
 * @date:2018/4/13
 */
@Data
public class HotelOrder {
    /**
     * id
     */
    private String id;
    /**
     * 版本
     */
    private Integer version = 1;
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
     * 逻辑删除
     */
    private Boolean isDelete = false;
    /**
     * 备注
     */
    private String remark;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 房间id
     */
    private String skuId;
    /**
     * 房间名称
     */
    private String skuName;
    /**
     * 房间地址
     */
    private String address;
    /**
     * 房间总价
     */
    private Integer skuPrice;
    /**
     * 房间定金
     */
    private Integer skuBond;
    /**
     * 入住日期
     */
    private LocalDate startDate;
    /**
     * 退房日期
     */
    private LocalDate endDate;
    /**
     * 商户id
     */
    private String merchantId;
    /**
     * 入住人姓名
     */
    private String occupantName;
    /**
     * 入住人身份证
     */
    private String occupantCard;
    /**
     * 入住人电话
     */
    private String occupantPhone;
    /**
     * 入住天数
     */
    private String durationStay;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 支付过期时间
     */
    private LocalDateTime expireTime;
}
