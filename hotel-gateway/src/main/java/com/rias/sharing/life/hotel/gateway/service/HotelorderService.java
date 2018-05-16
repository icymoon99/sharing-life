package com.rias.sharing.life.hotel.gateway.service;


import com.rias.sharing.life.hotel.gateway.vo.HotelOrderCreatedVo;
import com.rias.sharing.life.hotel.gateway.vo.HotelOrderCreatingVo;

/**
 * @name: HotelorderService
 * @author: lucifinier
 * @date: 2018/5/3 19:50
 * @description: TODO
 */
public interface HotelorderService {
    HotelOrderCreatedVo creatHotelOrder(HotelOrderCreatingVo hotelOrderDto);
}
