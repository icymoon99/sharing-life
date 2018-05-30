package com.rias.sharing.life.hotel.dao.mapper;

import com.rias.sharing.life.hotel.entity.HotelSkuImg;
import org.apache.ibatis.annotations.*;

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
    List<HotelSkuImg> getBySkuId(Long skuId);

    @Insert("<script> " +
            "INSERT INTO hotel_sku_img (id,sku_id,img_url) VALUES " +
            "<foreach collection='imgList' item='item'  separator=',' >" +
            "(#{item.id},#{item.skuId},#{item.imgUrl})" +
            "</foreach>" +
            "</script>")
    void save(@Param(value = "imgList") List<HotelSkuImg> imgs);
}
