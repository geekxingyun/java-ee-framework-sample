package com.xingyun;

import com.xingyun.factory.UserFactory;
import com.xingyun.interfaces.IUser;
import com.xingyun.interfaces.impl.IUserMySQLImpl;
import com.xingyun.interfaces.impl.IUserOracleImpl;
import com.xingyun.model.User;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUser iUser = UserFactory.getIUserImpl();
		iUser.insert(new User());
	}
}
