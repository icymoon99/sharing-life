package com.rias.sharing.life.message.entity;

import lombok.Data;

/**
 * @name: TransactionMessage
 * @author: lucifinier
 * @date: 2018/5/2 17:06
 * @description: TODO
 */
@Data
public class TransactionMessage {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 消息id
     */
    private String messageId;
    /**
     * 消息内容
     */
    private String messageBody;
    /**
     * 消息消费地址
     */
    private String consumerUrl;
    /**
     * 消息状态
     */
}
