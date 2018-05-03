package com.rias.sharing.life.message.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
    private String messageId;

    @ApiModelProperty(value="消息内容",example="json对象")
    private String messageBody;

    @ApiModelProperty(value="消费消息地址",example="http://consumer/service/xxx")
    private String consumerUrl;
}
