package com.xingyun.spring_boot_axis2_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 是一个组合注解
 * @Configuration+@EnableAutoConfiguration+@EnableWebMvc+@ComponentScan
 * ****/
@SpringBootApplication
public class SpringBootAxis2SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAxis2SampleApplication.class, args);
	}
	
}

