package com.xingyun;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 通过注入配置类方式来收发消息
 *******/
public class Test3 {

	private final static Logger logger = LoggerFactory.getLogger(Test2.class);

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfiguration.class);
		AmqpTemplate template = context.getBean(AmqpTemplate.class);
		template.convertAndSend("myqueue", "foo");
		String foo = (String) template.receiveAndConvert("myqueue");

		// 打印消息
		try {
			logger.debug(foo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.debug(new Queue(UUID.randomUUID().toString())+"");
		
	}
}
