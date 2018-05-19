package com.rias.sharing.life.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @name: TokenVo
 * @author: lucifinier
 * @date: 2018/4/24 20:46
 * @description: Token前台模型
 */
@ApiModel(value="获取Token前台模型",description="获取Token前台模型")
@Data
@AllArgsConstructor
public class TokenVo {
    @ApiModelProperty(value="用户ID",example="420")
    private Long id;

    @ApiModelProperty(value="密匙taken",example="123456")
    private String taken;
}
