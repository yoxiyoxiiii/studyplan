package com.swust.shiro;

import com.swust.domain.User;
import com.swust.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * realm 琚玸hiro 妗嗘灦璋冪敤
 * @author Administrator
 *AnonymousFilter
 */
public class UserRealm extends AuthorizingRealm {

	@Resource(name="userService")
	private UserService userService;

	/**
	 * 授权
	 */
	@Override
	public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
		
		return simpleAuthorizationInfo;
	}

	/**
	 * 认证
	 * SecurityUtils.getSubject().login(token); 这句话 才 回掉 该方法
	 * 
	 */
	@Override
	public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken =(UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();
		String password = new String(usernamePasswordToken.getPassword());
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
	    user=userService.findByUsernameAndPassword(user);
		SecurityUtils.getSubject().getSession().setAttribute("user", user);
		SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(username,password,this.getClass().getName());
		return authenticationInfo;
	}
	
	
	

}
