package com.rias.sharing.life.merchant.constants;

/**
 * @Description:审核状态
 * @author:郑鹏宇
 * @date: 2018/4/18
 */
public enum AuditEnum {
    PENDING("待审核", 1),
    UNPASS("审核不通过", 3),
    PASS("审核成功", 2);

    // 成员变量
    private String desc;
    private int index;

    // 构造方法
    private AuditEnum(String desc, int index) {
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
