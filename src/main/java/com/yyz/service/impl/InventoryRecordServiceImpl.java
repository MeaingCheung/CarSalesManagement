package com.yyz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yyz.dao.InventoryRecordMapper;
import com.yyz.entity.InventoryRecord;
import com.yyz.service.InventoryRecordService;

/**
 * 业务服务层实现 - 表: inventoryrecord
 * 
 * @company: 河南财经政法大学
 * @author: zq
 * @since 1.0
 * @date: 2017-04-11 19:54:23
 */
@Service("inventoryRecordService")
public class InventoryRecordServiceImpl implements InventoryRecordService {

	@Resource
	private InventoryRecordMapper	inventoryRecordMapper;

	@Override
	public int insert(InventoryRecord entity) {
		try {
			return inventoryRecordMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public int update(InventoryRecord entity) {
		try {
			return inventoryRecordMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public InventoryRecord findByPrimaryKey(Long id) {
		try {
			return inventoryRecordMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}