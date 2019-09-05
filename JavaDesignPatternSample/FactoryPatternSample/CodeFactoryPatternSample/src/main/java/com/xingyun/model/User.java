package com.xingyun.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户实体类
 * @author 星云
 * @Description
 * @Date 9/5/2019 8:09 AM
 */
@Getter
@Setter
@ToString
public class User {
	/**
	 * 用户账号
	 */
	 private String username;
	/**
	 * 用户密码
	 */
	private String password;
}
