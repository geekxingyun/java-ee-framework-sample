package com.xingyun.factory;

import com.xingyun.interfaces.IUser;
import com.xingyun.interfaces.impl.IUserMySQLImpl;
import com.xingyun.interfaces.impl.IUserOracleImpl;

public class MyIUserFactory {

	/***通过XML 构造方法注入 ******/
	private static IUser getIUserImpl(String dbType) {
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
