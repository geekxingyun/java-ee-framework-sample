package com.xingyun;

import com.xingyun.factory.UserFactory;
import com.xingyun.interfaces.IUser;
import com.xingyun.model.User;

/**
 * @author 星云
 * @Description
 * @Date 9/5/2019 8:09 AM
 */
public class Test2 {
	public static void main(String[] args) {
		IUser iUser = UserFactory.getIUserImpl();
		iUser.insertUser(new User());
	}
}
