package com.swust.service;

import com.swust.base.BaseService;
import com.swust.base.PageInfo;
import com.swust.domain.CourseFiles;
import com.swust.domain.CourseKinds;

import java.util.List;

public interface CourseKindsService extends BaseService<CourseKinds, Integer>{

	/**
	 * 得到 所有
	 * @return
	 */
	List<CourseKinds> findAll();
	
    PageInfo<CourseFiles> findByUpId(Integer upId);

}
