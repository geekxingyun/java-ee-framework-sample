package com.xingyun.springamqp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.xingyun.springamqp.business.Tut1Receiver;
import com.xingyun.springamqp.business.Tut1Sender;

/**
 * 配置文件前缀
 * ******/
@Profile({"tut1","hello-world"})
/**
 * 注解标识这是一个Java 配置类*****/
@Configuration
public class Tut1Config {

	/**
	 * 实例化一个名字叫做hello的队列
	 * */
	@Bean
	public Queue hello() {
		return new Queue("hello");
	}

	/**
	 * 定义一个配置文件
	 * 实例化消费者
	 * */
	@Profile("receiver")
	@Bean
	public Tut1Receiver receiver() {
		return new Tut1Receiver();
	}

	/**
	 * 定义一个配置文件
	 * 实例化生产者
	 * */
	@Profile("sender")
	@Bean
	public Tut1Sender sender() {
		return new Tut1Sender();
	}
}
