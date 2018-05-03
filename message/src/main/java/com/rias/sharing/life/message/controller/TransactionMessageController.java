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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @name: TransactionMessageController
 * @author: lucifinier
 * @date: 2018/4/28 16:22
 * @description: 事务消息队列
 */
@Api(tags="事务消息队列的controller")
@RestController
@RequestMapping("/transaction/messages")
@Slf4j
public class TransactionMessageController {
    @Autowired
    TransactionMessageService transactionMessageService;

    @ApiOperation(value = "直接发送事务消息", notes = "直接发送事务消息")
    @PostMapping("/direct/message")
    public Result<String> directSendMessage(
            @ApiParam(name = "TransactionMessageVo", value = "事务消息模型")
            @Valid @RequestBody TransactionMessageVo transactionMessageVo
    ) {
        transactionMessageService.directSendMessage(transactionMessageVo);
        return Result.success();
    }

    @ApiOperation(value = "保存待发送待消息", notes = "保存待发送待消息")
    @PostMapping("/waiting/confirm/message")
    public Result<String> saveMessageWaitingConfirm(
            @ApiParam(name = "TransactionMessageVo", value = "事务消息模型")
            @Valid @RequestBody TransactionMessageVo transactionMessageVo
    ) {
        transactionMessageService.saveMessageWaitingConfirm(transactionMessageVo);
        return Result.success();
    }

    @ApiOperation(value = "确定并发送待消息", notes = "确定并发送待消息")
    @PostMapping("/confirm/sending/message/{id}")
    public Result<String> confirmAndSendMessage(
            @ApiParam(name = "id", value = "消息ID")
            @PathVariable("id") String id
    ) {
        transactionMessageService.confirmAndSendMessage(id);
        return Result.success();
    }

    @ApiOperation(value = "确定并发送待消息", notes = "确定并发送待消息")
    @PostMapping("/saving/sending/message/{id}")
    public Result<String> saveAndSendMessage(
            @ApiParam(name = "TransactionMessageVo", value = "事务消息模型")
            @Valid @RequestBody TransactionMessageVo transactionMessageVo
    ) {
        transactionMessageService.saveAndSendMessage(transactionMessageVo);
        return Result.success();
    }
}
