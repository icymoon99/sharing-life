package com.rias.sharing.life.hotel.service.impl;

import com.rias.sharing.life.common.exception.GlobalException;
import com.rias.sharing.life.common.result.CodeMsg;
import com.rias.sharing.life.common.util.SnowFlakeUtil;
import com.rias.sharing.life.hotel.dao.*;
import com.rias.sharing.life.hotel.entity.*;
import com.rias.sharing.life.hotel.service.HotelSkuService;
import com.rias.sharing.life.hotel.vo.HotelSkuDetailVo;
import com.rias.sharing.life.hotel.module.HotelSkuQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private SnowFlakeUtil snowFlakeUtil;
    @Autowired
    private HotelSkuDao skuDao;
    @Autowired
    private HotelSkuImgDao imgDao;
    @Autowired
    private HotelSkuFacilityDao facilityDao;
    @Autowired
    private HotelSkuDailyStatusDao dailyStatusDao;
    @Autowired
    private HotelSkuListingPriceDao listingPriceDao;

    @Override
    public HotelSkuDetailVo getHotelSkuDetail(HotelSkuQueryVo queryVo) {
        HotelSku sku = skuDao.getById(queryVo.getId());

        List<HotelSkuImg> imgs = imgDao.getBySkuId(queryVo.getId());

        List<HotelSkuFacility> facilities = facilityDao.getBySkuId(queryVo.getId());

        List<HotelSkuDailyStatus> dailyStatuses = dailyStatusDao.getBySkuId(
                queryVo.getId(), queryVo.getStartDate(), queryVo.getEndDate());

        List<HotelSkuListingPrice> listingPrices = listingPriceDao.getBySkuId(
                queryVo.getId(), queryVo.getStartDate(), queryVo.getEndDate());


        HotelSkuDetailVo vo = HotelSkuDetailVo.make(
                queryVo.getStartDate(), queryVo.getEndDate(),
                sku, imgs, facilities, dailyStatuses, listingPrices);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = { RuntimeException.class })
    public void createHotelSkuDetail(HotelSkuDetailVo vo) {
        // 幂等性判断
        HotelSku sku = skuDao.getById(vo.getId());
        if (null != sku) {
            throw new GlobalException(CodeMsg.SKU_DUPLICATE_KEY);
        }

        sku = HotelSkuDetailVo.makeSku(vo);
        skuDao.save(sku);

        List<HotelSkuImg> imgs = HotelSkuDetailVo.makeImg(vo);
        imgs.stream().forEach(img -> img.setId(snowFlakeUtil.creatId()));
        imgDao.save(imgs);

        List<HotelSkuFacility> facilities = HotelSkuDetailVo.makeFacility(vo);
        facilities.stream().forEach(facility -> facility.setId(snowFlakeUtil.creatId()));
        facilityDao.save(facilities);
    }
}
