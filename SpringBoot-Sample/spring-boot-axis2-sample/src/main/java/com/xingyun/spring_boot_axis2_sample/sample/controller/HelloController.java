package com.xingyun.spring_boot_axis2_sample.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping(value="/hello.do")
	public String homePage() {
		return "hello Nice to meet you";
	}
	
	@GetMapping(value= {"/hi","hi.do"})
	public String hi() {
		return "hi,Nice to meet you";
	}

}
