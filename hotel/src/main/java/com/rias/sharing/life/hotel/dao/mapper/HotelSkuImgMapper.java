package com.rias.sharing.life.hotel.dao.mapper;

import com.rias.sharing.life.hotel.entity.HotelSkuImg;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @name: HotelSkuImgMapper
 * @author: lucifinier
 * @date: 2018/5/22 17:16
 * @description: TODO
 */
public interface HotelSkuImgMapper {
    @Select("SELECT * FROM hotel_sku_img WHERE sku_id = #{skuId}")
    @Results({
            @Result(column = "sku_id", property = "skuId"),
            @Result(column = "img_url", property = "imgUrl")
    })
    List<HotelSkuImg> getByskuId(Long skuId);
}
