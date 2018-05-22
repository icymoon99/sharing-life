package com.rias.sharing.life.hotel.dao;

import com.rias.sharing.life.hotel.dao.mapper.HotelSkuListingPriceMapper;
import com.rias.sharing.life.hotel.entity.HotelSkuListingPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @name: HotelSkuListingPriceDao
 * @author: lucifinier
 * @date: 2018/5/22 17:29
 * @description: TODO
 */
@Repository
public class HotelSkuListingPriceDao {
    @Autowired
    private HotelSkuListingPriceMapper mapper;

    public List<HotelSkuListingPrice> getByskuId(Long skuId) {
        return mapper.getByskuId(skuId);
    }
}
