package com.swust.service.impl;

import com.swust.base.PageInfo;
import com.swust.domain.Department;
import com.swust.mapper.DepartmentMapper;
import com.swust.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	
	public Department findById(Integer id) {
		return departmentMapper.findById(id);
	}

	public boolean save(Department entity) {
		departmentMapper.save(entity);
		return true;
	}

	public boolean deleteById(Integer id) {
		departmentMapper.deleteById(id);
		return true;
	}

	public boolean update(Department entity) {
		departmentMapper.update(entity);
		return true;
	}

	public List<PageInfo<Department>> findByPage(PageInfo<Department> pageInfo) {
		return null;
	}

	public PageInfo<Department> findPage(PageInfo<Department> pageInfo) {
		List<Department>  data= departmentMapper.findPage(pageInfo);
		pageInfo.setData(data);
		return pageInfo;
	}

}
