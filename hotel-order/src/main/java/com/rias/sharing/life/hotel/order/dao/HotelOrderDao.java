package com.rias.sharing.life.hotel.order.dao;

import com.rias.sharing.life.hotel.order.dao.mapper.HotelOrderMapper;
import com.rias.sharing.life.hotel.order.entity.HotelOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public HotelOrder getById(Long id) {
        return mapper.getById(id);
    }

    public List<HotelOrder> getByUserId(Long userId) {
        return mapper.getByUserId(userId);
    }

    public int countByStatus(Long userId, Integer status) {
        return mapper.countByStatus(userId, status);
    }
}
