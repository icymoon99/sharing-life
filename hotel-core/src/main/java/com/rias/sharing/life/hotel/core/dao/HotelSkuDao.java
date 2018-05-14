package com.rias.sharing.life.hotel.core.dao;

import com.rias.sharing.life.hotel.core.dao.mapper.HotelSkuMapper;
import com.rias.sharing.life.hotel.core.entity.HotelSku;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

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

    List<HotelSku> getHotelSkuByIdAndDate(Long id, LocalDate startDate, LocalDate endDate) {
        return mapper.getHotelSkuByIdAndDate(id, startDate, endDate);
    }
}
