package com.rias.sharing.life.hotel.gateway.dao.mapper.order;

import com.rias.sharing.life.hotel.gateway.entity.HotelOrder;
import org.apache.ibatis.annotations.*;


/**
 * @Description:订单DAO
 * @author:张磊
 * @date:2018/4/13
 */
public interface HotelOrderMapper {
    /**
     * @Description:修改订单状态
     * @author:郑鹏宇
     * @date:2018/4/16
     */
    @Update("update hotel_order set status = #{status} where id =#{id}")
    void modifyOrderStatusById(@Param(value = "id") long id, @Param(value = "status") int status);

    @Select("SELECT * FROM hotel_order where id = #{id}")
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
            @Result(property = "durationsDay", column = "durations_day"),
            @Result(property = "expireTime", column = "expire_time")
    })
    HotelOrder getById(Long id);
}


