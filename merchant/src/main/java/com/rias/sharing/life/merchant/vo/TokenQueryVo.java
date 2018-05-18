package com.rias.sharing.life.merchant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:手机验证模型
 * @author:yangyu
 * @date: 2018/4/27
 */
@ApiModel(value="手机验证模型",description="手机验证模型")
@Data
public class TokenQueryVo {
    @ApiModelProperty(value="登陆手机号",example = "15172298516")
    private String phone;

    @ApiModelProperty(value="手机验证码",example = "656235")
    private String messageCode;
}
