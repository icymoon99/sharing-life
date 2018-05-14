package com.rias.sharing.life.hotel.core.dao.mapper;

import com.rias.sharing.life.hotel.core.entity.HotelRegion;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:地址坐标的获取
 * @author:郑鹏宇
 * @date:2018/3/19
 */
public interface HotelRegionMapper {
    @Select("SELECT id,name,lng,lat,parent_id,weight FROM hotel_region WHERE parent_id=#{id}")
    @Results(
            @Result(property = "parentId", column = "parent_id")
    )
    List<HotelRegion> getRegionsByParentId(long id);
}
