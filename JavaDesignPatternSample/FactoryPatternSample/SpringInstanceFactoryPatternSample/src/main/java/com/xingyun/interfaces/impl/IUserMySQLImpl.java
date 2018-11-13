package com.xingyun.interfaces.impl;

import com.xingyun.interfaces.IUser;
import com.xingyun.model.User;

public class IUserMySQLImpl implements IUser{

	public void insert(User user) {
		// TODO Auto-generated method stub
		System.out.println("insert to MySQL success");
	}
}
