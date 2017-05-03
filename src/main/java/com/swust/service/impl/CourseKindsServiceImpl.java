package com.swust.service.impl;

import com.swust.base.PageInfo;
import com.swust.domain.CourseFiles;
import com.swust.domain.CourseKinds;
import com.swust.mapper.CourseKindsMapper;
import com.swust.service.CourseKindsService;
import com.swust.shiro.EhcacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("courseKindsService")
@Transactional//事物管理
public class CourseKindsServiceImpl implements CourseKindsService{

	@Autowired
	private CourseKindsMapper courseKindsMapper;
	@Autowired
	private EhcacheUtils<String, List<CourseKinds>> cache;
	private  String baseUrl="/course/getByUpId"; 
	
	
	public CourseKinds findById(Integer id) {
		return courseKindsMapper.findById(id);
	}

	public boolean save(CourseKinds entity) {
		courseKindsMapper.save(entity);
		Integer lastId = entity.getId();
		entity.setUrl(baseUrl+"?id="+lastId);// /course/getByUpId?id=2
		courseKindsMapper.update(entity);
		return true;
	}

	public boolean deleteById(Integer id) {
		courseKindsMapper.deleteById(id);
		return true;
	}

	public boolean update(CourseKinds entity) {
		courseKindsMapper.update(entity);
		return true;
	}

	public List<PageInfo<CourseKinds>> findByPage(PageInfo<CourseKinds> pageInfo) {
		List<PageInfo<CourseKinds>> pages=courseKindsMapper.findByPage(pageInfo);
		return pages ;
	}

	public List<CourseKinds> findAll() {
		List<CourseKinds> list = courseKindsMapper.findAll();
		return list;
	}

	public PageInfo<CourseFiles> findByUpId(Integer upId) {
		PageInfo<CourseFiles> pageInfo =new PageInfo<CourseFiles>();
		pageInfo.setParam(upId);
		List<CourseFiles> list = courseKindsMapper.findByUpId(pageInfo);
		pageInfo.setData(list);
		return pageInfo ;
	}

	

	

}
