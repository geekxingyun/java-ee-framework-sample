package com.xingyun.interfaces.impl;

import com.xingyun.interfaces.IUser;
import com.xingyun.model.User;

/**
 * @author 星云
 * @Description 用户服务接口Oracle实现层
 * @Date 9/5/2019 8:09 AM
 */
public class IUserOracleImpl implements IUser{
	@Override
	public void insertUser(User user) {
		System.out.println("insert to Oracle success");
	}
}
