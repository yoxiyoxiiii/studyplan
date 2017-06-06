package com.swust.controller;

import com.swust.base.PageInfo;
import com.swust.domain.Course;
import com.swust.domain.CourseFiles;
import com.swust.domain.CourseKinds;
import com.swust.service.CourseFilesService;
import com.swust.service.CourseKindsService;
import com.swust.service.CourseService;
import com.swust.service.impl.ActivitiService;
import com.swust.utils.FileUploadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 课程
 * @author Administrator
 *
 */
@Controller
public class CourseController{
	//日志
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);
	//课程
	@Resource(name="courseService")
	private CourseService courseService;
	//课程种类
	@Resource(name="courseKindsService")
	private CourseKindsService courseKindsService;
	//课程资料
	@Autowired
	private CourseFilesService courseFilesService;

	@Autowired
	private ActivitiService activitiService;


	/**
	 * 课程
	 * @param pageInfo
	 * @return
	 */
	@RequestMapping("/course/list")
	public ModelAndView list(PageInfo<Course> pageInfo){
		
		ModelAndView modelAndView =new ModelAndView();
		List<PageInfo<Course>> pages = courseService.findByPage(pageInfo);
		modelAndView.addObject("pages", pages);
		modelAndView.setViewName("/admin/course/list");
		return modelAndView;
		
	}
	
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping("/course/add")
	public ModelAndView add(Model model){//浣跨敤 Model 瀵硅薄 鍚戦〉闈紶鍊�
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("/admin/course/add");
		return modelAndView;
	}
	
	/**
	 * 保存
	 * @param course
	 * @return
	 */
	@RequestMapping("/course/save")
	public ModelAndView save(Course course){
		ModelAndView modelAndView =new ModelAndView();
		courseService.save(course);
		modelAndView.setViewName("redirect:/course/list");
		return modelAndView;
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@RequestMapping("/course/edit")
	public ModelAndView edit(@RequestParam(name="id",required=true)Integer id){
		ModelAndView modelAndView =new ModelAndView();
		Course course = courseService.findById(id);
		Integer kindsId = course.getKindsId();
		CourseKinds kinds = courseKindsService.findById(kindsId);
		modelAndView.addObject("course", course);
		modelAndView.addObject("kinds", kinds);
		modelAndView.setViewName("/admin/course/edit");
		return modelAndView;
	}
	
	/**
	 * 修改保存
	 * @param course
	 * @return
	 */
	@RequestMapping("/course/update")
	//@ModelAttribute 鍦ㄨ繖閲屼娇鐢� 鏃㈠彲浠� 缁戝畾鍙傛暟锛屼篃鍙互鍋氫负鏁版嵁鍥炴樉
	public ModelAndView update(@ModelAttribute(name="course")Course course){
		courseService.update(course);
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("redirect:/course/list");
		return modelAndView;
	}
	
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/course/delete/{id}")
	public ModelAndView delete(@PathVariable( name="id", required = true) Integer id){
		ModelAndView modelAndView = new ModelAndView();
		courseService.deleteById(id);
		modelAndView.setViewName("redirect:/course/list");
		return modelAndView;
	}
	
	//资料上传
	@RequestMapping("/course/upload")
	public ModelAndView upload(@RequestParam(name="id" ,required= true) Integer id){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id",id);
		modelAndView.setViewName("/admin/course/upload");
		return modelAndView;
	}
	
	//保持上传的文件
	@RequestMapping("/course/doUpload")
	public String doUpload(@RequestParam(required=true,name="id") Integer id,
                           @RequestParam(required=true,name="typeId") Boolean typeId,
                           MultipartFile file, HttpServletRequest request){
		//跳转路径
		String redirect="redirect:/course/list";
		//文件保存路径
		String path = null;
		if(file==null){
			return redirect ;
		}
		try {
			path=FileUploadUtils.doUpload(file, request);
			logger.info("upload path = {}",path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		courseFilesService.doUpload(id,typeId,path);
		return redirect;
	}
	
	/**
	 * 获得 第二级 的课程列表
	 * @param upId
	 * @param modelAndView
	 * @return
	 */
	
	@RequestMapping("/course/getByUpId")
	public ModelAndView getByUpId(@RequestParam(name="id",required=true)Integer upId,
                                  ModelAndView modelAndView){
		 PageInfo<Course> pageInfo = courseService.findByUpId(upId);
		 modelAndView.addObject("pageInfo", pageInfo);
		 modelAndView.setViewName("/admin/course/courseList");
		return modelAndView;
		
	}
	
	@GetMapping("/courseFiles/video")
	public ModelAndView getCourseVideo(@RequestParam(name="id",required=true) Integer upId,
                                       ModelAndView modelAndView, HttpServletRequest request){
		activitiService.deployment();
		List<CourseFiles> list=courseFilesService.findByUpId(upId);
		modelAndView.addObject("list",list);
		modelAndView.setViewName("/admin/course/show");
		return modelAndView;
	}
	
	@RequestMapping("/course/fileList")
	public ModelAndView fileList(@RequestParam(name="id",required=true)Integer id,
                                 ModelAndView modelAndView, PageInfo<CourseFiles> pageInfo){
		PageInfo<CourseFiles> findByCId = courseFilesService.findByCId(id);
		modelAndView.addObject("list", findByCId);
		modelAndView.setViewName("/admin/course/filesList");
		return modelAndView;
	}

	
	
	//===课程种类===
	@RequestMapping("/kinds/list")
	public ModelAndView kindsList(PageInfo<CourseKinds> pageInfo){
		ModelAndView modelAndView =new ModelAndView();
		List<PageInfo<CourseKinds>> pages = courseKindsService.findByPage(pageInfo);
		modelAndView.addObject("pages", pages);
		modelAndView.setViewName("/admin/courseKinds/list");
		return modelAndView;
		
	}
	
	/**
	 * 娣诲姞椤甸潰
	 * @return
	 */
	@RequestMapping("/kinds/add")
	public ModelAndView kindsAdd(){//浣跨敤 Model 瀵硅薄 鍚戦〉闈紶鍊�
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("/admin/courseKinds/add");
		return modelAndView;
	}
	
	/**
	 * 淇濇寔鑿滃崟
	 * @param
	 * @return
	 */
	@RequestMapping("/kinds/save")
	public ModelAndView kindsSave(CourseKinds kinds){
		ModelAndView modelAndView =new ModelAndView();
		courseKindsService.save(kinds);
		modelAndView.setViewName("redirect:/kinds/list");
		return modelAndView;
	}
	
	/**
	 * 缂栬緫椤甸潰
	 * @param id
	 * @return
	 */
	@RequestMapping("/kinds/edit")
	public ModelAndView kindsEdit(@RequestParam(name="id",required=true)Integer id){
		ModelAndView modelAndView =new ModelAndView();
		CourseKinds kinds = courseKindsService.findById(id);
		modelAndView.addObject("courseKinds", kinds);
		modelAndView.setViewName("/admin/courseKinds/edit");
		return modelAndView;
	}
	
	/**
	 * 淇敼鑿滃崟
	 * @param
	 * @return
	 */
	@RequestMapping("/kinds/update")
	//@ModelAttribute 鍦ㄨ繖閲屼娇鐢� 鏃㈠彲浠� 缁戝畾鍙傛暟锛屼篃鍙互鍋氫负鏁版嵁鍥炴樉
	public ModelAndView kindsUpdate(CourseKinds kinds){
		courseKindsService.update(kinds);
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("redirect:/kinds/list");
		return modelAndView;
	}
	
	
	/**
	 * 鍒犻櫎鑿滃崟
	 * @param id
	 * @return
	 */
	@RequestMapping("/kinds/delete/{id}")
	public ModelAndView kindsDelete(@PathVariable( name="id", required = true) Integer id){
		ModelAndView modelAndView = new ModelAndView();
		courseKindsService.deleteById(id);
		modelAndView.setViewName("redirect:/kinds/list");
		return modelAndView;
	}

	
}
