package actions.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.ManagerBean;

public class ShowMangerListAction extends ActionSupport{

	private List<ManagerBean> managerBeanList;

	public List<ManagerBean> getManagerBeanList() {
		return managerBeanList;
	}

	public void setManagerBeanList(List<ManagerBean> managerBeanList) {
		this.managerBeanList = managerBeanList;
	}

	private static final long serialVersionUID = 5780746495245081404L;

	public String execute() throws IOException {
		managerBeanList = findALLManagerList();
			
		return SUCCESS;
	}

	/**
	 * 构造虚拟数据
	 **/
	private static List<ManagerBean> findALLManagerList() {
		List<ManagerBean> managedBeanList = new ArrayList<ManagerBean>();
		Integer mangerCount = 20;
		

		ManagerBean addManagerBean = new ManagerBean();
		for (int i = 0; i < mangerCount; i++) {
			addManagerBean = new ManagerBean();
			addManagerBean.setManagerId(Long.valueOf(i));
			addManagerBean.setManagerUserName("admin" + i);
			addManagerBean.setManagerPassword("123456");
			addManagerBean.setManagerToken("abcefghijklmn" + i);
			managedBeanList.add(addManagerBean);
		}
		return managedBeanList;
	}
}
