package com.rias.sharing.life.hotel.gateway.service.impl;

import com.rias.sharing.life.hotel.gateway.constant.HotelOrderStatusEnum;
import com.rias.sharing.life.hotel.gateway.constant.HotelRoomStatusEnum;
import com.rias.sharing.life.hotel.gateway.dao.HotelOrderDao;
import com.rias.sharing.life.hotel.gateway.dao.HotelSkuDailyStatusDao;
import com.rias.sharing.life.hotel.gateway.entity.HotelOrder;
import com.rias.sharing.life.hotel.gateway.entity.HotelSkuDailyStatus;
import com.rias.sharing.life.hotel.gateway.exception.GlobalException;
import com.rias.sharing.life.hotel.gateway.result.CodeMsg;
import com.rias.sharing.life.hotel.gateway.service.HotelorderService;
import com.rias.sharing.life.hotel.gateway.util.DateUtil;
import com.rias.sharing.life.hotel.gateway.util.SnowFlakeUtil;
import com.rias.sharing.life.hotel.gateway.vo.HotelOrderCreatedVo;
import com.rias.sharing.life.hotel.gateway.vo.HotelOrderCreatingVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private HotelOrderDao hotelOrderDao;
    @Autowired
    private HotelSkuDailyStatusDao hotelSkuDailyStatusDao;
    @Autowired
    private SnowFlakeUtil snowFlakeUtil;

    @Value("${hotel.order.expire-time}")
    private int orderExpireTime;

    /**
     * @Description:创建订单
     * @author:张磊
     * @date:2018/5/4
     */
    @Override
    @Transactional(transactionManager = "xatx", rollbackFor = { java.lang.RuntimeException.class })
    public HotelOrderCreatedVo creatHotelOrder(HotelOrderCreatingVo vo) {
        //幂等性判断
        HotelOrder order = hotelOrderDao.getOrderById(vo.getId());
        if (Optional.ofNullable(order).isPresent()) {
            throw new GlobalException(CodeMsg.REPEAT_ORDER_ID);
        }

        // 订单基本信息
        order = HotelOrderCreatingVo.make(vo);
        order.setStatus(HotelOrderStatusEnum.UNPAID.getIndex());
        order.setCreator(vo.getUserId());
        order.setEditor(vo.getUserId());
        //order.setMerchantId(skuSearchQueryDao.getMerchantById(dto.getSkuId()));
        order.setExpireTime(LocalDateTime.now().plusMinutes(orderExpireTime));

        hotelOrderDao.createHotelOrder(order);

        // 锁定房态
        List<LocalDate> dates = DateUtil.getDates(order.getStartDate(), order.getEndDate());
        final Long skuId = order.getSkuId();
        List<HotelSkuDailyStatus> statuses = dates.stream()
                .map(date -> {
                    HotelSkuDailyStatus status = new HotelSkuDailyStatus();
                    status.setId(snowFlakeUtil.creatId());
                    status.setSkuId(skuId);
                    status.setDate(date);
                    status.setStatus(HotelRoomStatusEnum.SALED.getIndex());
                    return status;
                }).collect(Collectors.toList());
        hotelSkuDailyStatusDao.createDailyStatus(statuses);

        return HotelOrderCreatedVo.make(order);
    }
}
