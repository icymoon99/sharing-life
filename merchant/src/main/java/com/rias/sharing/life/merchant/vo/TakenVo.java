package com.rias.sharing.life.merchant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:短信校验返回的值
 * @author:郑鹏宇
 * @date: 2018/4/11
 */
@ApiModel(value="获取id和taken模型",description="获取id和taken模型")
@Data
public class TakenVo {
    /**
     * 用户
     */
    @ApiModelProperty(value="属性ID",example="879cbd5001d9497fb7bfed660f98d7ce")
    private Long id;
    /**
     *密匙
     */
    @ApiModelProperty(value="密匙taken",example="879cbd5001d9497fb7bfed660f98d7ce")
    private String taken;

    @ApiModelProperty(value="用户信息",example="vo")
    private HrVo vo;
}
