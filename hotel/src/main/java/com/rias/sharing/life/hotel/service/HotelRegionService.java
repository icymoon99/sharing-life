package com.rias.sharing.life.hotel.service;


import com.rias.sharing.life.hotel.entity.HotelRegion;

import java.util.List;

/**
 * @Description:
 * @author:郑鹏宇
 * @date: 2018/3/26
 */
public interface HotelRegionService {

    List<HotelRegion> getSubRegions(long pId, boolean isAll);
}
