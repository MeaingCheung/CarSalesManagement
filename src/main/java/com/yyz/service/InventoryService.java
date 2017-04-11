package com.yyz.service;

import java.util.List;

import com.yyz.dto.InventoryDto;
import com.yyz.entity.Inventory;

/**
 * 业务服务层接口 - 表: inventory
 * 
 * @company 河南财经政法大学
 * @author zq
 * @since 1.0
 * @date 2017-04-11 19:53:41
 */
public interface InventoryService {
	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return Inventory
	 */
	Inventory findByPrimaryKey(Long id);

	/**
	 * 全字段插入
	 *
	 * @param entity
	 * @return
	 */
	int insert(Inventory entity);

	/**
	 * 全字段更新
	 *
	 * @param entity
	 * @return
	 */
	int update(Inventory entity);

	/**
	 * 根据唯一索引查询
	 *
	 * @param carSerialNumber
	 * @param costPrice
	 * @return
	 */
	Inventory findByUniqueKey(String carSerialNumber, long costPrice);

	/**
	 * 根据条件进行查询
	 *
	 * @param carSerialNumber
	 * @param beginIndex
	 * @param size
	 * @return
	 */
	List<InventoryDto> findByConditionAndPage(String carSerialNumber, int beginIndex, int size);
}