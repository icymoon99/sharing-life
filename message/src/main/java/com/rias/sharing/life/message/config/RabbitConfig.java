package com.rias.sharing.life.message.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @name: RabbitConfig
 * @author: lucifinier
 * @date: 2018/5/2 17:34
 * @description: Rabbit配置
 */
@Configuration
public class RabbitConfig {
    final static String QUEUE_PAY_ACCOUNT = "topic.pay.account";
    final static String EXCHANGE_PAY_ACCOUNT = "9";
    final static String ROUTING_PAY_ACCOUNT = "routing.pay.account.#";

    @Bean
    public Queue queuePayAccount() {
        return new Queue(RabbitConfig.QUEUE_PAY_ACCOUNT);
    }

    @Bean
    TopicExchange exchangePayAccount() {
        return new TopicExchange(RabbitConfig.EXCHANGE_PAY_ACCOUNT);
    }

    @Bean
    Binding bindingExchangeMessage(Queue queuePayAccount, TopicExchange exchangePayAccount) {
        return BindingBuilder.bind(queuePayAccount).to(exchangePayAccount).with(RabbitConfig.ROUTING_PAY_ACCOUNT);
    }
}
