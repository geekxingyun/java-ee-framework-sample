package com.xingyun;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.xingyun.interfaces.IUser;
import com.xingyun.model.User;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Resource resource=new FileSystemResource("src/main/resources/beans.xml");
		
		BeanFactory beanFactory=new XmlBeanFactory(resource);
		
		IUser iUser=(IUser)beanFactory.getBean("iUser");
		
		iUser.insert(new User());
		
	}
}
