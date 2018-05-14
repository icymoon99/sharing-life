package com.rias.sharing.life.hotel.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:默认地址的实体类
 * @author:郑鹏宇
 * @date: 2018/3/26
 */
@Data
public class HotelRegion implements Serializable{

    private static final long serialVersionUID = 7628371270559365197L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 位置名称
     */
    private String name;
    /**
     * 经度
     */
    private Integer lng;
    /**
     * 维度
     */
    private Integer lat;
    /**
     * 上一级id
     */
    private Long parentId;
    /**
     * 权重
     */
    private Integer weight;
}
