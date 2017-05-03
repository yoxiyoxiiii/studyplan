package com.swust.filter;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class InterDemo implements WebRequestInterceptor {

	/**
	 * 在 Controller 调用之前调用
	 */
	public void preHandle(WebRequest request) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("11111111");
	
	}

	/**
	 * 在Controller 执行后调用，在DispatcherServlet 完成相应前
	 */
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("222222");
	}

	/**
	 * 在 DispatcherServlet 完成视图渲染后调用，一般用来释放资源
	 */
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("33333333");
	}

}
