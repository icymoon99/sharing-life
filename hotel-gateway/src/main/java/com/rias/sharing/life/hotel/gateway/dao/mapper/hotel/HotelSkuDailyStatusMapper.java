package com.rias.sharing.life.hotel.gateway.dao.mapper.hotel;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @name: HotelSkuDailyStatusMapper
 * @author: lucifinier
 * @date: 2018/5/14 17:42
 * @description: TODO
 */
public interface HotelSkuDailyStatusMapper {
    /**
     * @Description:更新房间状态
     * @author:张磊
     * @date:2018/5/14
     */
    @Update("update hotel_sku_daily_status set status = #{status} where id =#{id}")
    void modifyHotelStatusByIdAndDate(@Param(value = "id") long id, @Param(value = "status") int status);
}
