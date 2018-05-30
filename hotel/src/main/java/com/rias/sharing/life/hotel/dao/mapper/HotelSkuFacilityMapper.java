package com.rias.sharing.life.hotel.dao.mapper;

import com.rias.sharing.life.hotel.entity.HotelSkuFacility;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @name: HotelSkuFacilityMapper
 * @author: lucifinier
 * @date: 2018/5/22 17:35
 * @description: TODO
 */
public interface HotelSkuFacilityMapper {
    @Select("SELECT * FROM hotel_sku_facility WHERE sku_id = #{skuId}")
    @Results({
            @Result(column = "sku_id", property = "skuId"),
            @Result(column = "facility_id", property = "facilityId")
    })
    List<HotelSkuFacility> getBySkuId(Long skuId);

    @Insert("<script> " +
            "INSERT INTO hotel_sku_facility (id,sku_id,facility_id) VALUES " +
            "<foreach collection='facilityList' item='item'  separator=',' >" +
            "(#{item.id},#{item.skuId},#{item.facilityId})" +
            "</foreach>" +
            "</script>")
    void save(@Param(value = "facilityList") List<HotelSkuFacility> facilities);
}
