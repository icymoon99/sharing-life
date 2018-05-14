package com.rias.sharing.life.hotel.service.impl;


import com.rias.sharing.life.hotel.dao.HotelRegionDao;
import com.rias.sharing.life.hotel.entity.HotelRegion;
import com.rias.sharing.life.hotel.exception.GlobalException;
import com.rias.sharing.life.hotel.result.CodeMsg;
import com.rias.sharing.life.hotel.service.HotelRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @author:郑鹏宇
 * @date: 2018/3/26
 */
@Service
public class HotelRegionServiceImpl implements HotelRegionService {
    @Autowired
    HotelRegionDao hotelRegionDao;

    @Override
    public List<HotelRegion> getSubRegions(long pId, boolean isAll) {
        //根据父id查询地域
        List<HotelRegion> regions = hotelRegionDao.getRegionById(pId);

        if (!Optional.ofNullable(regions).isPresent()) {
            throw new GlobalException(CodeMsg.NO_REGION_BY_ID);
        }

        //只查询一级子地域
        if (false == isAll) {
            return regions;
        } else {
            return this.getAllSubRegions(regions, regions);
        }
    }

    /**
     * @Description:递归查询所有子节点地域
     * @author:张磊
     * @date:2018/5/6
     */
    private List<HotelRegion> getAllSubRegions(List<HotelRegion> allSubRegions, List<HotelRegion> pRegions) {
        List<HotelRegion> temp = new ArrayList<>();
        for (HotelRegion region : pRegions) {
            List<HotelRegion> subRegions = hotelRegionDao.getRegionById(region.getId());
            temp.addAll(subRegions);
        }

        if (temp.isEmpty()) {
            return allSubRegions;
        } else {
            allSubRegions.addAll(temp);
            return this.getAllSubRegions(allSubRegions, temp);
        }
    }
}
