package com.xingyun.springbootwithdatajpasample.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class SpringBootURLController {

    @RequestMapping(value = "/url/a/{id}",method = RequestMethod.GET)
    public String urlWithParams(@PathVariable("id") Integer uid){
        return "Hello URL -----url/a/***------id="+uid;
    }


    @RequestMapping(value = "/url/b",method = RequestMethod.GET)
    public String urlWithQuestion(@RequestParam(value = "id",required = false,defaultValue = "0") Integer uid){
        return "Hello URL -----/url/b?id=***------id="+uid;
    }

    @GetMapping(value = "/url/c")
    public String urlWithQuestion2(@RequestParam(value = "id",required = false,defaultValue = "0") Integer uid){
        return "Hello URL -----/url/c?id=***------id="+uid;
    }
}
