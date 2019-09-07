package com.xingyun.factory;

import com.xingyun.interfaces.IUser;
import com.xingyun.interfaces.impl.IUserMySQLImpl;
import com.xingyun.interfaces.impl.IUserOracleImpl;

public class MyIUserFactory {

	private IUser getIUserImpl(String dbType) {
		switch (dbType) {
		case "userMySQLImpl":
			return new IUserMySQLImpl();
		case "userOracleImpl":
			return new IUserOracleImpl();
		default:
			return new IUserMySQLImpl();
		}
	}
}
