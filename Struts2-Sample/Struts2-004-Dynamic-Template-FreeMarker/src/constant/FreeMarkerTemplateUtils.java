package constant;

import java.io.File;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

/**
 * @description FreeMarker 模板初始化工具类 [FreeMarker Initialization Configure Tools]
 */
public class FreeMarkerTemplateUtils {

	/**
	 * @description 获取TOMCAT部署项目根路径 ../webApps/YourApp
	 */
	private final static String TOMCAT_APP_ROOT_PATH = ServletActionContext.getServletContext()
			.getRealPath(File.separator);

	/*
	 * 配置FreeMarker 实例
	 * -------------------------------------------------------------------------
	 * ------------------ /**
	 * 
	 * @description 配置FreeMarker版本
	 * 当前最新版本2.3.25,由于Struts2.5.10.1使用版本是2.3.23,所以这里我们采用2.3.23版本配置
	 * 可选值:[VERSION_2_3_25||VERSION_2_3_24||VERSION_2_3_23||VERSION_2_3_22||
	 * VERSION_2_3_21||VERSION_2_3_20||VERSION_2_3_19||VERSION_2_3_0]
	 */
	private final static Version FREE_MARKER_VERSION = Configuration.VERSION_2_3_23;

	/*
	 * -------------------------------------------------------------------------
	 * -------------------
	 * 
	 * @description 配置FTL模板文件夹根路径 根路径../webApps/YourApp,请在后面追加自己模板所在的路径即可
	 */
	private final static String FREE_MARKER_TEMPLATE_FOLDER_PATH = TOMCAT_APP_ROOT_PATH + "WEB-INF/ftl";
	/*
	 * -------------------------------------------------------------------------
	 * -------------------- 配置FTL模板默认字符集
	 */
	private final static String DEFAULT_FTL_ENCODING = "UTF-8";

	/*
	 * @description 获取FreeMarker FTL模板文件夹方法
	 **/
	public final static Configuration getTemplateFolder() throws IOException {

		/*
		 * ---------------------------------------------------------------------
		 */
		/*
		 * You should do this ONLY ONCE in the whole application life-cycle:
		 * 
		 */
		/* Create and adjust the configuration singleton */
		Configuration cfg = new Configuration(FREE_MARKER_VERSION);// 设置使用的
																	// FreeMarker
																	// 版本
		cfg.setDirectoryForTemplateLoading(new File(FREE_MARKER_TEMPLATE_FOLDER_PATH));// 设置模板所在文件夹
		cfg.setDefaultEncoding(DEFAULT_FTL_ENCODING);// 设置FTL文件默认字符编码
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);// 使用默认的异常处理
		cfg.setLogTemplateExceptions(false);
		/*
		 * ---------------------------------------------------------------------
		 */
		return cfg;
	}

}
