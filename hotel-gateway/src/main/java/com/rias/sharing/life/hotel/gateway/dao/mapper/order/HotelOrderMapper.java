package com.rias.sharing.life.hotel.gateway.dao.mapper.order;

import com.rias.sharing.life.hotel.gateway.entity.HotelOrder;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * @Description:订单DAO
 * @author:张磊
 * @date:2018/4/13
 */
public interface HotelOrderMapper {

    @Insert("INSERT INTO hotel_order " +
            "(id,version,creator,create_time,editor,edit_time,is_delete,remark,user_id,sku_id,sku_price," +
            "sku_bond,start_date,end_date,merchant_id,occupant_name,occupant_id_card,occupant_phone," +
            "durations_day,status,expire_time) " +
            "VALUES " +
            "(#{id},#{version},#{creator},#{createTime},#{editor},#{editTime},#{isDelete} ,#{remark}," +
            "#{userId},#{skuId},#{skuPrice},#{skuBond},#{startDate},#{endDate},#{merchantId},#{occupantName}," +
            "#{occupantCard},#{occupantPhone},#{durationsDay},#{status},#{expireTime})")
    void createOrder(HotelOrder order);

    @Select("SELECT * FROM hotel_order WHERE id = #{id} AND is_delete = false")
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

    @Select("SELECT * FROM hotel_order WHERE status = #{status} AND is_delete = false")
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
    List<HotelOrder> getByStatus(Integer status);

    @Update("update hotel_order set status = #{status} where id =#{id}")
    void modifyOrderStatusById(@Param(value = "id") long id, @Param(value = "status") int status);

    @Update("<script> " +
            "update hotel_order set status = #{status} where id in " +
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    void modifyOrderStatusByIds(@Param(value = "ids") List<Long> ids, @Param(value = "status") Integer status);


    @Select("SELECT * FROM hotel_order WHERE expire_time < #{time} and status=#{orderStatus}")
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
    List<HotelOrder> getExpriedOrder(@Param(value = "orderStatus") Integer orderStatus, @Param(value = "time") LocalDateTime time);
}


