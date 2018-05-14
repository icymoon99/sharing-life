package com.rias.sharing.life.hotel.order.service.impl;

import com.rias.sharing.life.hotel.order.constant.OrderStatusEnum;
import com.rias.sharing.life.hotel.order.dao.HotelOrderDao;
import com.rias.sharing.life.hotel.order.entity.HotelOrder;
import com.rias.sharing.life.hotel.order.exception.GlobalException;
import com.rias.sharing.life.hotel.order.result.CodeMsg;
import com.rias.sharing.life.hotel.order.service.HotelorderService;
import com.rias.sharing.life.hotel.order.vo.HotelOrderCreatedVo;
import com.rias.sharing.life.hotel.order.vo.HotelOrderCreatingVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @name: HotelorderServiceImpl
 * @author: lucifinier
 * @date: 2018/5/4 09:34
 * @description: TODO
 */
@Slf4j
@Service
public class HotelorderServiceImpl implements HotelorderService {
    @Autowired
    HotelOrderDao hotelOrderDao;

    @Value("${hotel.order.expire-time}")
    private int orderExpireTime;

    /**
     * @Description:创建订单
     * @author:张磊
     * @date:2018/5/4
     */
    @Override
    public HotelOrderCreatedVo creatHotelOrder(HotelOrderCreatingVo vo) {
        //幂等性判断
        HotelOrder order = hotelOrderDao.getOrderById(vo.getId());
        if (Optional.ofNullable(order).isPresent()) {
            throw new GlobalException(CodeMsg.REPEAT_ORDER_ID);
        }

        // 订单基本信息
        order = HotelOrderCreatingVo.make(vo);
        order.setStatus(OrderStatusEnum.UNPAID.getIndex());
        order.setCreator(vo.getUserId());
        order.setEditor(vo.getUserId());
        //order.setMerchantId(skuSearchQueryDao.getMerchantById(dto.getSkuId()));
        order.setExpireTime(LocalDateTime.now().plusMinutes(orderExpireTime));

        hotelOrderDao.createHotelOrder(order);

        return HotelOrderCreatedVo.make(order);
    }
}
