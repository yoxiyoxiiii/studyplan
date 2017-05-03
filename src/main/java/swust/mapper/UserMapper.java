package com.swust.mapper;

import com.swust.base.BaseMapper;
import com.swust.domain.User;

import java.util.Map;

public interface UserMapper extends BaseMapper<User,Integer> {


	/**
	 * ���� �û�������������ѯ�����Ψһ
	 * @param map
	 * @return
	 */
	User findByUsernameAndPassword(Map<String, Object> map);
    
}