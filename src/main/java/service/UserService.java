package com.swust.service;

import com.swust.base.BaseService;
import com.swust.domain.User;

public interface UserService extends BaseService<User,Integer> {

	/**
	 * ��ѯ�û�
	 * @param user
	 * @return
	 */
	User findByUsernameAndPassword(User user);
	
	
	boolean dologin(String username, String password);


}
