package com.yyz.service.impl;

import com.yyz.dao.UserMapper;
import com.yyz.entity.User;
import com.yyz.service.UserService;
import com.yyz.web.controller.BaseController;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

}