package com.yyz.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyz.dao.CarMapper;
import com.yyz.dto.CarDto;
import com.yyz.entity.Car;
import com.yyz.entity.Manufacturer;
import com.yyz.enumerate.CarType;
import com.yyz.service.CarService;
import com.yyz.service.ManufacturerService;
import com.yyz.util.DateUtil;

/**
 * 业务服务层实现 - 表: car
 * 
 * @company: 河南财经政法大学
 * @author: yyz
 * @since 1.0
 * @date: 2017-04-09 12:36:31
 */
@Service("carService")
public class CarServiceImpl implements CarService {

	@Resource
	private CarMapper			carMapper;

	@Autowired
	private ManufacturerService	manufacturerService;

	@Override
	public int insert(Car entity) {
		try {
			return carMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public int update(Car entity) {
		try {
			return carMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return Car
	 */
	@Override
	public Car findByPrimaryKey(Long id) {
		try {
			return carMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public List<CarDto> findByConditionAndPage(Long createUserLoginId, Integer type, int beginIndex, int size) {
		List<CarDto> carDtoList = new ArrayList<CarDto>();
		try {
			List<Car> carList = carMapper.selectByConditionAndPage(createUserLoginId, type, beginIndex, size);
			for (Car car : carList) {
				CarDto carDto = new CarDto();
				carDto.setColor(car.getColor());
				carDto.setComment(car.getComment());
				carDto.setCreateTime(DateUtil.convertTimeStampToString(car.getCreateTime()));
				carDto.setCreateUserLoginId(car.getCreateUserLoginId());
				carDto.setId(car.getId());
				carDto.setName(car.getName());
				Long manufacturerId = car.getManufacturerId();
				Manufacturer manufacturer = manufacturerService.findByPrimaryKey(manufacturerId);
				carDto.setManufacturerName(manufacturer == null ? "" : manufacturer.getName());
				carDto.setManufacturerId(manufacturerId + "");
				carDto.setProductAddress(car.getProductAddress());
				carDto.setSerialNumber(car.getSerialNumber());
				carDto.setType(CarType.getByValue(car.getType()).getComment());
				carDto.setUpdateTime(DateUtil.convertTimeStampToString(car.getUpdateTime()));
				carDtoList.add(carDto);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return carDtoList;
	}

	@Override
	public Car findByUniqueKey(String serialNumber) {
		try {
			return carMapper.selectByUniqueKey(serialNumber);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}