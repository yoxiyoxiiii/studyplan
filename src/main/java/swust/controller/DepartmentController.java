package com.swust.controller;

import com.swust.base.PageInfo;
import com.swust.domain.Department;
import com.swust.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/list")
	public ModelAndView list(ModelAndView modelAndView){
		PageInfo<Department> pageInfo =new PageInfo<Department>();
//		List<Department> data=departmentService.findPage(pageInfo);
//		pageInfo.setData(data);
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.setViewName("/admin/department/list");
		return modelAndView;
	}
	
	@GetMapping("/add")
	public String add(){
		return "/admin/department/add";
	}
	
	@PostMapping("/save")
	public ModelAndView save(ModelAndView modelAndView, Department department){
		departmentService.save(department);
		modelAndView.setViewName("redirect:/department/list");
		return modelAndView;
	}
	
	
	@GetMapping("/edit")
	public @ModelAttribute("department") Department edit(@RequestParam("id") Integer id,
                                                         ModelAndView modelAndView){
		Department department = departmentService.findById(id);
		modelAndView.setViewName("/admin/department/edit");
		return department;
	}
	
	@PostMapping("/update")
	public String update(Department department){
		departmentService.update(department);
		return "redirect:/department/list";
	}

	
	
}
