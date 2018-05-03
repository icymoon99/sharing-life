package com.rias.sharing.life.message.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @name: TransactionMessageVo
 * @author: lucifinier
 * @date: 2018/4/28 16:47
 * @description: TODO
 */
@ApiModel(value="事务消息模型",description="获取事务消息模型")
@Data
public class TransactionMessageVo implements Serializable {
    private static final long serialVersionUID = 5931318751396397460L;

    @ApiModelProperty(value="消息ID",example="879cbd5001d9497fb7bfed660f98d7ce")
    @NotNull()
    private String messageId;

    @ApiModelProperty(value="消息发送到交换机",example="exchange.example")
    @NotNull()
    private String messageExchange;

    @ApiModelProperty(value="消费路由",example="routing.example")
    @NotNull()
    private String messageRouting;

    @ApiModelProperty(value="消息内容",example="json对象")
    @NotNull()
    private String messageBody;
}
