package com.rias.sharing.life.hotel.gateway.dao;

import com.rias.sharing.life.hotel.gateway.dao.mapper.order.HotelOrderMapper;
import com.rias.sharing.life.hotel.gateway.entity.HotelOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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

    public void createHotelOrder(HotelOrder order) {
        mapper.createOrder(order);
    }

    public HotelOrder getById(Long id) {
        return mapper.getById(id);
    }

    public List<HotelOrder> getByStatus(Integer status) {
        return mapper.getByStatus(status);
    }

    public void modifyOrderStatusById(long id, int status) {
        mapper.modifyOrderStatusById(id, status);
    }

    public void modifyOrderStatusByIds(List<Long> ids, int status) {
        mapper.modifyOrderStatusByIds(ids, status);
    }

    public List<HotelOrder> getExpriedOrder(Integer status, LocalDateTime time) {
        return mapper.getExpriedOrder(status, time);
    }

}
