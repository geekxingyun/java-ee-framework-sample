package com.xingyun;

import com.xingyun.factory.UserFactory;
import com.xingyun.interfaces.IUser;
import com.xingyun.interfaces.impl.IUserOracleImpl;
import com.xingyun.model.User;

public class Test2 {
	public static void main(String[] args) {
		IUser iUser = UserFactory.getIUserImpl();
		iUser.insert(new User());
	}
}
