package com.rias.sharing.life.hotel.dao;

import com.rias.sharing.life.hotel.dao.mapper.HotelSkuDailyStatusMapper;
import com.rias.sharing.life.hotel.entity.HotelSkuDailyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * @name: HotelSkuDailyStatusDao
 * @author: lucifinier
 * @date: 2018/5/22 17:41
 * @description: TODO
 */
@Repository
public class HotelSkuDailyStatusDao {
    @Autowired
    private HotelSkuDailyStatusMapper mapper;

    public List<HotelSkuDailyStatus> getBySkuId(Long skuId, LocalDate startDate, LocalDate endDate) {
        return mapper.getBySkuId(skuId, startDate, endDate);
    }
}
