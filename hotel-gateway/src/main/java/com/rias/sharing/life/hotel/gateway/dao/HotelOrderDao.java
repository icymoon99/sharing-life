package com.rias.sharing.life.hotel.gateway.dao;

import com.rias.sharing.life.hotel.gateway.dao.mapper.order.HotelOrderMapper;
import com.rias.sharing.life.hotel.gateway.entity.HotelOrder;
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

    public void modifyOrderStatusById(long id, int status) {
        mapper.modifyOrderStatusById(id, status);
    }

    public HotelOrder getById(Long id) {
        return mapper.getById(id);
    }
}
