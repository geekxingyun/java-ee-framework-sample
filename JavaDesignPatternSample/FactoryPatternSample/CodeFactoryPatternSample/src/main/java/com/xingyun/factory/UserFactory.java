package com.xingyun.factory;

import com.xingyun.interfaces.IUser;
import com.xingyun.interfaces.impl.IUserOracleImpl;

/**
 * @author 星云
 * @Description 用户工厂层
 * @Date 9/5/2019 8:09 AM
 */
public class UserFactory {

	public static IUser getIUserImpl() {
		//return new IUserMySQLImpl();
		return new IUserOracleImpl();
	}
}
