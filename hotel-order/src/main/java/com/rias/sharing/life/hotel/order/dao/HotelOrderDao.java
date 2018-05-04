package com.rias.sharing.life.hotel.order.dao;

import com.rias.sharing.life.hotel.order.dao.mapper.HotelOrderMapper;
import com.rias.sharing.life.hotel.order.entity.HotelOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @name: HotelOrderDao
 * @author: lucifinier
 * @date: 2018/5/3 19:45
 * @description: TODO
 */
@Slf4j
@Repository
public class HotelOrderDao {
    @Autowired
    HotelOrderMapper mapper;

    public void createHotelOrder(HotelOrder order) {
        mapper.createHotelOrder(order);
    }

    public HotelOrder getOrderById(String id) {
        return mapper.getOrderById(id);
    }
}
