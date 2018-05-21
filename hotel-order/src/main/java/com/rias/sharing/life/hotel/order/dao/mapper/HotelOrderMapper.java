package com.rias.sharing.life.hotel.order.dao.mapper;

import com.rias.sharing.life.hotel.order.entity.HotelOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:订单DAO
 * @author:张磊
 * @date:2018/4/13
 */
public interface HotelOrderMapper {

    @Select("SELECT * FROM hotel_order WHERE id = #{id} and is_delete = false")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "skuId", column = "sku_id"),
            @Result(property = "skuPrice", column = "sku_price"),
            @Result(property = "skuBond", column = "sku_bond"),
            @Result(property = "startDate", column = "start_date"),
            @Result(property = "endDate", column = "end_date"),
            @Result(property = "merchantId", column = "merchant_id"),
            @Result(property = "occupantName", column = "occupant_name"),
            @Result(property = "occupantCard", column = "occupant_id_card"),
            @Result(property = "occupantPhone", column = "occupant_phone"),
            @Result(property = "durations_day", column = "durationsDay"),
            @Result(property = "expireTime", column = "expire_time")
    })
    HotelOrder getById(Long id);

    @Select("SELECT * FROM hotel_order WHERE user_id = #{userId} and is_delete = false" )
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "skuId", column = "sku_id"),
            @Result(property = "skuPrice", column = "sku_price"),
            @Result(property = "skuBond", column = "sku_bond"),
            @Result(property = "startDate", column = "start_date"),
            @Result(property = "endDate", column = "end_date"),
            @Result(property = "merchantId", column = "merchant_id"),
            @Result(property = "occupantName", column = "occupant_name"),
            @Result(property = "occupantCard", column = "occupant_id_card"),
            @Result(property = "occupantPhone", column = "occupant_phone"),
            @Result(property = "skuName", column = "sku_name"),
            @Result(property = "expireTime", column = "expire_time")
    })
    List<HotelOrder> getByUserId(@Param(value = "userId") Long userId);

    @Select("SELECT COUNT(id) FROM hotel_order WHERE user_id = #{userId} AND status = #{status}")
    int countByStatus(@Param(value = "userId") Long userId, @Param(value = "status") Integer status);
}


