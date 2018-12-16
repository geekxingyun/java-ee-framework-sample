package com.xingyun;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/***
 * @author fairy
 * 通过code直接调用收发消息
 * *****/
public class Test1 {
	
	public static void main(String[] args) {
		
		//创建一个工厂
		ConnectionFactory connectionFactory = new CachingConnectionFactory();
		AmqpAdmin admin = new RabbitAdmin(connectionFactory);
		
		//声明创建一个队列
		admin.declareQueue(new Queue("myqueue"));
		
		//创建模板
		AmqpTemplate template = new RabbitTemplate(connectionFactory);
		
		//向队列发送消息
		template.convertAndSend("myqueue", "foo");
		
		//从某一个队列接受消息 
		String foo = (String) template.receiveAndConvert("myqueue");
	}

}
