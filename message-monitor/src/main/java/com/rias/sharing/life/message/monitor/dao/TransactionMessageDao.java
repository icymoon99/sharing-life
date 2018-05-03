package com.rias.sharing.life.message.monitor.dao;

import com.rias.sharing.life.message.monitor.dao.mapper.TransactionMessageMapper;
import com.rias.sharing.life.message.monitor.entity.TransactionMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<TransactionMessage> getAllMessageByStatus(Integer status) {
        return mapper.getAllMessageByStatus(status);
    }

}
