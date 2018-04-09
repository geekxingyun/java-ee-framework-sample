package com.xingyun.springbootwithfreemarkersample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index(){
        return "views/index";
    }

    @RequestMapping(value = "/welcome")

    public String home(){
        return "views/welcome";
    }
}
