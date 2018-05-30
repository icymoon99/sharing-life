package com.rias.sharing.life.hotel.controller;

import com.google.common.base.Preconditions;
import com.rias.sharing.life.common.result.Result;
import com.rias.sharing.life.hotel.module.HotelSkuQueryVo;
import com.rias.sharing.life.hotel.service.HotelSkuService;
import com.rias.sharing.life.hotel.vo.HotelSkuDetailVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @name: HotelSkuController
 * @author: lucifinier
 * @date: 2018/5/26 14:08
 * @description: TODO
 */
@Api(tags="酒店房间的controller")
@Slf4j
@RestController
@RequestMapping("/hotel/room")
public class HotelSkuController {
    @Autowired
    private HotelSkuService skuService;

    @ApiOperation(value="生成订单ID", notes="生成订单ID")
    @GetMapping
    public Result<HotelSkuDetailVo> getHotelSkuDetail(
            @ApiParam(name="id",value="房间id",example="1") @RequestParam("id") Long id,
            @ApiParam(name="start",value="入住时间",example="2018-05-22")
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @ApiParam(name="end",value="离店时间",example="2018-05-30")
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        Preconditions.checkNotNull(startDate);
        HotelSkuQueryVo queryVo = new HotelSkuQueryVo(id, startDate, endDate);

        HotelSkuDetailVo vo = skuService.getHotelSkuDetail(queryVo);

        return Result.success(vo);
    }


}
