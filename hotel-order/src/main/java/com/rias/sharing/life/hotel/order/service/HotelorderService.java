package com.rias.sharing.life.hotel.order.service;

import com.rias.sharing.life.hotel.order.vo.HotelOrderCreatedVo;
import com.rias.sharing.life.hotel.order.vo.HotelOrderCreatingVo;

/**
 * @name: HotelorderService
 * @author: lucifinier
 * @date: 2018/5/3 19:50
 * @description: TODO
 */
public interface HotelorderService {
    HotelOrderCreatedVo creatHotelOrder(HotelOrderCreatingVo hotelOrderDto);
}
