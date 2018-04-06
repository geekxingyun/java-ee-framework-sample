package com.xingyun.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/hello")
public class SpringMVCHelloController {

	//Response URL  http://host:port/hello/mvc
	@RequestMapping(value="/mvc",method = RequestMethod.GET)
	public String helloMVC(){
		return "home";
	}
	
	@RequestMapping(value="/test",method = RequestMethod.GET)
	public String testMVC(){
		return "jump";
	}
}
