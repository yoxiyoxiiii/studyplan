package com.swust.service.impl;

import com.swust.base.PageInfo;
import com.swust.domain.Menu;
import com.swust.mapper.MenuMapper;
import com.swust.service.MenuService;
import com.swust.shiro.EhcacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("menuService")
@Transactional//事物管理
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private EhcacheUtils<String, List<Menu>> cache;
	
	public Menu findById(Integer id) {
		return menuMapper.findById(id);
	}

	public boolean save(Menu entity) {
		menuMapper.save(entity);
		return true;
	}

	public boolean deleteById(Integer id) {
		menuMapper.deleteById(id);
		return true;
	}

	public boolean update(Menu entity) {
		menuMapper.update(entity);
		return true;
	}

	public List<PageInfo<Menu>> findByPage(PageInfo<Menu> pageInfo) {
		List<PageInfo<Menu>> pages=menuMapper.findByPage(pageInfo);
		return pages ;
	}

	public List<Menu> findTopMenu() {
		List<Menu> list=menuMapper.findTopMenu();
		return list;
	}

	public List<Menu> finAll() {
	 List<Menu> allMenu = menuMapper.findAll();
		return allMenu;
	}

}
