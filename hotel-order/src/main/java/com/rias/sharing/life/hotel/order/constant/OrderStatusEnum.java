package com.rias.sharing.life.hotel.order.constant;

public enum OrderStatusEnum {
    UNPAID("未付款", 1),
    PAID("已付款", 2),
    CHECK_OUT("退房", 3),
    EXPRIED("过期", 4),
    CANCEL("取消订单", 5),
    PAIDING("付款中", 6),
    END("订单完成",7);

    // 成员变量
    private String desc;
    private int index;

    // 构造方法
    private OrderStatusEnum(String desc, int index) {
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
