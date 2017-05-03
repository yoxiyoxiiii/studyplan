package com.swust.filter;

import com.swust.service.CourseKindsService;
import com.swust.service.MenuService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器 ：禁止浏览器 缓存静态资源
 * @author Administrator
 *
 */
public class NoCatchStaticSourcesIntercepter implements HandlerInterceptor {

	@Resource(name="menuService")
	private MenuService menuService; 
	
	@Resource(name="courseKindsService")
	private CourseKindsService courseKindsService;
	/**
	 * 在Controller 之前调用
	 * 返回 true 对用户请求放行
	 * 返回false 表示 请求不继续执行，即在 拦截器中就对 用户的请求进行了 处理。终止
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		       
		return true;
	}

	/**
	 * 在 Controller 执行后 调用方法，但在DispatchServlet 完成 用户响应前。可以对 ModelAndView 进行操作
	 * 前提：preHandle 返回 true，才会调用这个方法。
	 * 这里的 modelAndView 是 Controller 返回的,如果要在这里使用 modelAndView Controller 就必须返回ModelAndView
	 * 否则 会 报 空指针异常
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
		//禁止浏览器缓存静态资源
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("expires", -1);
		
		//页面公用数据
		request.setAttribute("allMenu", menuService.finAll());
		request.setAttribute("allKinds",courseKindsService.findAll());
		
	}

	/**
	 * DispatcherServlet 完成了 render 视图渲染后 调用
	 * 主要进行 资源的回收
	 * preHandle 返回true 才执行
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
