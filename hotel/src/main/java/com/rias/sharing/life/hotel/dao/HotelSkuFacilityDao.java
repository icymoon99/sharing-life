package com.rias.sharing.life.hotel.dao;

import com.rias.sharing.life.hotel.dao.mapper.HotelSkuFacilityMapper;
import com.rias.sharing.life.hotel.entity.HotelSkuFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @name: HotelSkuFacilityDao
 * @author: lucifinier
 * @date: 2018/5/22 17:37
 * @description: TODO
 */
@Repository
public class HotelSkuFacilityDao {
    @Autowired
    private HotelSkuFacilityMapper mapper;

    public List<HotelSkuFacility> getBySkuId(Long skuId) {
        return mapper.getBySkuId(skuId);
    }

    public void save(List<HotelSkuFacility> facilities) {
        mapper.save(facilities);
    }
}
