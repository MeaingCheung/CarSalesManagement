package com.yyz.service;

import java.util.List;

import com.yyz.dto.CarDto;
import com.yyz.entity.Car;

/**
 * 业务服务层接口 - 表: car
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @since 1.0
 * @date 2017-04-09 12:36:31
 */
public interface CarService {
	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return Car
	 */
	Car findByPrimaryKey(Long id);

	/**
	 * 全字段更新
	 * 
	 * @param entity
	 * @return
	 */
	int update(Car entity);

	/**
	 * 全字段插入
	 * 
	 * @param entity
	 */
	int insert(Car entity);

	/**
	 * 根据条件分页插叙
	 *
	 * @param createUserLoginId
	 * @param type
	 * @param beginIndex
	 * @param size
	 * @return
	 */
	List<CarDto> findByConditionAndPage(Long createUserLoginId, Integer type, int beginIndex, int size);

	/**
	 * 根据唯一索引查询
	 *
	 * @param serialNumber
	 * @return
	 */
	Car findByUniqueKey(String serialNumber);

}