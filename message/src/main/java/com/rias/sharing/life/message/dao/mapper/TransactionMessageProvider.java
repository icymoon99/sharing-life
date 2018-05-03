package com.rias.sharing.life.message.dao.mapper;

import com.rias.sharing.life.message.entity.TransactionMessage;
import org.apache.ibatis.jdbc.SQL;

/**
 * @name: TransactionMessageProvider
 * @author: lucifinier
 * @date: 2018/5/3 09:41
 * @description: TODO
 */
public class TransactionMessageProvider {
    final static String TABLE_NAME = "transaction_message";

    final static String COL_ID = "id";
    final static String COL_MESSAGE_EXCHANGE = "message_exchange";
    final static String COL_MESSAGE_ROUTING = "message_routing";
    final static String COL_MESSAGE_BODY = "message_body";
    final static String COL_STATUS = "status";
    final static String COL_RETRY_TIME = "retry_time";
    final static String COL_IS_DEAD = "is_dead";

    final static String VAL_ID = "#{id}";
    final static String VAL_MESSAGE_EXCHANGE = "#{messageExchange}";
    final static String VAL_MESSAGE_ROUTING = "#{messageRouting}";
    final static String VAL_MESSAGE_BODY = "#{messageBody}";
    final static String VAL_STATUS = "#{status}";
    final static String VAL_RETRY_TIME = "#{retryTime}";
    final static String VAL_IS_DEAD = "#{isDead}";

    /**
     * @Description:插入消息数据
     * @author:张磊
     * @date:2018/5/3
     */
    public String saveTransactionMessage(TransactionMessage message) {
        return new SQL() {{
            INSERT_INTO(TABLE_NAME);
            if (message.getId() != null) {
                VALUES(COL_ID, VAL_ID);
            }
            if (message.getMessageExchange() != null) {
                VALUES(COL_MESSAGE_EXCHANGE, VAL_MESSAGE_EXCHANGE);
            }
            if (message.getMessageRouting() != null) {
                VALUES(COL_MESSAGE_ROUTING, VAL_MESSAGE_ROUTING);
            }
            if (message.getMessageBody() != null) {
                VALUES(COL_MESSAGE_BODY, VAL_MESSAGE_BODY);
            }
            if (message.getStatus() != null) {
                VALUES(COL_STATUS, VAL_STATUS);
            }
            if (message.getRetryTime() != null) {
                VALUES(COL_RETRY_TIME, VAL_RETRY_TIME);
            }
            if (message.getIsDead() != null) {
                VALUES(COL_IS_DEAD, VAL_IS_DEAD);
            }
        }}.toString();
    }
}
