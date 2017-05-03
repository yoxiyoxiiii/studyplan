package com.swust.mapper;

import com.swust.base.BaseMapper;
import com.swust.base.PageInfo;
import com.swust.domain.CourseFiles;

import java.util.List;

public interface CourseFilesMapper extends BaseMapper<CourseFiles, Integer> {

	List<CourseFiles> findByCId(Integer id);

	List<CourseFiles> findPage(PageInfo<CourseFiles> pageInfo);

	List<CourseFiles> findByUpId(Integer upId);
	
}