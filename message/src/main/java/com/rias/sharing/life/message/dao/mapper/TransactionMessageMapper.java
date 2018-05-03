package com.rias.sharing.life.message.dao.mapper;

import com.rias.sharing.life.message.entity.TransactionMessage;
import org.apache.ibatis.annotations.*;

/**
 * @name: TransactionMessageMapper
 * @author: lucifinier
 * @date: 2018/5/3 09:39
 * @description: TODO
 */
public interface TransactionMessageMapper {
    @Select("SELECT * FROM transaction_message where id = #{id}")
    @Results({
            @Result(column = "message_exchange", property = "messageExchange"),
            @Result(column = "message_routing", property = "messageRouting"),
            @Result(column = "message_body", property = "messageBody"),
    })
    TransactionMessage getMessageById (String id);

    @InsertProvider(type = TransactionMessageProvider.class,method = "saveTransactionMessage")
    void saveTransactionMessage(TransactionMessage message);

    @Update("update transaction_message set status = #{status} where id =#{id}")
    void updateMessageStatus(TransactionMessage message);
}
