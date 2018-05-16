package com.rias.sharing.life.hotel.gateway.controller;

import com.rias.sharing.life.hotel.gateway.result.Result;
import com.rias.sharing.life.hotel.gateway.service.HotelorderService;
import com.rias.sharing.life.hotel.gateway.vo.HotelOrderCreatedVo;
import com.rias.sharing.life.hotel.gateway.vo.HotelOrderCreatingVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @name: HotelOrderController
 * @author: lucifinier
 * @date: 2018/5/3 19:49
 * @description: TODO
 */
@Api(tags="订单服务的controller")
@RestController
@RequestMapping("/hotel/orders")
public class HotelOrderController {
    @Autowired
    private HotelorderService hotelorderService;

    /**
     * @Description:校验并生成订单
     * @author:张磊
     * @date:2018/4/13
     */
    @ApiOperation(value="校验并生成订单", notes="校验并生成订单")
    @PostMapping
    public Result<HotelOrderCreatedVo> creatHotelOrder(
            @ApiParam(name = "hotelOrderCreatingVo", value = "订单模型")
            @Valid @RequestBody() HotelOrderCreatingVo hotelOrderCreatingVo) {
        HotelOrderCreatedVo hotelOrderCreatedVo = hotelorderService.creatHotelOrder(hotelOrderCreatingVo);

        return Result.success(hotelOrderCreatedVo);
    }
}
