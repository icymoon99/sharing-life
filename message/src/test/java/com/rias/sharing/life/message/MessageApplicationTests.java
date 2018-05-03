package com.rias.sharing.life.message;

import com.rias.sharing.life.message.vo.TransactionMessageVo;
import com.rias.sharing.life.message.service.TransactionMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageApplicationTests {
	@Autowired
    TransactionMessageService transactionMessageService;

	@Test
	public void contextLoads() {
        TransactionMessageVo vo = new TransactionMessageVo();
        vo.setMessageBody("hello");
        vo.setMessageId("123456789");
        vo.setMessageExchange("exchange.pay.account");
        vo.setMessageRouting("routing.pay.account.put");
        transactionMessageService.directSendMessage(vo);
        System.out.println("OK");
	}

}
