package com.swust.service.impl;

import com.swust.base.PageInfo;
import com.swust.domain.User;
import com.swust.mapper.UserMapper;
import com.swust.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
@Transactional//事物管理
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper mapper;
	
	public User findByUsernameAndPassword(User user) {
		Map<String,Object> map= new HashMap<String,Object>();
		String username = user.getUsername();
		String password = user.getPassword();
		map.put("username",username);
		map.put("password", password);
		User u = mapper.findByUsernameAndPassword(map);
		return u;
	}

	public boolean save(User user) {
		mapper.save(user);
		return true;
	}

	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<PageInfo<User>> findByPage(PageInfo<User> pageInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * 用户 登录
	 */
	public boolean dologin(String username, String password) {
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated()){
			UsernamePasswordToken token = new UsernamePasswordToken(username,password);
			// 提交登录 凭证
			currentUser.login(token);
		}
		return true;
	}

}
