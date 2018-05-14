package com.rias.sharing.life.hotel.dao.mapper;

import org.apache.ibatis.jdbc.SQL;

import java.time.LocalDate;

/**
 * @name: HotelSkuProvider
 * @author: lucifinier
 * @date: 2018/5/7 15:17
 * @description: TODO
 */
public class HotelSkuProvider {
    public String getHotelSkuByIdAndDate(Long id, LocalDate startDate, LocalDate endDate) {
        return new SQL() {{
            SELECT("HS.id,HS.room_bond,HS.sku_name,HS.address,HS.lng,HS.lat,HS.merchant_id,HS.room_price");
            FROM("hotel_sku HS");
            LEFT_OUTER_JOIN("hotel_sku_facility HSF ON HS.id = HSF.sku_id");
            LEFT_OUTER_JOIN("hotel_sku_img HSI ON HS.id = HSI.sku_id");
            LEFT_OUTER_JOIN("hotel_sku_listing_price ON HP (HS.id = HP.id " +
                    "AND b.spec_date >= #{startDate} AND b.spec_date < #{endDate}");
            WHERE("HS.id = #{id}");
        }}.toString();
    }
}
