package com.xingyun;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.xingyun.interfaces.IUser;
import com.xingyun.model.User;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Resource resource=new FileSystemResource("src/main/resources/beans.xml");
        BeanFactory fa=new DefaultListableBeanFactory();  
		BeanDefinitionReader bdr=new XmlBeanDefinitionReader((BeanDefinitionRegistry) fa);  
		bdr.loadBeanDefinitions(resource);
		
		IUser iUser=(IUser)fa.getBean("iUserMySQLImpl");
		
		iUser.insert(new User());
		
	}
}
