package actions;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{

	/**
	 * 跳转到首页控制器
	 */
	private static final long serialVersionUID = 8932845629379744781L;
	
	public String execute(){
		return SUCCESS;
	}

}
