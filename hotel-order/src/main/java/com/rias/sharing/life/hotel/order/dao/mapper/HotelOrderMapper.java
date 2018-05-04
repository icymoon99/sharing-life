package com.rias.sharing.life.hotel.order.dao.mapper;

import com.rias.sharing.life.hotel.order.entity.HotelOrder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:订单DAO
 * @author:张磊
 * @date:2018/4/13
 */
@Mapper
@Repository
public interface HotelOrderMapper {
    @Select("SELECT id," +
            "remark,user_id,sku_id,sku_price,sku_bond,start_date,end_date,merchant_id," +
            "occupant_name,occupant_id_card,occupant_phone,order_status,expire_time " +
            "from hotel_order where id = #{id} and is_delete = false")
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
            @Result(property = "duration_stay", column = "durationStay"),
            @Result(property = "status", column = "order_status"),
            @Result(property = "expireTime", column = "expire_time")
    })
    HotelOrder getOrderById(String id);

    @Insert("INSERT INTO hotel_order " +
            "(id,version,creator,create_time,editor,edit_time,is_delete,remark,user_id,sku_id,sku_price," +
            "sku_bond,start_date,end_date,merchant_id,occupant_name,occupant_id_card,occupant_phone," +
            "duration_stay,order_status,expire_time) " +
            "VALUES " +
            "(#{id},#{version},#{creator},#{createTime},#{editor},#{editTime},#{isDelete} ,#{remark}," +
            "#{userId},#{skuId},#{skuPrice},#{skuBond},#{startDate},#{endDate},#{merchantId},#{occupantName}," +
            "#{occupantCard},#{occupantPhone},#{durationStay},#{status},#{expireTime})")
    void createHotelOrder(HotelOrder order);

    @Select("SELECT COUNT(id) FROM hotel_order where user_id = #{userId} AND order_status = #{status}")
    int getOrderNumByStatus(@Param(value = "userId") String userId, @Param(value = "status") Integer status);

    @Select("<script> " +
            "SELECT a.id,a.remark,a.user_id,a.sku_id,a.sku_price,a.sku_bond,a.start_date,a.end_date,a.merchant_id," +
            "a.occupant_name,a.occupant_id_card,a.occupant_phone,a.order_status,a.expire_time,b.sku_name,b.address " +
            "from hotel_order a LEFT JOIN hotel_sku b on a.sku_id = b.id " +
            "where a.user_id = #{userId} and a.is_delete = false  " +
            "</script>")
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
            @Result(property = "status", column = "order_status"),
            @Result(property = "skuName", column = "sku_name"),
            @Result(property = "expireTime", column = "expire_time")
    })
    List<HotelOrder> getOrdersByUserId(@Param(value = "userId") String userId);

    /**
     * @Description:修改订单状态
     * @author:郑鹏宇
     * @date:2018/4/16
     */
    @Update("update hotel_order set order_status = #{status} where id =#{id}")
    int upOrderStatusById(@Param(value = "id") String id, @Param(value = "status") Integer status);


}


