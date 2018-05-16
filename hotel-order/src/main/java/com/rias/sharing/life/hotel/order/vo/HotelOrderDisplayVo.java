package com.rias.sharing.life.hotel.order.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value="订单模型",description="订单模型Vo")
@Data
public class HotelOrderDisplayVo implements Serializable {
    private static final long serialVersionUID = -6294998792341256146L;

    @ApiModelProperty(value="订单id",example="1")
    private Long id;

    @ApiModelProperty(value="用户id",example="2")
    private Long userId;

    @ApiModelProperty(value="房间id",example="3")
    private Long skuId;

    @ApiModelProperty(value="房间总价",example="5096")
    private Integer skuPrice;

    @ApiModelProperty(value="押金",example="200")
    private Integer skuBond;

    @ApiModelProperty(value="开始日期",example="2018-05-01")
    private String startDate;

    @ApiModelProperty(value="结束日期",example="2018-05-03")
    private String endDate;

    @ApiModelProperty(value="入住人姓名",example="张三")
    private String occupantName;

    @ApiModelProperty(value="入住人身份证",example="420111111111111111")
    private String occupantCard;

    @ApiModelProperty(value="入住人电话",example="13711111111")
    private String occupantPhone;

    @ApiModelProperty(value="房间状态",example="4")
    private Integer roomStatus;

    @ApiModelProperty(value="房间名称",example="*****")
    private String skuName;

    @ApiModelProperty(value="房间地址",example="湖北省***")
    private String address;

    @ApiModelProperty(value="商户id",example="12345")
    private String merchantId;
}
