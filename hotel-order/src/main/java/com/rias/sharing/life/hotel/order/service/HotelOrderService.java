package com.rias.sharing.life.hotel.order.service;

import com.rias.sharing.life.hotel.order.vo.HotelOrderDisplayVo;

/**
 * @name: HotelOrderService
 * @author: lucifinier
 * @date: 2018/5/19 16:56
 * @description: TODO
 */
public interface HotelOrderService {
    HotelOrderDisplayVo getHotelOrderById(long id);
}
