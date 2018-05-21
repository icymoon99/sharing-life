package com.rias.sharing.life.hotel.order.service.impl;

import com.rias.sharing.life.common.exception.GlobalException;
import com.rias.sharing.life.common.result.CodeMsg;
import com.rias.sharing.life.hotel.order.dao.HotelOrderDao;
import com.rias.sharing.life.hotel.order.entity.HotelOrder;
import com.rias.sharing.life.hotel.order.vo.HotelOrderDisplayVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @name: HotelorderServiceImpl
 * @author: lucifinier
 * @date: 2018/5/4 09:34
 * @description: TODO
 */
@Slf4j
@Service
public class HotelOrderService implements com.rias.sharing.life.hotel.order.service.HotelOrderService {
    @Autowired
    HotelOrderDao hotelOrderDao;

    @Override
    public HotelOrderDisplayVo getHotelOrderById(long id) {
        HotelOrder hotelOrder = hotelOrderDao.getById(id);
        if (!Optional.ofNullable(hotelOrder).isPresent()) {
            throw new GlobalException(CodeMsg.NO_ORDER_BY_ID);
        }

        // TODO 调用酒店服务查询房源信息

        // TODO 调用商户服务查询商户电话

        HotelOrderDisplayVo vo = new HotelOrderDisplayVo();

        return vo;
    }
}
