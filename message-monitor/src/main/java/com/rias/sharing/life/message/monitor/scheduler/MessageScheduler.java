package com.rias.sharing.life.message.monitor.scheduler;

import com.github.pagehelper.PageHelper;
import com.rias.sharing.life.message.monitor.constant.MessageStatusEnum;
import com.rias.sharing.life.message.monitor.dao.TransactionMessageDao;
import com.rias.sharing.life.message.monitor.entity.TransactionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @name: MessageScheduler
 * @author: lucifinier
 * @date: 2018/5/3 16:12
 * @description: TODO
 */
@Component
public class MessageScheduler {
    @Autowired
    TransactionMessageDao transactionMessageDao;

    @Value("${message.scheduler.max-handle-num-per-page}")
    private int maxHandleNumPerPage;

    /**
     * @Description:处理状态为“待确认”但已超时的消息.
     * @author:张磊
     * @date:2018/5/3
     */
    @Scheduled(initialDelay=10000, fixedDelay = 1000)
    public void handleWaitingConfirmTimeOutMessages() {
        PageHelper.startPage(1, maxHandleNumPerPage);
        List<TransactionMessage> messages =
                transactionMessageDao.getAllMessageByStatus(MessageStatusEnum.WAITING_CONFIRM.getIndex());
    }

    @Scheduled(fixedDelay = 1500)
    public void handleSendingTimeOutMessage() {

    }
}
