package com.rias.sharing.life.merchant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @name: OssTokenVo
 * @author: lucifinier
 * @date: 2018/4/27 09:37
 * @description: OSS临时token
 */
@ApiModel(value="Oss Token",description="Oss Token模型DTO")
@Data
public class OssTokenVo implements Serializable {
    private static final long serialVersionUID = -5904071073338448854L;

    @ApiModelProperty(value="AccessKeyId",example="87d9fe4238f74d84be15d62984fdfe65")
    private String accessKeyId;

    @ApiModelProperty(value="AccessKeySecret",example="87d9fe4238f74d84be15d62984fdfe65")
    private String accessKeySecret;

    @ApiModelProperty(value="securityToken",example="87d9fe4238f74d84be15d62984fdfe65")
    private String securityToken;
}
