package com.xingyun.springamqp.business;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Tut1Sender {
	
	/**
	 * RabbitMQ 模板
	 */
	@Autowired
    private RabbitTemplate template;

	/**
	 * 注入队列
	 * */
    @Autowired
    private Queue queue;

    /**
     * 定时发送消息
     */
    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello World!";
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
