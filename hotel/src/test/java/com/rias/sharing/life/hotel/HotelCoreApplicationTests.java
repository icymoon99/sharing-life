package com.rias.sharing.life.hotel;

import com.rias.sharing.life.hotel.dao.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

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

    @Test
    public void contextLoads() {
        System.out.println(imgDao.getBySkuId(Long.valueOf(1)));
        System.out.println(priceDao.getBySkuId(Long.valueOf(1)));
        System.out.println(facilityDao.getBySkuId(Long.valueOf(1)));
        System.out.println(statusDao.getBySkuId(Long.valueOf(1), LocalDate.now(), LocalDate.now().plusDays(1)));
        System.out.println(dao.getById(Long.valueOf(1)));
    }

}
