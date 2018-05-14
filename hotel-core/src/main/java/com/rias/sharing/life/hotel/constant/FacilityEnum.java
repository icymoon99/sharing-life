package com.rias.sharing.life.hotel.constant;

/**
 * @Description:
 * @author:郑鹏宇
 * @date: 2018/4/14
 */
public enum FacilityEnum {
    WIFI("wifi", 10001),
    DUBBO_BED("双人床", 10002),
    WINDOW("有窗", 10003),
    SHOWER("卫浴", 10004);

    // 成员变量
    private String desc;
    private int index;

    // 构造方法
    private FacilityEnum(String desc, int index) {
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
