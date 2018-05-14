package com.rias.sharing.life.hotel.dao;

import com.rias.sharing.life.hotel.dao.mapper.HotelRegionMapper;
import com.rias.sharing.life.hotel.entity.HotelRegion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @name: HotelRegionDao
 * @author: lucifinier
 * @date: 2018/5/6 12:03
 * @description: TODO
 */
@Slf4j
@Repository
public class HotelRegionDao {
    @Autowired
    private HotelRegionMapper mapper;

    public List<HotelRegion> getRegionById(long id) {
        return mapper.getRegionsByParentId(id);
    }
}
