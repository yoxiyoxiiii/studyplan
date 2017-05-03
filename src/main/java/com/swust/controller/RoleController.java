package com.swust.controller;

import com.swust.base.PageInfo;
import com.swust.domain.Role;
import com.swust.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController  {
	
	@Resource(name="roleService")
	private RoleService roleService;
	
	/**
	 * 菜单
	 * @param pageInfo
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(PageInfo<Role> pageInfo){
		ModelAndView modelAndView =new ModelAndView();
		List<PageInfo<Role>> pages = roleService.findByPage(pageInfo);
		modelAndView.addObject("page", pages);
		modelAndView.setViewName("/admin/role/list");
		return modelAndView;
		
	}
	
	/**
	 * 添加页面
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Model model){//使用 Model 对象 向页面传值
		return "/admin/role/add";
	}
	
	/**
	 * 保持菜单
	 * @param Role
	 * @return
	 */
	@RequestMapping("/save")
	public ModelAndView save(Role Role){
		ModelAndView modelAndView =new ModelAndView();
		roleService.save(Role);
		modelAndView.setViewName("redirect:/role/list");
		return modelAndView;
	}
	
	/**
	 * 编辑页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(name="id",required=true)Integer id){
		ModelAndView modelAndView =new ModelAndView();
		Role role = roleService.findById(id);
		modelAndView.addObject("role", role);
		modelAndView.setViewName("/admin/role/edit");
		return modelAndView;
	}
	
	/**
	 * 修改菜单
	 * @param Role
	 * @return
	 */
	@RequestMapping("/update")
	//@ModelAttribute 在这里使用 既可以 绑定参数，也可以做为数据回显
	public ModelAndView update(@ModelAttribute(name="Role")Role Role){
		roleService.update(Role);
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("redirect:/role/list");
		return modelAndView;
	}
	
	
	/**
	 * 删除菜单
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable( name="id", required = true) Integer id){
		ModelAndView modelAndView = new ModelAndView();
		roleService.deleteById(id);
		modelAndView.setViewName("redirect:/role/list");
		return modelAndView;
	}


}
