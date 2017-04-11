package com.yyz.service;

import java.util.List;

import com.yyz.dto.InventoryDto;
import com.yyz.entity.InventoryRecord;

/**
 * 业务服务层接口 - 表: inventoryrecord
 * 
 * @company 河南财经政法大学
 * @author zq
 * @since 1.0
 * @date 2017-04-11 19:54:23
 */
public interface InventoryRecordService {
	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return InventoryRecord
	 */
	InventoryRecord findByPrimaryKey(Long id);

	/**
	 * 全字段插入
	 *
	 * @param entity
	 * @return
	 */
	int insert(InventoryRecord entity);

	/**
	 * 全字段更新
	 *
	 * @param entity
	 * @return
	 */
	int update(InventoryRecord entity);

}