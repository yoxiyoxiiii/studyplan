package com.swust.service;

import com.swust.base.BaseService;
import com.swust.base.PageInfo;
import com.swust.domain.CourseFiles;

import java.util.List;

public interface CourseFilesService extends BaseService<CourseFiles, Integer>{

	
	/**
	 * 处理 文件上传
	 * @param id 课程id 
	 * @param typeId 
	 * @param path
	 * @return
	 */
	boolean doUpload(Integer id, boolean typeId, String path);

	/**
	 * 得到 资料列表
	 * @param id
	 * @return
	 */
	PageInfo<CourseFiles> findByCId(Integer id);

	List<CourseFiles> findByUpId(Integer upId);

	

}
