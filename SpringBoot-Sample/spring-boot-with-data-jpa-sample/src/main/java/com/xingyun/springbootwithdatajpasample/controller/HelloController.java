package com.xingyun.springbootwithdatajpasample.controller;

import com.xingyun.springbootwithdatajpasample.model.BookProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return "Hello Home Page";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return "Hello Spring Boot";
    }

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @RequestMapping(value = "/girl",method = RequestMethod.GET)
    public String configurationString(){
        return cupSize+"-----------------"+age+"-------------"+content;
    }


    @Autowired
    private BookProperties bookProperties;

    @RequestMapping(value = "/book",method = RequestMethod.GET)
    public String bookMethod(){
        return "---------------------"+bookProperties.getName()+bookProperties.getPrice()+bookProperties.getType();
    }

    @RequestMapping(value = {"/api","/API"},method = RequestMethod.GET)
    public String api(){
        return "Hello API";
    }


    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public String PostMethod(){
        return "Hello Post Page";
    }

}
