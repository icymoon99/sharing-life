package com.rias.sharing.life.hotel.dao.mapper;

import com.rias.sharing.life.hotel.entity.HotelSkuDailyStatus;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @name: HotelSkuDailyStatusMapper
 * @author: lucifinier
 * @date: 2018/5/22 17:39
 * @description: TODO
 */
public interface HotelSkuDailyStatusMapper {
    @Select("SELECT * FROM hotel_sku_daily_status WHERE sku_id = #{skuId}")
    @Results({
            @Result(column = "sku_id", property = "skuId"),
    })
    List<HotelSkuDailyStatus> getByskuId(Long skuId);
}
