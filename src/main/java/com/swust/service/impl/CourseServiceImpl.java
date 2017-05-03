package com.swust.service.impl;

import com.swust.base.PageInfo;
import com.swust.domain.Course;
import com.swust.mapper.CourseMapper;
import com.swust.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("courseService")
@Transactional//事物管理
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseMapper courseMapper;
	
	public Course findById(Integer id) {
		return courseMapper.findById(id);
	}

	public boolean save(Course entity) {
		courseMapper.save(entity);
		return true;
	}

	public boolean deleteById(Integer id) {
		courseMapper.deleteById(id);
		return true;
	}

	public boolean update(Course entity) {
		courseMapper.update(entity);
		return true;
	}

	public List<PageInfo<Course>> findByPage(PageInfo<Course> pageInfo) {
		List<PageInfo<Course>> pages=courseMapper.findByPage(pageInfo);
		return pages ;
	}

	
	public boolean doUpload(Integer id, Integer typeId, String path) {
		Map<String,Object> map =new HashMap<String,Object>();
		String files_path=null;
		String video_path=null;
		if(typeId==1){
			files_path=path;
		}else{
			video_path=path;
		}
		map.put("id", id);
		map.put("files_path",files_path);
		map.put("video_path", video_path);
		courseMapper.doUpload(map);
		return true;
	}

	
	public PageInfo<Course> findByUpId(Integer upId) {
		List<Course> list=courseMapper.finByUpId(upId);
		PageInfo<Course> pageInfo =new PageInfo<Course>();
		pageInfo.setData(list);
		return pageInfo;
	}

	

	

}
