package com.xingyun.controller;

import com.xingyun.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/form")
public class FormknowledgeController {

    // /form/loginWithHTML
    @RequestMapping(value = "/loginWithHTML",method = RequestMethod.GET)
    public String loginWithHTML(){
        return "login_html";
    }

    @RequestMapping(value = "/loginWithHTMLValidate",method = RequestMethod.POST)
    public String loginValidate(ModelMap modelMap, @RequestParam String username, @RequestParam String password){
        modelMap.addAttribute("username",username);
        modelMap.addAttribute("password",password);
        return "login_success";
    }

    @RequestMapping(value = "/loginWithSpring",method = RequestMethod.GET)
    public String loginWithSpring(ModelMap modelMap){
        User user=new User();
        user.setUsername("admin");
        user.setPassword("root");
        modelMap.addAttribute("user",user);
        return "login_spring";
    }

    @RequestMapping(value = "/loginWithSpringValidate",method = RequestMethod.POST)
    public String loginWithSpringValidate(ModelMap modelMap,@RequestParam String username, @RequestParam String password){

        modelMap.addAttribute("username",username);
        modelMap.addAttribute("password",password);

        return "login_success";
    }
}
