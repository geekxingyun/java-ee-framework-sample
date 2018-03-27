package model;

import java.io.Serializable;

/**
 * t_admin 管理员表
 */
public class ManagerBean implements Serializable{

	private static final long serialVersionUID = 1038485516820077050L;

	private Long managerId;// 管理员Id
	private String managerUserName;// 管理员用户名 mark:手机号作为账号 用于扩展密码找回
	private String managerPassword;// 管理员密码 mark:用户名和密码混合加盐方式加密MD5
	private String managerToken;// 管理员登录Token 当前登录时间和用户密码
	
	
	public ManagerBean() {
		super();
	}
	public ManagerBean(Long managerId, String managerUserName, String managerPassword, String managerToken) {
		super();
		this.managerId = managerId;
		this.managerUserName = managerUserName;
		this.managerPassword = managerPassword;
		this.managerToken = managerToken;
	}
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	public String getManagerUserName() {
		return managerUserName;
	}
	public void setManagerUserName(String managerUserName) {
		this.managerUserName = managerUserName;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	public String getManagerToken() {
		return managerToken;
	}
	public void setManagerToken(String managerToken) {
		this.managerToken = managerToken;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}	
}
