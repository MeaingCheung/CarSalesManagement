package com.yyz.service;

import java.util.List;

import com.yyz.dto.CustomerDto;
import com.yyz.entity.Customer;

/**
 * 业务服务层接口 - 表: customer
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @since 1.0
 * @date 2017-04-06 21:46:28
 */
public interface CustomerService {
	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return Customer
	 */
	Customer findByPrimaryKey(Long id);

	/**
	 * 全字段插入
	 * 
	 * @param entity
	 */
	int insert(Customer entity);

	/**
	 * 全字段更新
	 *
	 * @param entity
	 * @return
	 */
	int update(Customer entity);

	/**
	 * 根据条件分页查询
	 *
	 * @param createUserLoginId
	 * @param gender
	 * @param beginIndex
	 * @param size
	 * @return
	 */
	List<CustomerDto> findByConditionAndPage(Long createUserLoginId, Integer gender, int beginIndex, int size);

	/**
	 * 根据唯一索引查询
	 *
	 * @param identifierNumber
	 * @return
	 */
	Customer findByUniqueKey(Long identifierNumber);
}