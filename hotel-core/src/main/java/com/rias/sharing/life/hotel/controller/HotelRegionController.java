package com.rias.sharing.life.hotel.controller;


import com.rias.sharing.life.hotel.entity.HotelRegion;
import com.rias.sharing.life.hotel.result.Result;
import com.rias.sharing.life.hotel.service.HotelRegionService;
import com.rias.sharing.life.hotel.vo.HotelRegionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:地理位置坐标region
 * @author:郑鹏宇
 * @date: 2018/3/26
 */
@Api(tags="地理位置坐标region的controller")
@Slf4j
@RestController
@RequestMapping("/hotel/regions")
public class HotelRegionController {
    @Autowired
    HotelRegionService hotelRegionService;

    /**
     * @Description:根据id获取子地域信息
     * @author:张磊
     * @date:2018/4/2
     */
    @ApiOperation(value="根据id获取子位置，坐标", notes="查询所有城市时, id为0")
//    @Cacheable(value="hotel:region", key="#root.targetClass+':sub-region.id:'+#isAll+':'+#id", unless="#result.status!=0")
    @GetMapping("/subregion")
    public Result<List<HotelRegionVo>> getSubRegions(
            @ApiParam(name="id",value="父位置id") @RequestParam(value = "id") Long id,
            @ApiParam(name="isall",value="是否递归所有子位置") @RequestParam(value = "isall") Boolean isAll
    ) {
        List<HotelRegion> regions = hotelRegionService.getSubRegions(id, isAll);

        List<HotelRegionVo> vos = regions.stream()
                .map(region -> HotelRegionVo.make(region))
                .collect(Collectors.toList());

        return Result.success(vos);
    }
}
