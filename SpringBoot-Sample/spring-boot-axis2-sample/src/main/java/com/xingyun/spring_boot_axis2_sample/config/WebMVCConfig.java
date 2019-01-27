package com.xingyun.spring_boot_axis2_sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@ImportResource(locations = { "classpath:spring-config/application-context.xml",
		"classpath:spring-config/application-db-context.xml" })
@Configuration
public class WebMVCConfig extends WebMvcConfigurationSupport {
	
	/**
	 * 静态资源处理
	 *****/
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) { // TODO Auto-generated method stub
		// Spring Boot 默认得静态资源处理配置
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/"); // 自定义的静态资源处理
		registry.addResourceHandler("/axis2-web/**").addResourceLocations("/axis2-web/");
		super.addResourceHandlers(registry);
	}

	/**
	 * 设置默认欢迎页面
	 */
	@Override
	protected void addViewControllers(ViewControllerRegistry registry) { // TODO Auto-generated method stub
		registry.addRedirectViewController("/", "axis2-web/index.jsp");
		super.addViewControllers(registry);
	}
}
