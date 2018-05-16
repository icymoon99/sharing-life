package com.rias.sharing.life.hotel.gateway.dao;

import com.rias.sharing.life.hotel.gateway.dao.mapper.hotel.HotelSkuDailyStatusMapper;
import com.rias.sharing.life.hotel.gateway.entity.HotelSkuDailyStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

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

    public void createDailyStatus(List<HotelSkuDailyStatus> statuses) {
        mapper.createDailyStatus(statuses);
    }

    public void deleteDailyStatus(Long skuId, List<LocalDate> dates) {
        mapper.deleteDailyStatus(skuId, dates);
    }

    public void modifyDailyStatus(Long skuId, Integer status, List<LocalDate> dates) {
        mapper.modifyDailyStatus(skuId, status, dates);
    }
}
