package com.rias.sharing.life.merchant.constants;

/**
 * @name: HrStatusEnum
 * @author: lucifinier
 * @date: 2018/5/11 16:31
 * @description: TODO
 */
public enum HrStatusEnum {
    MERCHANT_NO("没有关联的商户", 0),
    MERCHANT_WAITING_AUDIT("关联的商户待审核", 1),
    MERCHANT_AUDIT_FAIL("关联的商户审核失败", 2),
    MERCHANT_AUDIT_SUCCESS("关联的商户审核成功", 3);

    // 成员变量
    private String desc;
    private int index;

    // 构造方法
    private HrStatusEnum(String desc, int index) {
        this.desc = desc;
        this.index = index;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
