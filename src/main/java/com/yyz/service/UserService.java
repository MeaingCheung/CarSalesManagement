package com.yyz.service;

import com.yyz.entity.User;

/**
 * 业务服务层接口 - 表: user
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @since 1.0
 * @date 2017-03-11 11:36:40
 */
public interface UserService {
	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return User
	 */
	User findByPrimaryKey(Long id);

	/**
	 * 全字段插入
	 * 
	 * @param entity
	 */
	int insert(User entity);

	/**
	 * 全字段更新
	 * 
	 * @param entity
	 * @return void
	 */
	int update(User entity);

	/**
	 * 根据登录名进行查找
	 *
	 * @param loginName
	 * @return
	 */
	User findNormalUserByLoginName(String loginName);
}