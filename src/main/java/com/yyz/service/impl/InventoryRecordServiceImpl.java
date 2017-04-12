package com.yyz.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyz.dao.InventoryRecordMapper;
import com.yyz.dto.InventoryRecordDto;
import com.yyz.entity.Car;
import com.yyz.entity.Inventory;
import com.yyz.entity.InventoryRecord;
import com.yyz.enumerate.InventoryOperateType;
import com.yyz.service.CarService;
import com.yyz.service.InventoryRecordService;
import com.yyz.service.InventoryService;
import com.yyz.util.AmountUtil;
import com.yyz.util.DateUtil;

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
	@Autowired
	private CarService				carService;
	@Autowired
	private InventoryService		inventoryService;

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

	@Override
	public List<InventoryRecordDto> findByConditionAndPage(Long inventoryId, Integer type, int beginIndex, int size) {
		List<InventoryRecordDto> inventoryRecordDtoList = new ArrayList<InventoryRecordDto>();
		try {
			List<InventoryRecord> inventoryRecordList = inventoryRecordMapper.selectByConditionAndPage(inventoryId,
					type, beginIndex, size);
			for (InventoryRecord inventoryRecord : inventoryRecordList) {
				InventoryRecordDto inventoryRecordDto = new InventoryRecordDto();
				String carSerialNumber = inventoryRecord.getCarSerialNumber();
				Car car = carService.findByUniqueKey(carSerialNumber);
				if (car == null) {
					inventoryRecordDto.setCarName("--");
				} else {
					inventoryRecordDto.setCarName(car.getName());
				}
				inventoryRecordDto.setCarSerialNumber(carSerialNumber);
				inventoryRecordDto.setChangeAmount(AmountUtil.narrowTenThousands(inventoryRecord.getChangeAmount()));
				inventoryRecordDto.setChangeInventoryTime(DateUtil.convertTimeStampToString(inventoryRecord
						.getChangeInventoryTime()));
				inventoryRecordDto.setComment(inventoryRecord.getComment());
				inventoryRecordDto.setId(inventoryRecord.getId());
				inventoryRecordDto.setInventoryId(inventoryRecord.getInventoryId());
				inventoryRecordDto.setOperateUserLoginId(inventoryRecord.getOperateUserLoginId());
				inventoryRecordDto
						.setOriginalAmount(AmountUtil.narrowTenThousands(inventoryRecord.getOriginalAmount()));
				inventoryRecordDto.setType(InventoryOperateType.getByValue(inventoryRecord.getType()).getComment());
				Inventory inventory = inventoryService.findByPrimaryKey(inventoryRecord.getInventoryId());
				if (inventory == null) {
					inventoryRecordDto.setCostPrice("--");
				} else {
					inventoryRecordDto.setCostPrice(AmountUtil.narrowTenThousands(inventory.getCostPrice()));
				}
				inventoryRecordDtoList.add(inventoryRecordDto);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return inventoryRecordDtoList;
	}

}