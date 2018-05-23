package com.rias.sharing.life.hotel.vo;

import com.rias.sharing.life.common.validator.IsDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @name: HotelSkuQueryVo
 * @author: lucifinier
 * @date: 2018/5/23 15:28
 * @description: TODO
 */
@ApiModel(value="酒店查询",description="酒店查询模型")
@Data
public class HotelSkuQueryVo {
    @ApiModelProperty(value="ID",example="1")
    @NotNull
    private Long id;

    @ApiModelProperty(value="入住日期",example="2017-08-08")
    @IsDate
    private String startDate;

    @ApiModelProperty(value="离店日期",example="2017-08-10")
    @IsDate
    private String endDate;
}
