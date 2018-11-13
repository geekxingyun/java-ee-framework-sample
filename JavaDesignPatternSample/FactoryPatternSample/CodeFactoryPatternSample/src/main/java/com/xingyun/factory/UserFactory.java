package com.xingyun.factory;

import com.xingyun.interfaces.IUser;
import com.xingyun.interfaces.impl.IUserOracleImpl;

public class UserFactory {

	public static IUser getIUserImpl() {
		//return new IUserMySQLImpl();
		return new IUserOracleImpl();
	}
}
