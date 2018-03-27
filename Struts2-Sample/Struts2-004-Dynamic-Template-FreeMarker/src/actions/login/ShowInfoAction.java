package actions.login;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowInfoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 906842935141398575L;
	
	private String username;
	private String sex;
	private Integer age;
	
	
	public String getUsername() {
		return "fairy";
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getSex() {
		return "男";
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public Integer getAge() {
		return 26;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String execute(){
		
		String username=(String)ActionContext.getContext().getSession().get("username");
		
		if(username.equals("admin")&&username!=null)
		{
			
			return SUCCESS;
		}else{
			return LOGIN;
		}
	}

}
