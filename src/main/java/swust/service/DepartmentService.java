package com.swust.service;
import com.swust.base.BaseService;
import com.swust.base.PageInfo;
import com.swust.domain.Department;

public interface DepartmentService extends BaseService<Department, Integer> {

	PageInfo<Department> findPage(PageInfo<Department> pageInfo);

}
