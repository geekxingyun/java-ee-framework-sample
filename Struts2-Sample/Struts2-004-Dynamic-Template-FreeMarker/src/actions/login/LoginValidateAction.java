package actions.login;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginValidateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1797470979300867219L;

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() {

		if (this.getUsername().equals("admin") && this.password.equals("root")) {
			ActionContext.getContext().put("username",this.getUsername());
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

}
