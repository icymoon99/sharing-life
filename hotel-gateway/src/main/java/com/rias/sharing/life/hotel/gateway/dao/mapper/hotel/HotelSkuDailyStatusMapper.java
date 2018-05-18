package com.rias.sharing.life.hotel.gateway.dao.mapper.hotel;

import com.rias.sharing.life.hotel.gateway.entity.HotelSkuDailyStatus;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;

/**
 * @name: HotelSkuDailyStatusMapper
 * @author: lucifinier
 * @date: 2018/5/14 17:42
 * @description: TODO
 */
public interface HotelSkuDailyStatusMapper {
    @Insert("<script>" +
            "INSERT INTO hotel_sku_daily_status(id,sku_id,date,status) VALUES " +
            "<foreach collection='list' item='item'  separator=','>" +
            "(#{item.id},#{item.skuId},#{item.date},#{item.status})" +
            "</foreach>" +
            "</script>")
    void createDailyStatus(List<HotelSkuDailyStatus> list);

    @Delete("<script> " +
            "delete from hotel_sku_daily_status where sku_id = #{skuId} and date in" +
            "<foreach collection='list' item='item' open='(' separator=',' close=')'>" +
            "#{item}" +
            "</foreach>" +
            "</script>")
    void deleteOrderDailyStatus(@Param(value = "skuId") Long skuId, @Param(value = "list") List<LocalDate> list);

    @Delete("<script> " +
            "DELETE FROM hotel_sku_daily_status WHERE sku_id IN " +
            "<foreach collection='skuIds' item='skuId' open='(' separator=',' close=')'>" +
            "#{skuId}" +
            "</foreach>" +
            " AND date IN " +
            "<foreach collection='dates' item='date' open='(' separator=',' close=')'>" +
            "#{date}" +
            "</foreach>" +
            "</script>")
    void deleteOrdersDailyStatus(@Param(value = "skuIds") List<Long> skuIds, @Param(value = "dates") List<LocalDate> dates);

    @Update("<script> " +
            "update hotel_sku_daily_status set status = #{status} where sku_id = #{skuId} and date in" +
            "<foreach collection='list' item='item' open='(' separator=',' close=')'>" +
            "#{item}" +
            "</foreach>" +
            "</script>")
    void modifyDailyStatus(@Param(value = "skuId") Long skuId, @Param(value = "status") Integer status,
                           @Param(value = "list") List<LocalDate> list);
}
