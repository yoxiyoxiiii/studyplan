package com.swust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台 权限 管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/system")
public class SystemPowerController {
	
	/**
	 * 登录界面
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("forward:/login.jsp");
		return modelAndView;
		
	}
	
	/**
	 * 登录 成功 到后台首页
	 * @return
	 */
	@RequestMapping("/homePage")
	public ModelAndView homePage(){
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("admin/admin");
		return modelAndView;
		
	}

}
