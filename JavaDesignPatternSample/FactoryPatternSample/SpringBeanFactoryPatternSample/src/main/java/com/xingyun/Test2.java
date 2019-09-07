package com.xingyun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xingyun.interfaces.IUser;
import com.xingyun.model.User;

public class Test2 {
	public static void main(String[] args) {
		
		ApplicationContext fa=new ClassPathXmlApplicationContext("beans.xml");
			
		IUser iUser=(IUser)fa.getBean("iUserOracleImpl");
			
		iUser.insert(new User());
	}
}
