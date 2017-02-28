/**
 * Copyright (c) 2015, 杭州转乾网络. All rights reserved.
 */
package com.yyz.dao;

import com.yyz.commons.BaseMapper;
import com.yyz.entity.User;

/**
 * 
 * @company yyz
 * @author MeaingCheung
 * @version UserMapper.java, v 0.1 2017年2月27日 下午10:01:40
 */
public interface UserMapper extends BaseMapper {

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
	 * 按主键更新 - 仅更新给定实体类中非null,除loginPhone之外的字段
	 */
	int updateByPrimaryKeySelectiveExceptLoginPhone(User record);

}
