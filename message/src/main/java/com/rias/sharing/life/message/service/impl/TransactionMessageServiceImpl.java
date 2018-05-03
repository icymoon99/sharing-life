package com.rias.sharing.life.message.service.impl;

import com.rias.sharing.life.message.constant.MessageStatusEnum;
import com.rias.sharing.life.message.dao.TransactionMessageDao;
import com.rias.sharing.life.message.entity.TransactionMessage;
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
    @Autowired
    private TransactionMessageDao transactionMessageDao;

    @Override
    public void directSendMessage(TransactionMessageVo messageVo) {
        TransactionMessage message = this.makeEntityByVo(messageVo);

        rabbitTemplate.convertAndSend(message.getMessageExchange(), message.getMessageRouting(), message.getMessageBody());
    }

    @Override
    public void saveMessageWaitingConfirm(TransactionMessageVo messageVo) {
        TransactionMessage message = this.makeEntityByVo(messageVo);
        message.setStatus(MessageStatusEnum.WAITING_CONFIRM.getIndex());

        transactionMessageDao.saveTransactionMessage(message);
    }

    @Override
    public void confirmAndSendMessage(String id) {
        TransactionMessage message = transactionMessageDao.getMessageById(id);

        message.setStatus(MessageStatusEnum.SENDING.getIndex());
        transactionMessageDao.updateMessageStatus(message);

        rabbitTemplate.convertAndSend(message.getMessageExchange(), message.getMessageRouting(), message.getMessageBody());
    }

    @Override
    public void saveAndSendMessage(TransactionMessageVo messageVo) {
        TransactionMessage message = this.makeEntityByVo(messageVo);
        message.setStatus(MessageStatusEnum.SENDING.getIndex());

        transactionMessageDao.saveTransactionMessage(message);

        rabbitTemplate.convertAndSend(message.getMessageExchange(), message.getMessageRouting(), message.getMessageBody());
    }

    private TransactionMessage makeEntityByVo(TransactionMessageVo messageVo) {
        TransactionMessage message = new TransactionMessage();

        message.setId(messageVo.getMessageId());
        message.setMessageExchange(messageVo.getMessageExchange());
        message.setMessageRouting(messageVo.getMessageRouting());
        message.setMessageBody(messageVo.getMessageBody());
        message.setIsDead(false);
        message.setRetryTime(0);

        return message;
    }
}
