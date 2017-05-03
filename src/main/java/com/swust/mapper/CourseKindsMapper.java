package com.swust.mapper;

import com.swust.base.BaseMapper;
import com.swust.base.PageInfo;
import com.swust.domain.CourseFiles;
import com.swust.domain.CourseKinds;

import java.util.List;

public interface CourseKindsMapper extends BaseMapper<CourseKinds, Integer>{

	List<CourseKinds> findAll();

	/**
	 * 获得 记录总数
	 * @return
	 */
	int getCount();
	
	
	List<CourseFiles>findByUpId(PageInfo<CourseFiles> pageInfo);
    
}