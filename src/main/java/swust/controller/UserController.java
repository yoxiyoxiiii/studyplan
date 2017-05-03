package com.swust.controller;

import com.swust.domain.User;
import com.swust.service.UserService;
import com.swust.shiro.ShiroUtils;
import com.swust.utils.FileUploadUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController{
	 
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	@Resource(name="userService")
	private UserService  userService;

	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("/user/login")
	public ModelAndView login(User user){
		String username = user.getUsername();
		String password = user.getPassword();
		ModelAndView modelAndView=new ModelAndView();
		try{
			userService.dologin(username, password);
		}catch (UnknownAccountException e) {
			modelAndView.addObject("message", "账号或密码错误！！请重新登录！！");
			modelAndView.addObject("username", username);
			modelAndView.setViewName("forward:/login.jsp");
			return modelAndView;
		}
		modelAndView.setViewName("redirect:/system/homePage");
		return modelAndView;
	}
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping("/user/register")
	public ModelAndView register(){
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("/admin/user/register");
		return modelAndView;
		
	}
	
	/**
	 * 添加
	 * @param user
	 * @param errors
	 * @return
	 * 
	 * @Valida 被标注的实体需要被验证框架校验 ֤
	 * BindingResult 收集校验的错误信息 
	 * 
	 */
	@RequestMapping("/user/add")
	public ModelAndView add(@Validated User user, BindingResult errors){
		boolean flag=true;
		ModelAndView modelAndView =new ModelAndView();
		boolean hasErrors = errors.hasFieldErrors();
		String forward="forward:/login.jsp";
		if(hasErrors){
			flag=false;
			FieldError username = errors.getFieldError("username");//得到验证信息
			FieldError password = errors.getFieldError("password");
			modelAndView.addObject("username", username.getDefaultMessage());//�ŵ� request ����
			modelAndView.addObject("password", password.getDefaultMessage());
			forward="admin/user/register";
		}
		if(flag){
			userService.save(user);
			modelAndView.addObject("message","注册成功！请登录！！");
			}
		modelAndView.setViewName(forward);
		return modelAndView;
	}
	
	/**
	 * 个人信息 中心
	 * @param userId
	 * @param modelAndView
	 * @return
	 */
	@GetMapping("/user/message")
	public ModelAndView message(ModelAndView modelAndView){
		Integer userId =ShiroUtils.getUserId();
		User user = userService.findById(userId);
		modelAndView.addObject("user", user);
		modelAndView.setViewName("/admin/user/message");
		return modelAndView;
	}
	
	/**
	 * 设置 个人信息
	 * @param modelAndView
	 * @return
	 */
	@GetMapping("/message/add")
	public ModelAndView addMessage(ModelAndView modelAndView){
		modelAndView.setViewName("/admin/user/add_message");
		return modelAndView;
	}
	
	/**
	 * 保存 个人信息
	 * @return
	 */
	@PostMapping("/mesage/save")
	public ModelAndView add(@ModelAttribute("user")User user, ModelAndView modelAndView,
                            MultipartFile file, HttpServletRequest request){
		try {
			String path = FileUploadUtils.doUpload(file, request);
			user.setImage(path);
			userService.save(user);
		} catch (Exception e) {
			logger.error("upload image error {}", e.getLocalizedMessage());
		}
		modelAndView.setViewName("redirect:/user/message");
		return modelAndView;
		
	}
	
	/**
	 * 个人信息 编辑
	 * @param modelAndView
	 * @return
	 */
	@GetMapping("/message/edit")
	public ModelAndView edit(ModelAndView modelAndView){
		Integer userId = ShiroUtils.getUserId();
		User user = userService.findById(userId);
		modelAndView.addObject("user", user);
		modelAndView.setViewName("/admin/user/edit_message");
		return modelAndView;
	}
	
	/**
	 * 编辑 保存
	 * @param user
	 * @param file
	 * @param request
	 * @param modelAndView
	 * @return
	 */
	public ModelAndView save(@ModelAttribute("user") User user,
                             MultipartFile file, HttpServletRequest request,
                             ModelAndView modelAndView ){
		userService.update(user);
		modelAndView.setViewName("redirect:/user/messag");
		return modelAndView;
	}
}
