package com.rias.sharing.life.user.vo;

import com.rias.sharing.life.user.validator.IsMobile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @name: PhoneCodeVo
 * @author: lucifinier
 * @date: 2018/4/24 17:08
 * @description: 手机登陆前端模型
 */
@ApiModel(value="手机校验模型",description="手机校验前端模型")
public class PhoneCodeVo {
    @IsMobile
    @ApiModelProperty(value="电话", required = true, example="13912345678")
    private String phone;

    @NotNull()
    @ApiModelProperty(value="验证码", required = true, example="666888")
    private String code;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
