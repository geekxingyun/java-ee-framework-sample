package com.xingyun.springamqp.business;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Tut3Sender {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private FanoutExchange fanout;

	int dots = 0;

	int count = 0;

	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void send() {
		StringBuilder builder = new StringBuilder("Hello");
		if (dots++ == 3) {
			dots = 1;
		}
		for (int i = 0; i < dots; i++) {
			builder.append('.');
		}
		builder.append(Integer.toString(++count));
		String message = builder.toString();
		template.convertAndSend(fanout.getName(), "", message);
		System.out.println(" [x] Sent '" + message + "'");
	}
}
