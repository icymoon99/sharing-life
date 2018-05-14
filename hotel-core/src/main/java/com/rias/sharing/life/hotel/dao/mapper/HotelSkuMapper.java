package com.rias.sharing.life.hotel.dao.mapper;

import com.rias.sharing.life.hotel.entity.HotelSku;
import org.apache.ibatis.annotations.SelectProvider;

import java.time.LocalDate;
import java.util.List;

/**
 * @name: HotelSkuMapper
 * @author: lucifinier
 * @date: 2018/5/7 14:56
 * @description: TODO
 */
public interface HotelSkuMapper {
    @SelectProvider(type = HotelSkuProvider.class, method = "getHotelSkuByIdAndDate")
    List<HotelSku> getHotelSkuByIdAndDate(Long id, LocalDate startDate, LocalDate endDate);
}
