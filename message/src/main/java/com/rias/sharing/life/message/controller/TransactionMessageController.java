package com.rias.sharing.life.message.controller;

import com.rias.sharing.life.message.vo.TransactionMessageVo;
import com.rias.sharing.life.message.result.CodeMsg;
import com.rias.sharing.life.message.result.Result;
import com.rias.sharing.life.message.service.TransactionMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @name: TransactionMessageController
 * @author: lucifinier
 * @date: 2018/4/28 16:22
 * @description: 事务消息队列
 */
@Api(tags="事务消息队列的controller")
@RestController
@RequestMapping("/transaction/message")
@Slf4j
public class TransactionMessageController {
    @Autowired
    TransactionMessageService transactionMessageService;

    @ApiOperation(value = "直接发送事务消息", notes = "直接发送事务消息")
    @PostMapping("/stream")
    public Result<String> directSendMessage(
            @ApiParam(name = "TransactionMessageVo", value = "事务消息模型")
            @Valid @RequestBody TransactionMessageVo transactionMessageVo
    ) {
        boolean result = transactionMessageService.directSendMessage(transactionMessageVo);
        if (!result) {
            log.error("send message failed: " + transactionMessageVo);

            return Result.error(CodeMsg.SEND_TO_SERVICE_ERROR);
        }

        return Result.success();
    }
}
