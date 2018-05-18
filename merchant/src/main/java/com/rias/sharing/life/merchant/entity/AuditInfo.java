package com.rias.sharing.life.merchant.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @name: AuditInfo
 * @author: lucifinier
 * @date: 2018/5/11 10:51
 * @description: TODO
 */
@Data
public class AuditInfo {
    /**
     * id
     */
    private Long id;
    /**
     * 商户id
     */
    private Long merchantId;
    /**
     * 审核人id
     */
    private Long auditorId;
    /**
     * 审核不通过类型
     */
    private Integer failType;
    /**
     * 审核意见
     */
    private String failInfo;
    /**
     * 审核时间
     */
    private LocalDateTime auditTime;
}
