package com.rias.sharing.life.hotel.gateway.controller;

import com.rias.sharing.life.hotel.gateway.result.Result;
import com.rias.sharing.life.hotel.gateway.service.HotelOrdefStatusService;
import com.rias.sharing.life.hotel.gateway.vo.HotelOrderStatusVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @name: HotelOrderController
 * @author: lucifinier
 * @date: 2018/5/15 09:54
 * @description: TODO
 */
@Api(tags="订单网关服务的controller")
@RestController
@Slf4j
@RequestMapping("/hotel/order/status")
public class HotelOrderStatusController {
    @Autowired
    private HotelOrdefStatusService hotelOrdefStatusService;

    @ApiOperation(value="修改订单状态", notes="修改订单状态")
    @PutMapping
    public Result<String> ModifyOrderStatus(
            @ApiParam(name = "hotelOrderCreatingVo", value = "订单模型")
            @Valid @RequestBody() HotelOrderStatusVo statusVo) {
        hotelOrdefStatusService.ModifyOrderStatus(statusVo);

        return Result.success();
    }
}
