package com.rias.sharing.life.message.entity;

import lombok.Data;

/**
 * @name: TransactionMessageMapper
 * @author: lucifinier
 * @date: 2018/5/2 17:06
 * @description: TODO
 */
@Data
public class TransactionMessage {
    /**
     * 消息id
     */
    private String id;
    /**
     * 交换机
     */
    private String messageExchange;
    /**
     * 路由
     */
    private String messageRouting;
    /**
     * 消息内容
     */
    private String messageBody;
    /**
     * 消息状态
     */
    private Integer status;
    /**
     * 重发次数
     */
    private Integer retryTime;
    /**
     * 是否死亡
     */
    private Boolean isDead;
}
