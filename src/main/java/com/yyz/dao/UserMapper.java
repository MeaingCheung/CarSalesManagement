package com.yyz.dao;

import com.yyz.commons.BaseMapper;
import com.yyz.entity.User;

/**
 * MyBatis Mapper 接口 - 表：user
 * 
 * @since 2017-03-11 11:36:40
 */
public interface UserMapper extends BaseMapper {
	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 */
	int insert(User record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 */
	int insertSelective(User record);

	/**
	 * 按主键查询
	 */
	User selectByPrimaryKey(Long id);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 */
	int updateByPrimaryKey(User record);

}