package com.rias.sharing.life.hotel;

import com.rias.sharing.life.hotel.dao.*;
import com.rias.sharing.life.hotel.service.HotelSkuService;
import com.rias.sharing.life.hotel.vo.HotelSkuDetailVo;
import com.rias.sharing.life.hotel.module.HotelSkuQueryVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelCoreApplicationTests {
    @Autowired
    private HotelSkuDao dao;
    @Autowired
    private HotelSkuImgDao imgDao;
    @Autowired
    private HotelSkuListingPriceDao priceDao;
    @Autowired
    private HotelSkuFacilityDao facilityDao;
    @Autowired
    private HotelSkuDailyStatusDao statusDao;
    @Autowired
    private HotelSkuService skuService;

    @Test
    public void contextLoads() {
    }

}
