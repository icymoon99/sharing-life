package com.rias.sharing.life.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @name: TokenVo
 * @author: lucifinier
 * @date: 2018/4/24 20:46
 * @description: Token前台模型
 */
@ApiModel(value="获取Token前台模型",description="获取Token前台模型")
@Data
public class TokenVo {
    @ApiModelProperty(value="用户ID",example="420")
    private Integer id;

    @ApiModelProperty(value="密匙taken",example="879cbd5001d9497fb7bfed660f98d7ce")
    private String taken;

    public TokenVo(Integer id, String taken) {
        this.id = id;
        this.taken = taken;
    }
}
