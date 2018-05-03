package com.rias.sharing.life.message.monitor.dao.mapper;

import com.rias.sharing.life.message.monitor.entity.TransactionMessage;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @name: TransactionMessageMapper
 * @author: lucifinier
 * @date: 2018/5/3 09:39
 * @description: TODO
 */
public interface TransactionMessageMapper {
    @Select("SELECT * FROM transaction_message where status = #{status}")
    @Results({
            @Result(column = "message_exchange", property = "messageExchange"),
            @Result(column = "message_routing", property = "messageRouting"),
            @Result(column = "message_body", property = "messageBody"),
    })
    List<TransactionMessage> getAllMessageByStatus(Integer status);
}
