package com.swust.base;

import java.util.List;

public interface BaseMapper<T,k> {

	/**
	 * 根据id 查询
	 * @param id
	 * @return
	 */
	T findById(k id);
	
	/**
	 * 根据 IDS 查询
	 * @param ids
	 * @return
	 */
	List<T> findByIds(k[] ids);
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	boolean save(T entity);
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 */
	boolean update(T entity);
	
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	boolean deleteById(k id);
	
	
	/**
	 * 
	 * @param pageInfo
	 * @return
	 */
	List<PageInfo<T>> findByPage(PageInfo<T> pageInfo);
	

	
	
	
}
