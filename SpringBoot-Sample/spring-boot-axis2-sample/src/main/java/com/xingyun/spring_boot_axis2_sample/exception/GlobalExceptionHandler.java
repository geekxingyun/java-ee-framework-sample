package com.xingyun.spring_boot_axis2_sample.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalExceptionHandler implements ErrorController {
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		// 获取statusCode:401,404,500
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		switch (statusCode) {
		case 403:
			return "Error/AuthError.html";//axis2-web/Error/AuthError.html
		case 404:
			return "Error/error404.jsp";//axis2-web/Error/error404.jsp
		case 500:
			return "Error/error500.jsp";//axis2-web/Error/error500.jsp
		default:
			return "Error/GenError.html";//axis2-web/Error/GenError.html
		}
	}
}
