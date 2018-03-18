package com.xingyun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class URLknowledgeController {

    // URL path  /url/admin/18
    @RequestMapping(value = "/url/{name}/{age}",method= RequestMethod.GET)
    public String getName(ModelMap modelMap, @PathVariable("name") String name, @PathVariable("age") String age){
        modelMap.addAttribute("name",name);
        modelMap.addAttribute("age",age);
        return "result";
    }

    //URL path: url?name=admin&age=18
    @RequestMapping(value = "/url",method = RequestMethod.GET)
    public String  result(ModelMap modelMap, @RequestParam String name, @RequestParam int age){
            modelMap.addAttribute("name",name);
            modelMap.addAttribute("age",age);
        return "result";
    }
}
