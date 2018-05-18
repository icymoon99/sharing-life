package com.rias.sharing.life.merchant.vo;

import com.rias.sharing.life.merchant.entity.AuditInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @name: AuditInfoVo
 * @author: lucifinier
 * @date: 2018/5/11 10:54
 * @description: TODO
 */
@ApiModel(value="审核意见模型",description="核意见模型")
@Data
public class AuditInfoVo {
    /**
     * 商户id
     */
    @ApiModelProperty(value="商户id",example = "ee66b96d7c994351ba3880c4337bafcb")
    private Long merchantId;
    /**
     * 审核人id
     */
    @ApiModelProperty(value="审核人id",example = "ee66b96d7c994351ba3880c4337bafcb")
    private Long auditorId;
    /**
     * 审核不通过类型
     */
    @ApiModelProperty(value="审核不通过类型",example = "1")
    private Integer failType;
    /**
     * 审核意见
     */
    @ApiModelProperty(value="审核意见",example = "图片错误")
    private String failInfo;

    public static AuditInfoVo make(AuditInfo info) {
        AuditInfoVo vo = new AuditInfoVo();

        vo.setMerchantId(info.getMerchantId());
        vo.setAuditorId(info.getAuditorId());
        vo.setFailType(info.getFailType());
        vo.setFailInfo(info.getFailInfo());

        return vo;
    }
}
