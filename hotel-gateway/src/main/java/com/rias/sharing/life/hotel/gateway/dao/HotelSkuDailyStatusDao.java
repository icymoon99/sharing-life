package com.rias.sharing.life.hotel.gateway.dao;

import com.rias.sharing.life.hotel.gateway.dao.mapper.hotel.HotelSkuDailyStatusMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @name: HotelSkuDailyStatusDao
 * @author: lucifinier
 * @date: 2018/5/14 17:49
 * @description: TODO
 */
@Slf4j
@Repository
public class HotelSkuDailyStatusDao {
    @Autowired
    HotelSkuDailyStatusMapper mapper;

    public void modifyHotelStatusByIdAndDate(long id, int status) {
        mapper.modifyHotelStatusByIdAndDate(id, status);
    }
}
