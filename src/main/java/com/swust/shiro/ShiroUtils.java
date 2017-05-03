package com.swust.shiro;

import com.swust.domain.User;
import org.apache.shiro.SecurityUtils;

public class ShiroUtils {
	
	/**
	 * 得到  当前 登录 的 用户
	 * @return
	 */
	public static User getCurrentUser(){
		User currentUser = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		return currentUser;
	}
	
	/**
	 * 得到 当前登录用户 的id
	 * @return
	 */
	public static Integer getUserId(){
		User currentUser = getCurrentUser();
		if(currentUser==null){
			return null;
		}
		Integer id = currentUser.getId();
		return id;
	}
	
	
	
	

}
