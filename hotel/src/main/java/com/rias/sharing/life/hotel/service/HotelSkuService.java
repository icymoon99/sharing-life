package com.rias.sharing.life.hotel.service;

import com.rias.sharing.life.hotel.vo.HotelSkuDetailVo;
import com.rias.sharing.life.hotel.vo.HotelSkuQueryVo;

/**
 * @name: HotelSkuService
 * @author: lucifinier
 * @date: 2018/5/23 15:20
 * @description: TODO
 */
public interface HotelSkuService {
    HotelSkuDetailVo getHotelSkuDetail(HotelSkuQueryVo queryVo);
}
