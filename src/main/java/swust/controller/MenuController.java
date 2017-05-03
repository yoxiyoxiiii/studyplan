package com.swust.controller;

import com.swust.base.PageInfo;
import com.swust.domain.Menu;
import com.swust.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/menu")
public class MenuController{
	
	@Resource(name="menuService")
	private MenuService menuService;
	
	/**
	 * 菜单
	 * @param pageInfo
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(PageInfo<Menu> pageInfo){
		ModelAndView modelAndView =new ModelAndView();
		List<PageInfo<Menu>> pages = menuService.findByPage(pageInfo);
		modelAndView.addObject("pages", pages);
		modelAndView.setViewName("/admin/menu/list");
		return modelAndView;
		
	}
	
	/**
	 * 添加页面
	 * @return
	 */
	@RequestMapping("/add")
	public ModelAndView add(){//使用 Model 对象 向页面传值
		ModelAndView modelAndView =new ModelAndView();
		List<Menu> list=menuService.findTopMenu();
		modelAndView.addObject("menuList",list);
		modelAndView.setViewName("/admin/menu/add");
		return modelAndView;
	}
	
	/**
	 * 保持菜单
	 * @param menu
	 * @return
	 */
	@RequestMapping("/save")
	public ModelAndView save(Menu menu){
		ModelAndView modelAndView =new ModelAndView();
		menuService.save(menu);
		modelAndView.setViewName("redirect:/menu/list");
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
		Menu menu = menuService.findById(id);
		modelAndView.addObject("menu", menu);
		modelAndView.setViewName("/admin/menu/edit");
		return modelAndView;
	}
	
	/**
	 * 修改菜单
	 * @param menu
	 * @return
	 */
	@RequestMapping("/update")
	//@ModelAttribute 在这里使用 既可以 绑定参数，也可以做为数据回显
	public ModelAndView update(@ModelAttribute(name="menu")Menu menu){
		menuService.update(menu);
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("redirect:/menu/list");
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
		menuService.deleteById(id);
		modelAndView.setViewName("redirect:/menu/list");
		return modelAndView;
	}

}
