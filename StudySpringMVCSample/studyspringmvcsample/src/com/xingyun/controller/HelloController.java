package com.xingyun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class HelloController {

    @RequestMapping(value = "/hello",method= RequestMethod.GET)
    public String pringWelcome(ModelMap modelMap) {
         modelMap.addAttribute("message", "Welcome Xing Yun");
         modelMap.put("content","This is my content");
        return "hello";
    }
}
