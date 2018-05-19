package com.rias.sharing.life.merchant.vo;

import com.rias.sharing.life.common.validator.IsMobile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Description:手机验证模型
 * @author:yangyu
 * @date: 2018/4/27
 */
@ApiModel(value="手机验证模型",description="手机验证模型")
@Data
public class PhoneCodeVo {
    @ApiModelProperty(value="登陆手机号",example = "15172298516")
    @IsMobile
    private String phone;

    @ApiModelProperty(value="手机验证码",example = "656235")
    @NotNull
    private String messageCode;
}
