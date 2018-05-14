package com.rias.sharing.life.hotel.gateway.dao.mapper.order;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


/**
 * @Description:订单DAO
 * @author:张磊
 * @date:2018/4/13
 */
public interface HotelOrderMapper {
    /**
     * @Description:修改订单状态
     * @author:郑鹏宇
     * @date:2018/4/16
     */
    @Update("update hotel_order set order_status = #{status} where id =#{id}")
    void modifyOrderStatusById(@Param(value = "id") long id, @Param(value = "status") int status);

}


