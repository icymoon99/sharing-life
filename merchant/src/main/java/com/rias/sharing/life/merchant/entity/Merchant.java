package com.rias.sharing.life.merchant.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description:
 *
 *  商户模型
 * @author:yangyu
 * @date:2018/4/16
 */
@Data
public class Merchant {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 商户名称
     */
    private String companyName;
    /**
     * 产权人id
     */
    private Long ownerId;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 审核人
     */
    private Long auditorId;
    /**
     * 审核时间
     */
    private LocalDateTime auditTime;
    /**
     * 审核状态
     */
    private Integer auditStatus;
    /**
     * 证件照片地址
     */
    private String idPhotoUrl;
    /**
     * 手持证件图片地址
     */
    private String idPhotoPersonUrl;
}
