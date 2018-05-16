package com.rias.sharing.life.hotel.gateway.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @name: HotelOrderStatusVo
 * @author: lucifinier
 * @date: 2018/5/15 10:28
 * @description: TODO
 */
@ApiModel(value="订单状态模型",description="订单状态模型Vo")
@Data
public class HotelOrderStatusVo implements Serializable {
    private static final long serialVersionUID = 2726045845533799867L;

    @ApiModelProperty(value="订单id",example="1")
    @NotNull
    private Long id;

    @ApiModelProperty(value="订单状态",example="4")
    @NotNull
    private Integer status;
}
