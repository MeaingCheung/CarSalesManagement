package com.yyz.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yyz.dao.UserMapper;
import com.yyz.dto.UserDto;
import com.yyz.entity.User;
import com.yyz.enumerate.Department;
import com.yyz.enumerate.Gender;
import com.yyz.enumerate.UserPosition;
import com.yyz.service.UserService;
import com.yyz.util.DateUtil;

/**
 * 业务服务层实现 - 表: user
 * 
 * @company: 杭州转乾网络
 * @author: zq
 * @since 1.0
 * @date: 2017-03-11 11:36:40
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	private static final Logger	logger	= LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource
	private UserMapper			userMapper;

	@Override
	public int insert(User entity) {
		try {
			return userMapper.insertSelective(entity);
		} catch (Exception e) {
			logger.error(e.toString());
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public int update(User entity) {
		try {
			return userMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public User findByPrimaryKey(Long id) {
		try {
			return userMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public User findNormalUserByLoginName(String loginName) {
		try {
			return userMapper.selectByLoginName(loginName);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public List<UserDto> findByConditionAndPage(Integer position, Integer department, int beginIndex, int size) {
		try {
			List<UserDto> userDtoList = new ArrayList<UserDto>();
			List<User> userList = userMapper.selectByConditionAndPage(position, department, beginIndex, size);
			for (User user : userList) {
				UserDto userDto = new UserDto();
				userDto.setId(user.getId());
				userDto.setCreateTime(DateUtil.convertTimeStampToString(user.getCreateTime()));
				Department departmentEnu = Department.getByValue(user.getDepartment());
				userDto.setDepartment(departmentEnu == null ? "" : departmentEnu.getComment());
				userDto.setAge(user.getAge());
				userDto.setLoginId(user.getLoginId());
				userDto.setLoginMail(user.getLoginMail());
				userDto.setLoginName(user.getLoginName());
				userDto.setLoginPhone(user.getLoginPhone());
				UserPosition userRole = UserPosition.getByValue(user.getPosition());
				userDto.setPosition(userRole == null ? "" : userRole.getComment());
				userDto.setGender(Gender.getByValue(user.getGender()).getComment());
				userDto.setUpdateTime(DateUtil.convertTimeStampToString(user.getUpdateTime()));
				userDto.setUserRemark(user.getUserRemark());
				userDtoList.add(userDto);
			}
			return userDtoList;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}

	}

	@Override
	public Long findMaxLoginId() {
		try {
			return userMapper.selectMaxLoginId();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}