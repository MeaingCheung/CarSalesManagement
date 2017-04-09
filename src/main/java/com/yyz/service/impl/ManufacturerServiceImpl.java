package com.yyz.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yyz.dao.ManufacturerMapper;
import com.yyz.dto.ManufacturerDto;
import com.yyz.entity.Manufacturer;
import com.yyz.service.ManufacturerService;
import com.yyz.util.DateUtil;

/**
 * 业务服务层实现 - 表: manufacturer
 * 
 * @company: 河南财经政法大学
 * @author: yyz
 * @since 1.0
 * @date: 2017-04-07 22:01:28
 */
@Service("manufacturerService")
public class ManufacturerServiceImpl implements ManufacturerService {

	@Resource
	private ManufacturerMapper	manufacturerMapper;

	@Override
	public int insert(Manufacturer entity) {
		try {
			return manufacturerMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public int update(Manufacturer entity) {
		try {
			return manufacturerMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return Manufacturer
	 */
	@Override
	public Manufacturer findByPrimaryKey(Long id) {
		try {
			return manufacturerMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public List<ManufacturerDto> findByConditionAndPage(Long createUserLoginId, int beginIndex, int size) {
		List<ManufacturerDto> manufacturerDtoList = new ArrayList<ManufacturerDto>();
		try {
			List<Manufacturer> manufacturerList = manufacturerMapper.selectByConditionAndPage(createUserLoginId,
					beginIndex, size);
			for (Manufacturer manufacturer : manufacturerList) {
				ManufacturerDto manufacturerDto = new ManufacturerDto();
				manufacturerDto.setAddress(manufacturer.getAddress());
				manufacturerDto.setContactEmail(manufacturer.getContactEmail());
				manufacturerDto.setContactNumber(manufacturer.getContactNumber());
				manufacturerDto.setCreateTime(DateUtil.convertTimeStampToString(manufacturer.getCreateTime()));
				manufacturerDto.setCreateUserLoginId(manufacturer.getCreateUserLoginId() + "");
				manufacturerDto.setId(manufacturer.getId());
				manufacturerDto.setName(manufacturer.getName());
				manufacturerDto.setSerialNumber(manufacturer.getSerialNumber() + "");
				manufacturerDto.setUpdateTime(DateUtil.convertTimeStampToString(manufacturer.getUpdateTime()));
				manufacturerDto.setWebSite(manufacturer.getWebSite());
				manufacturerDtoList.add(manufacturerDto);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return manufacturerDtoList;
	}

	@Override
	public Manufacturer findByUniqueKey(Long serialNumber) {
		try {
			return manufacturerMapper.selectByUniqueKey(serialNumber);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}