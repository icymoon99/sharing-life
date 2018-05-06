package com.rias.sharing.life.hotel.core.vo;

import com.rias.sharing.life.hotel.core.entity.HotelRegion;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description:默认地址的实体类
 * @author:郑鹏宇
 * @date: 2018/3/26
 */
@ApiModel(value="位置属性",description="酒店位置模型DTO")
@Data
public class HotelRegionVo implements Serializable {
    private static final long serialVersionUID = 3618592273802961055L;

    @ApiModelProperty(value="属性ID",example="87d9fe4238f74d84be15d62984fdfe65")
    private long id;
    @ApiModelProperty(value="父项属性id",example="87d9fe4238f74d84be15d62984fdfe90")
    private long parentId;
    @ApiModelProperty(value="位置名称",example="武汉")
    private String name;
    @ApiModelProperty(value="经度",example="114309558")
    private Integer lng;
    @ApiModelProperty(value="维度",example="30589084")
    private Integer lat;
    @ApiModelProperty(value="权重",example="125")
    private Integer weight;

    public static HotelRegionVo make(HotelRegion region) {
        HotelRegionVo vo = new HotelRegionVo();

        vo.setId(region.getId());
        vo.setName(region.getName());
        vo.setLat(region.getLat());
        vo.setLng(region.getLng());
        vo.setParentId(region.getParentId());
        vo.setWeight(region.getWeight());

        return vo;
    }
}
