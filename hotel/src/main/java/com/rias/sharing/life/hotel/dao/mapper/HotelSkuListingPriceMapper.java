package com.rias.sharing.life.hotel.dao.mapper;

import com.rias.sharing.life.hotel.entity.HotelSkuListingPrice;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * @name: HotelSkuListingPriceMapper
 * @author: lucifinier
 * @date: 2018/5/22 17:27
 * @description: TODO
 */
public interface HotelSkuListingPriceMapper {
    @Select("SELECT * FROM hotel_sku_listing_price WHERE sku_id = #{skuId} AND date >= #{startDate} AND date < #{endDate}")
    @Results({
            @Result(column = "sku_id", property = "skuId"),
    })
    List<HotelSkuListingPrice> getBySkuId(@Param("skuId") Long skuId,
                                          @Param("startDate") LocalDate startDate,
                                          @Param("endDate") LocalDate endDate);
}
