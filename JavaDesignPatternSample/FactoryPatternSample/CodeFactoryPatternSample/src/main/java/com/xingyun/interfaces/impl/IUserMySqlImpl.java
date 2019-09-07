package com.xingyun.interfaces.impl;

import com.xingyun.interfaces.IUser;
import com.xingyun.model.User;

/**
 * @author 星云
 * @Description 用户服务接口MySql实现层
 * @Date 9/5/2019 8:09 AM
 */
public class IUserMySqlImpl implements IUser{
	@Override
	public void insertUser(User user) {
		System.out.println("insert to MySQL success");
	}
}
