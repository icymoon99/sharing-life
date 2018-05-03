package com.rias.sharing.life.message.monitor.constant;

/**
 * @name: MessageStatusEnum
 * @author: lucifinier
 * @date: 2018/5/3 10:27
 * @description: TODO
 */
public enum  MessageStatusEnum {
    WAITING_CONFIRM("待确认", 0),
    SENDING("发送中", 1),
    CONSUMED("已消费", 2);

    private String desc;
    private int index;

    private MessageStatusEnum(String desc, int index) {
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
