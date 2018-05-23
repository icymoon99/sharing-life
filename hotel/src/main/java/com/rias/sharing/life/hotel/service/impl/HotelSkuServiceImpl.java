package com.rias.sharing.life.hotel.service.impl;

import com.rias.sharing.life.hotel.dao.*;
import com.rias.sharing.life.hotel.entity.*;
import com.rias.sharing.life.hotel.service.HotelSkuService;
import com.rias.sharing.life.hotel.vo.HotelSkuDetailVo;
import com.rias.sharing.life.hotel.vo.HotelSkuQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @name: HotelSkuServiceImpl
 * @author: lucifinier
 * @date: 2018/5/23 15:21
 * @description: TODO
 */
@Service
@Slf4j
public class HotelSkuServiceImpl implements HotelSkuService {
    @Autowired
    HotelSkuDao skuDao;
    @Autowired
    HotelSkuImgDao imgDao;
    @Autowired
    HotelSkuFacilityDao facilityDao;
    @Autowired
    HotelSkuDailyStatusDao dailyStatusDao;
    @Autowired
    HotelSkuListingPriceDao listingPriceDao;

    @Override
    public HotelSkuDetailVo getHotelSkuDetail(HotelSkuQueryVo queryVo) {
        HotelSku sku = skuDao.getById(queryVo.getId());

        List<HotelSkuImg> imgs = imgDao.getBySkuId(queryVo.getId());

        List<HotelSkuFacility> facilities = facilityDao.getBySkuId(queryVo.getId());

        List<HotelSkuDailyStatus> dailyStatuses = dailyStatusDao.getBySkuId(
                queryVo.getId(), LocalDate.parse(queryVo.getStartDate()), LocalDate.parse(queryVo.getEndDate()));

        List<HotelSkuListingPrice> listingPrices = listingPriceDao.getBySkuId(
                queryVo.getId(), LocalDate.parse(queryVo.getStartDate()), LocalDate.parse(queryVo.getEndDate()));


        HotelSkuDetailVo vo = HotelSkuDetailVo.make(
                LocalDate.parse(queryVo.getStartDate()), LocalDate.parse(queryVo.getEndDate()),
                sku, imgs, facilities, dailyStatuses, listingPrices);

        return vo;
    }
}
