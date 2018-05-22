package com.rias.sharing.life.hotel.dao.mapper;

import com.rias.sharing.life.hotel.entity.HotelSkuFacility;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
    List<HotelSkuFacility> getByskuId(Long skuId);
}
