package com.yyz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yyz.commons.BaseMapper;
import com.yyz.entity.Customer;

/**
 * MyBatis Mapper 接口 - 表：customer
 * 
 * @since 2017-04-06 21:46:28
 */
public interface CustomerMapper extends BaseMapper {
	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 */
	int insert(Customer record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 */
	int insertSelective(Customer record);

	/**
	 * 按主键查询
	 */
	Customer selectByPrimaryKey(Long id);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 */
	int updateByPrimaryKeySelective(Customer record);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 */
	int updateByPrimaryKey(Customer record);

	/**
	 * 根据条件分页查询
	 *
	 * @param createUserLoginId
	 * @param gender
	 * @param beginIndex
	 * @param size
	 * @return
	 */
	List<Customer> selectByConditionAndPage(@Param("createUserLoginId") Long createUserLoginId,
			@Param("gender") Integer gender, @Param("beginIndex") int beginIndex, @Param("size") int size);

	/**
	 * 根据唯一索引查询
	 *
	 * @param identifierNumber
	 * @return
	 */
	Customer selectByUniqueKey(@Param("identifierNumber") Long identifierNumber);

}