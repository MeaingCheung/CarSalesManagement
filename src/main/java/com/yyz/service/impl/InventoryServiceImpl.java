package com.yyz.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyz.dao.InventoryMapper;
import com.yyz.dto.InventoryDto;
import com.yyz.entity.Car;
import com.yyz.entity.Inventory;
import com.yyz.entity.Manufacturer;
import com.yyz.service.CarService;
import com.yyz.service.InventoryService;
import com.yyz.service.ManufacturerService;
import com.yyz.util.AmountUtil;
import com.yyz.util.DateUtil;

/**
 * 业务服务层实现 - 表: inventory
 * 
 * @company: 河南财经政法大学
 * @author: zq
 * @since 1.0
 * @date: 2017-04-11 19:53:41
 */
@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {

	@Resource
	private InventoryMapper		inventoryMapper;
	@Autowired
	private CarService			carService;
	@Autowired
	private ManufacturerService	manufacturerService;

	@Override
	public int insert(Inventory entity) {
		try {
			return inventoryMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public int update(Inventory entity) {
		try {
			return inventoryMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return Inventory
	 */
	@Override
	public Inventory findByPrimaryKey(Long id) {
		try {
			return inventoryMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public Inventory findByUniqueKey(String carSerialNumber, long costPrice) {
		try {
			return inventoryMapper.selectByUniqueKey(carSerialNumber, costPrice);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public List<InventoryDto> findByConditionAndPage(String carSerialNumber, int beginIndex, int size) {
		List<InventoryDto> inventoryDtoList = new ArrayList<InventoryDto>();
		try {
			List<Inventory> inventoryList = inventoryMapper.selectByConditionAndPage(carSerialNumber, beginIndex, size);
			for (Inventory inventory : inventoryList) {
				InventoryDto inventoryDto = new InventoryDto();
				inventoryDto.setAmount(AmountUtil.narrowTenThousands(inventory.getAmount()));
				Car car = carService.findByUniqueKey(inventory.getCarSerialNumber());
				if (car == null) {
					continue;
				}
				inventoryDto.setCarName(car.getName());
				inventoryDto.setCarSerialNumber(inventory.getCarSerialNumber());
				inventoryDto.setComment(inventory.getComment());
				inventoryDto.setCostPrice(AmountUtil.narrowTenThousands(inventory.getCostPrice()));
				inventoryDto.setCreateTime(DateUtil.convertTimeStampToString(inventory.getCreateTime()));
				inventoryDto.setId(inventory.getId());
				inventoryDto.setUpdateTime(DateUtil.convertTimeStampToString(inventory.getUpdateTime()));
				car.getManufacturerId();
				Manufacturer manufacturer = manufacturerService.findByPrimaryKey(car.getManufacturerId());
				inventoryDto.setManufacturerName(manufacturer == null ? "" : manufacturer.getName());
				inventoryDtoList.add(inventoryDto);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return inventoryDtoList;
	}
}