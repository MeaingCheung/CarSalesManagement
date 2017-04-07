package com.yyz.service;

import java.util.List;

import com.yyz.dto.ManufacturerDto;
import com.yyz.entity.Manufacturer;

/**
 * 业务服务层接口 - 表: manufacturer
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @since 1.0
 * @date 2017-04-07 22:01:28
 */
public interface ManufacturerService {
	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return Manufacturer
	 */
	Manufacturer findByPrimaryKey(Long id);

	/**
	 * 全字段插入
	 * 
	 * @param entity
	 */
	int insert(Manufacturer entity);

	/**
	 * 全字段更新
	 *
	 * @param entity
	 * @return
	 */
	int update(Manufacturer entity);

	/**
	 * 根据条件分页查询
	 *
	 * @param createUserLoginId
	 * @param beginIndex
	 * @param size
	 * @return
	 */
	List<ManufacturerDto> findByConditionAndPage(Long createUserLoginId, int beginIndex, int size);

	/**
	 * 根据唯一索引查询
	 *
	 * @param serialNumber
	 * @return
	 */
	Manufacturer findByUniqueKey(Long serialNumber);
}