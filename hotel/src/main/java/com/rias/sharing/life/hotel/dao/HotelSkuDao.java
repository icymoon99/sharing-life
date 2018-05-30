package com.rias.sharing.life.hotel.dao;

import com.rias.sharing.life.hotel.dao.mapper.HotelSkuMapper;
import com.rias.sharing.life.hotel.entity.HotelSku;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @name: HotelSkuDao
 * @author: lucifinier
 * @date: 2018/5/7 15:31
 * @description: TODO
 */
@Slf4j
@Repository
public class HotelSkuDao {
    @Autowired
    HotelSkuMapper mapper;

    public HotelSku getById(Long id) {
        return mapper.getById(id);
    }

    public void save(HotelSku sku) {
        mapper.save(sku);
    }
}
