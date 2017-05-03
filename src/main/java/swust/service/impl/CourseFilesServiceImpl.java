package com.swust.service.impl;

import com.swust.base.PageInfo;
import com.swust.domain.CourseFiles;
import com.swust.domain.CourseKinds;
import com.swust.mapper.CourseFilesMapper;
import com.swust.service.CourseFilesService;
import com.swust.shiro.EhcacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("courseFilesService")
@Transactional//事物管理
public class CourseFilesServiceImpl implements CourseFilesService{

	@Autowired
	private CourseFilesMapper courseFilesMapper;
	@Autowired
	private EhcacheUtils<String, List<CourseKinds>> cache;
	
	
	public CourseFiles findById(Integer id) {
		return courseFilesMapper.findById(id);
	}

	public boolean save(CourseFiles entity) {
		courseFilesMapper.save(entity);
		
		return true;
	}

	public boolean deleteById(Integer id) {
		courseFilesMapper.deleteById(id);
		return true;
	}

	public boolean update(CourseFiles entity) {
		courseFilesMapper.update(entity);
		return true;
	}
	
	public boolean doUpload(Integer id, boolean typeId, String path) {
		CourseFiles entity=new CourseFiles();
		entity.setcId(id);
		entity.setFilesPath(path);
		entity.setTypeid(typeId);
		courseFilesMapper.save(entity);
		return true;
	}

	public List<PageInfo<CourseFiles>> findByPage(PageInfo<CourseFiles> pageInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public PageInfo<CourseFiles> findByCId(Integer id) {
		PageInfo<CourseFiles> pageInfo =new PageInfo<CourseFiles>();
		Object [] params ={id};
		pageInfo.setParams(params);
		List<CourseFiles> list = courseFilesMapper.findPage(pageInfo);
		//设置 fileName
		for(CourseFiles c:list){
			String filesPath = c.getFilesPath();
			int lastIndexOf = filesPath.lastIndexOf("#");
			String fileName = filesPath.substring(lastIndexOf+1);
			c.setFileName(fileName);
		}
		pageInfo.setData(list);
		return pageInfo;
	}

	public List<CourseFiles> findByUpId(Integer upId) {
		List<CourseFiles> list = courseFilesMapper.findByUpId(upId);
		return list;
	}






	

	

}
