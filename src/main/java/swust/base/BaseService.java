package com.swust.base;

import java.util.List;

/**
 * 
 * @author Administrator
 *
 * @param <T> 实体
 * @param <K> 主键
 */
public interface BaseService<T,K> {

	/**
	 * 根据ID 查询
	 * @param id
	 * @return
	 */
   T findById(K id);
   
   /**
    * 保持实体
    * @param entity
    * @return
    */
   boolean save(T entity);
   
   /**
    * 根据Id 删除
    * @param id
    * @return
    */
   boolean deleteById(K id);
   
   /**
    * 更新
    * @param entity
    * @return
    */
   boolean update(T entity);
   
   /**
    * 分页展示
    * @param pageInfo
    * @return
    */
   List<PageInfo<T>> findByPage(PageInfo<T> pageInfo);
   
   
	
}
