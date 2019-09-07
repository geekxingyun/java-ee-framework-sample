package com.xingyun;

import com.xingyun.interfaces.IUser;
import com.xingyun.interfaces.impl.IUserMySQLImpl;
import com.xingyun.interfaces.impl.IUserOracleImpl;
import com.xingyun.model.User;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUser iUser = new IUserMySQLImpl();
		//IUser iUser = new IUserOracleImpl();
		iUser.insert(new User());
	}
}
