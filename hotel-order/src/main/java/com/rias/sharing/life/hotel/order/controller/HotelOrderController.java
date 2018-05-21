package com.rias.sharing.life.hotel.order.controller;

import com.rias.sharing.life.common.result.Result;
import com.rias.sharing.life.hotel.order.service.HotelOrderService;
import com.rias.sharing.life.hotel.order.vo.HotelOrderDisplayVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

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
    private HotelOrderService hotelOrderService;

    /**
     * @Description: 根据订单ID查询订单详情
     * @author:张磊
     * @date:2018/4/13
     */
    @ApiOperation(value="根据订单ID查询订单详情", notes="根据订单ID查询订单详情")
    @GetMapping("/order/{id}")
    public Result<HotelOrderDisplayVo> getHotelOrderById(
            @ApiParam(name = "id", value = "订单模型")
            @NotNull @PathVariable("id") Long id) {

        HotelOrderDisplayVo vo = hotelOrderService.getHotelOrderById(id);

        return Result.success(vo);
    }

    /**
     * @Description: 根据用户ID查询订单
     * @author:张磊
     * @date:2018/4/13
     */
    @ApiOperation(value="根据用户ID查询订单", notes="根据用户ID查询订单")
    @GetMapping("/user/{id}")
    public Result<HotelOrderDisplayVo> getHotelOrdersByUserId(
            @ApiParam(name = "id", value = "订单模型")
            @NotNull @PathVariable("id") Long id) {

        HotelOrderDisplayVo vo = hotelOrderService.getHotelOrderById(id);

        return Result.success(vo);
    }
}
