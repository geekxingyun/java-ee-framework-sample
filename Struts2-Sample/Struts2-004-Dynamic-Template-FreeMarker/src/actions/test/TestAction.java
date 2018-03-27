package actions.test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import constant.FreeMarkerTemplateUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.Product;

public class TestAction extends ActionSupport {

	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	private static final long serialVersionUID = 3307538602357066073L;

	public String execute() throws TemplateException, IOException {

		Writer out=null;
		try {
			/* Get the template (uses cache internally) */
			//获取FreeMarker配置对象
			Configuration cfg = FreeMarkerTemplateUtils.getTemplateFolder();

			//设置要使用的模板
			Template temp = cfg.getTemplate("test.ftl");

			/* Merge data-model with template */
			//给模板填充数据
			user = "JOB";
			Map<String, String> root = new HashMap<String, String>();
			root.put("user",user);
			
			// Note: Depending on what `out` is, you may need to call
			// `out.close()`.
			// This is usually the case for file output, but not for servlet
			// output.

			out = new OutputStreamWriter(System.out);
			temp.process(root, out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("-------Error-------------"+e.toString());
		}finally {
			out.close();
		}
		return SUCCESS;
	}

}
