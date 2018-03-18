package com.xingyun.controller;

import com.xingyun.db.DatabaseConnectionTools;
import com.xingyun.model.TUserEntity;
import com.xingyun.model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/showUserList",method = RequestMethod.GET)
    public String userList(ModelMap modelMap){

        Session session= DatabaseConnectionTools.getSession();
        
        List<TUserEntity> userList=session.createCriteria(TUserEntity.class).list();

        modelMap.addAttribute("userList",userList);

        session.close();

        return "user_list";
    }
}
