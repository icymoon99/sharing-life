package com.rias.sharing.life.hotel.dao.mapper;

import com.rias.sharing.life.hotel.entity.HotelSku;
import org.apache.ibatis.annotations.*;

/**
 * @name: HotelSkuMapper
 * @author: lucifinier
 * @date: 2018/5/7 14:56
 * @description: TODO
 */
public interface HotelSkuMapper {
    @Select("SELECT * FROM hotel_sku WHERE id = #{id}")
    @Results({
            @Result(column = "sku_name", property = "skuName"),
            @Result(column = "region_id", property = "regionId"),
            @Result(column = "merchant_id", property = "merchantId"),
            @Result(column = "room_price", property = "roomPrice"),
            @Result(column = "room_bond", property = "roomBond"),
            @Result(column = "room_status", property = "roomStatus"),
            @Result(column = "on_sale", property = "onSale"),
            @Result(column = "tag_id", property = "tagId")
    })
    HotelSku getById(@Param("id") Long id);

    @InsertProvider(type = HotelSkuProvider.class, method = "save")
    void save(HotelSku sku);
}
