package com.rias.sharing.life.merchant.entity;

import lombok.Data;

/**
 * @Description:人力资源模型
 * @author:yangyu
 * @date:2018/4/16
 */
@Data
public class Hr {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 真是姓名
     */
    private String realName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 所属商户
     */
    private Long merchantId;
    /**
     * 省份证号
     */
    private String idCard;
    /**
     * 是否登陆
     */
    private Integer status;
}
