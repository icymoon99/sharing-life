package com.rias.sharing.life.hotel.controller;

import com.rias.sharing.life.common.result.Result;
import com.rias.sharing.life.hotel.service.SnowFlakeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: SnowFlakeServiceController
 * @author: lucifinier
 * @date: 2018/5/26 09:30
 * @description: TODO
 */
@Api(tags="生成订单ID的controller")
@Slf4j
@RestController
@RequestMapping("/snowflake/id")
public class SnowFlakeServiceController {
    @Autowired
    private SnowFlakeService service;

    @ApiOperation(value="生成订单ID", notes="生成订单ID")
    @GetMapping
    public Result<Long> getSubRegions() {
        Long id = service.GetId();

        return Result.success(id);
    }
}
