package com.rias.sharing.life.hotel.gateway.constant;

public enum HotelOrderStatusEnum {
    UNPAID("订单未付款", 1),
    PAYING("订单付款中", 2),
    PAID("订单已付款", 3),
    CHECK_IN("入住",4),
    CHECK_OUT("退房", 5),
    FINISH("订单完成",6),
    EXPRIED("订单未付款, 已过期", 7),
    CANCEL("取消订单", 8);

    // 成员变量
    private String desc;
    private int index;

    // 构造方法
    private HotelOrderStatusEnum(String desc, int index) {
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

    public static HotelOrderStatusEnum getByIndex(int index) {
        switch (index) {
            case 1: return HotelOrderStatusEnum.UNPAID;
            case 2: return HotelOrderStatusEnum.PAYING;
            case 3: return HotelOrderStatusEnum.PAID;
            case 4: return HotelOrderStatusEnum.CHECK_IN;
            case 5: return HotelOrderStatusEnum.CHECK_OUT;
            case 6: return HotelOrderStatusEnum.FINISH;
            case 7: return HotelOrderStatusEnum.EXPRIED;
            case 8: return HotelOrderStatusEnum.CANCEL;
            default: throw new IllegalArgumentException("index is out of range!");
        }
    }
}
