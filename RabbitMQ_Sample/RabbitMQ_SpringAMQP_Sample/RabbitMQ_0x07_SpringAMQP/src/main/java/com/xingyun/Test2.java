package com.xingyun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author fairy
 * 通过读XML文件配置的方式收发消息
 * ********/
public class Test2 {

	private final static Logger logger=LoggerFactory.getLogger(Test2.class);
	
	public static void main(String[] args) {
		
		//Spring 读取XMl配置
		ApplicationContext context = new GenericXmlApplicationContext("classpath:/rabbit-context.xml");
		
		//床架你模板
		AmqpTemplate template = context.getBean(AmqpTemplate.class);
		
		//通过模板发送消息
		template.convertAndSend("myqueue", "foo");
		
		//通过模板接受消息
		String foo = (String) template.receiveAndConvert("myqueue");
		
		//打印消息
		logger.debug(foo);
	}

}
