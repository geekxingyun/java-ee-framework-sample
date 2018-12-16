package com.xingyun.springamqp.business;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * 监听hello队列
 */
@RabbitListener(queues = "hello")
public class Tut1Receiver {
	
	/**
	 * 接受消息
	 */
	@RabbitHandler
	public void receive(String in) {
		System.out.println(" [x] Received '" + in + "'");
	}
}
