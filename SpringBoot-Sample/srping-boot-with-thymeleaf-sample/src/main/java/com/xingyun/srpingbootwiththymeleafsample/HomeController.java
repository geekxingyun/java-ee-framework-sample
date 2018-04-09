package com.xingyun.srpingbootwiththymeleafsample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String index(){
        return "/views/index";
    }

    @GetMapping(value = "/welcome")
    public String welcome(){
        return "/views/welcome";
    }
}
