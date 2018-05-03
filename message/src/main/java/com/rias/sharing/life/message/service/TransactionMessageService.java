package com.rias.sharing.life.message.service;

import com.rias.sharing.life.message.vo.TransactionMessageVo;
import org.springframework.stereotype.Service;

/**
 * @name: TransactionMessageService
 * @author: lucifinier
 * @date: 2018/4/28 16:24
 * @description: 事务消息队列
 */
@Service
public interface TransactionMessageService {
    void directSendMessage(final TransactionMessageVo messageVo);

    void saveMessageWaitingConfirm(final TransactionMessageVo messageVo);

    void confirmAndSendMessage(String id);

    void saveAndSendMessage(final TransactionMessageVo messageVo);
}
