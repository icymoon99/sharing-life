package com.rias.sharing.life.hotel.gateway.constant;

public enum HotelRoomStatusEnum {
    ON_SALE("可预定房", 1),
    SALED("已预定房", 2),
    DIRTY("脏房", 3),
    REPAIR("维修房", 4);

    // 成员变量
    private String desc;
    private int index;

    // 构造方法
    private HotelRoomStatusEnum(String desc, int index) {
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
