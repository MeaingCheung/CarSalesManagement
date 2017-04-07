package com.yyz.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yyz.dao.CustomerMapper;
import com.yyz.dto.CustomerDto;
import com.yyz.entity.Customer;
import com.yyz.enumerate.Gender;
import com.yyz.service.CustomerService;
import com.yyz.util.DateUtil;

/**
 * 业务服务层实现 - 表: customer
 * 
 * @company:河南财经政法大学
 * @author: yyz
 * @since 1.0
 * @date: 2017-04-06 21:46:28
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomerMapper	customerMapper;

	@Override
	public int insert(Customer entity) {
		try {
			return customerMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public int update(Customer entity) {
		try {
			return customerMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return Customer
	 */
	@Override
	public Customer findByPrimaryKey(Long id) {
		try {
			return customerMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public List<CustomerDto> findByConditionAndPage(Long createUserLoginId, Integer gender, int beginIndex, int size) {
		try {
			List<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();
			List<Customer> customerList = customerMapper.selectByConditionAndPage(createUserLoginId, gender,
					beginIndex, size);
			for (Customer customer : customerList) {
				CustomerDto customerDto = new CustomerDto();
				customerDto.setAddress(customer.getAddress());
				customerDto.setAge(customer.getAge());
				customerDto.setCreateTime(DateUtil.convertTimeStampToString(customer.getCreateTime()));
				customerDto.setEmail(customer.getEmail());
				customerDto.setGender(Gender.getByValue(customer.getGender()).getComment());
				customerDto.setId(customer.getId());
				customerDto.setIdentifierNumber(customer.getIdentifierNumber() + "");
				customerDto.setName(customer.getName());
				customerDto.setPhoneNumber(customer.getPhoneNumber());
				customerDto.setJob(customer.getJob());
				customerDto.setUpdateTime(DateUtil.convertTimeStampToString(customer.getUpdateTime()));
				customerDto.setCreateUserLoginId(customer.getCreateUserLoginId() + "");
				customerDtoList.add(customerDto);
			}
			return customerDtoList;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public Customer findByUniqueKey(Long identifierNumber) {
		try {
			return customerMapper.selectByUniqueKey(identifierNumber);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}