package com.rias.sharing.life.message.dao;

import com.rias.sharing.life.message.dao.mapper.TransactionMessageMapper;
import com.rias.sharing.life.message.entity.TransactionMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @name: TransactionMessageDao
 * @author: lucifinier
 * @date: 2018/5/3 09:40
 * @description: TODO
 */
@Slf4j
@Repository
public class TransactionMessageDao {
    @Autowired
    private TransactionMessageMapper mapper;

    public TransactionMessage getMessageById(String id) {
        return mapper.getMessageById(id);
    }

    public void saveTransactionMessage(TransactionMessage message) {
        mapper.saveTransactionMessage(message);
    }

    public void updateMessageStatus(TransactionMessage message) {
        mapper.updateMessageStatus(message);
    }
}
