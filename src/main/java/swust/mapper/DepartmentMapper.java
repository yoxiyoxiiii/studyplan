package com.swust.mapper;

import com.swust.base.BaseMapper;
import com.swust.base.PageInfo;
import com.swust.domain.Department;

import java.util.List;

public interface DepartmentMapper extends BaseMapper<Department, Integer> {
	List<Department> findPage(PageInfo<Department> pageInfo);
   
}