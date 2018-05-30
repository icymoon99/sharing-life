package com.rias.sharing.life.hotel.dao;

import com.rias.sharing.life.hotel.dao.mapper.HotelSkuImgMapper;
import com.rias.sharing.life.hotel.entity.HotelSkuImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @name: HotelSkuImgDao
 * @author: lucifinier
 * @date: 2018/5/22 17:17
 * @description: TODO
 */
@Repository
public class HotelSkuImgDao {
    @Autowired
    private HotelSkuImgMapper mapper;

    public List<HotelSkuImg> getBySkuId(Long skuId) {
        return mapper.getBySkuId(skuId);
    }

    public void save(List<HotelSkuImg> imgs) {
        mapper.save(imgs);
    }
}
