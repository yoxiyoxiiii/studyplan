package com.swust.service;

import com.swust.base.BaseService;
import com.swust.base.PageInfo;
import com.swust.domain.Course;

public interface CourseService extends BaseService<Course, Integer>{

	/**
	 * 处理文件上传
	 * @param id 实体id
	 * @param typeId 区分文件上传的 类型 ：文本 =1 ;视频=2
	 * @param path
	 * @return
	 */
	boolean doUpload(Integer id, Integer typeId, String path);

	/**
	 * 根据 upid 查询
	 * @param upId
	 * @return
	 */
	PageInfo<Course> findByUpId(Integer upId);

	

}
