package com.rias.sharing.life.hotel.gateway.service.impl;

import com.rias.sharing.life.hotel.gateway.constant.HotelOrderStatusEnum;
import com.rias.sharing.life.hotel.gateway.constant.HotelRoomStatusEnum;
import com.rias.sharing.life.hotel.gateway.dao.HotelOrderDao;
import com.rias.sharing.life.hotel.gateway.dao.HotelSkuDailyStatusDao;
import com.rias.sharing.life.hotel.gateway.entity.HotelOrder;
import com.rias.sharing.life.hotel.gateway.service.HotelOrdefStatusService;
import com.rias.sharing.life.hotel.gateway.util.DateUtil;
import com.rias.sharing.life.hotel.gateway.vo.HotelOrderStatusVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @name: HotelOrderStatusServiceImpl
 * @author: lucifinier
 * @date: 2018/5/15 09:58
 * @description: TODO
 */
@Service
@Slf4j
public class HotelOrderStatusServiceImpl implements HotelOrdefStatusService {
    @Autowired
    private HotelOrderDao hotelOrderDao;
    @Autowired
    private HotelSkuDailyStatusDao hotelSkuDailyStatusDao;

    @Override
    @Transactional(transactionManager = "xatx", rollbackFor = { java.lang.RuntimeException.class })
    public void modifyOrderStatus(HotelOrderStatusVo statusVo) {

        // 修改订单表状态
        hotelOrderDao.modifyOrderStatusById(statusVo.getId(), statusVo.getStatus());

        // 将索引转换为枚举
        HotelOrderStatusEnum statusEnum = HotelOrderStatusEnum.getByIndex(statusVo.getStatus());

        // 生成修改房态所需的数据
        HotelOrder order = hotelOrderDao.getById(statusVo.getId());
        List<LocalDate> dates = DateUtil.getDates(order.getStartDate(), order.getEndDate());

        switch (statusEnum) {
            case CHECK_OUT:
                hotelSkuDailyStatusDao.modifyDailyStatus(order.getSkuId(), HotelRoomStatusEnum.DIRTY.getIndex(), dates);
                break;
            case EXPRIED:
                hotelSkuDailyStatusDao.deleteOrderDailyStatus(order.getSkuId(), dates);
                break;
            case CANCEL:
                hotelSkuDailyStatusDao.deleteOrderDailyStatus(order.getSkuId(), dates);
                break;
        }
    }

    @Override
    @Transactional(transactionManager = "xatx", rollbackFor = { java.lang.RuntimeException.class })
    public void handleExpireOrder() {
        List<HotelOrder> orders = hotelOrderDao.getExpriedOrder(
                HotelOrderStatusEnum.UNPAID.getIndex(), LocalDateTime.now());

        //  更新订单状态
        List<Long> orderIds = orders.stream()
                .map(order -> order.getId())
                .collect(Collectors.toList());
        hotelOrderDao.modifyOrderStatusByIds(orderIds, HotelOrderStatusEnum.EXPRIED.getIndex());

        // 更新房态
        List<Long> skuIds = orders.stream()
                .map(order -> order.getSkuId())
                .collect(Collectors.toList());
        List<LocalDate> dates = orders.stream()
                .map(order -> DateUtil.getDates(order.getStartDate(), order.getEndDate()))
                .flatMap(orderDates -> orderDates.stream())
                .distinct()
                .collect(Collectors.toList());
        hotelSkuDailyStatusDao.deleteOrdersDailyStatus(skuIds, dates);
    }
}
