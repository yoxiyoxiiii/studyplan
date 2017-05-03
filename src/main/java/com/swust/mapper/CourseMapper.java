package com.swust.mapper;

import com.swust.base.BaseMapper;
import com.swust.domain.Course;

import java.util.List;
import java.util.Map;

public interface CourseMapper extends BaseMapper<Course, Integer> {

	/**
	 * 处理文件上传
	 * @param entity
	 * @return
	 */
	boolean doUpload(Map<String, Object> map);

	List<Course> finByUpId(Integer upId);
   
}