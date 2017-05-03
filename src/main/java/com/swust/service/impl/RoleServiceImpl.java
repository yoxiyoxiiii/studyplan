package com.swust.service.impl;

import com.swust.base.PageInfo;
import com.swust.domain.Role;
import com.swust.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("roleService")
@Transactional//事物管理
public class RoleServiceImpl implements RoleService {

	@Autowired
	private com.swust.mapper.RoleMapper RoleMapper;
	
	public Role findById(Integer id) {
		return RoleMapper.findById(id);
	}

	public boolean save(Role entity) {
		RoleMapper.save(entity);
		return true;
	}

	public boolean deleteById(Integer id) {
		RoleMapper.deleteById(id);
		return true;
	}

	public boolean update(Role entity) {
		RoleMapper.update(entity);
		return true;
	}

	public List<PageInfo<Role>> findByPage(PageInfo<Role> pageInfo) {
		List<PageInfo<Role>> pages=RoleMapper.findByPage(pageInfo);
		return pages ;
	}

	
}
