package com.swust.service;

import com.swust.base.BaseService;
import com.swust.domain.Menu;

import java.util.List;

public interface MenuService extends BaseService<Menu,Integer> {

	/**
	 * 只得 顶级菜单
	 * @return
	 */
	List<Menu> findTopMenu();

	List<Menu> finAll();
	
	

}
