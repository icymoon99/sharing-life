package com.rias.sharing.life.message.service.impl;

import com.rias.sharing.life.message.vo.TransactionMessageVo;
import com.rias.sharing.life.message.service.TransactionMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @name: TransactionMessageServiceImpl
 * @author: lucifinier
 * @date: 2018/4/28 16:24
 * @description: TODO
 */
@Service
@Slf4j
public class TransactionMessageServiceImpl implements TransactionMessageService {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    public boolean directSendMessage(TransactionMessageVo message) {
        rabbitTemplate.convertAndSend("exchange.pay.account", "routing.pay.account.put", message);
        return true;
    }
}
