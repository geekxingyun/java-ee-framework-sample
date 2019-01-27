package com.xingyun.spring_boot_axis2_sample.sample.service;

public class TestService {

	/**
	 * 输出 out
	 * 访问请求:
	 * http://localhost:8080/spring-boot-axis2-sample/services/TestService/readMessage
	 * @Return XML File
	 * */
	public String readMessage() {
		return "hello world,I am Xingyun.";
	}
	
	/**
	 * 输入 in
	 * 访问请求:
	 * http://localhost:8080/spring-boot-axis2-sample/services/TestService/sayMessage?message=xingyun
	 * @Return XML File
	 * **/
	public String sayMessage(String message) {
		if(message==null) {
			message="I love you!";
		}
		return "I want to say you:"+message;
	}
}
