package com.rias.sharing.life.hotel.gateway.vo;

import com.rias.sharing.life.hotel.gateway.entity.HotelOrder;
import lombok.Data;

/**
 * @Description:订单成功后返回的数据
 * @author:郑鹏宇
 * @date: 2018/4/25
 */
@Data
public class HotelOrderCreatedVo {

    /**
     * 状态
     */
    private Integer status;

    /**
     * 房间id
     */
    private Long skuId;

    /**
     * 订单id
     */
    private Long OrderId;

    /**
     * 商户id
     */
    private  Long merchantId;

    public static HotelOrderCreatedVo make(HotelOrder order) {
        HotelOrderCreatedVo vo = new HotelOrderCreatedVo();

        vo.setOrderId(order.getId());
        vo.setSkuId(order.getSkuId());
        vo.setMerchantId(order.getMerchantId());
        vo.setStatus(vo.getStatus());

        return vo;
    }
}
