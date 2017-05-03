package com.swust.mapper;

import com.swust.base.BaseMapper;
import com.swust.domain.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu,Integer>{

	/**
	 * 得到 所有顶级
	 * @return
	 */
	List<Menu> findTopMenu();

	List<Menu> findAll();

	int getCount();
   
}