package com.yyz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyz.dao.UserMapper;
import com.yyz.entity.User;
import com.yyz.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	//
	@Override
	public int insert(User user) {
		return userMapper.insertSelective(user);
	}
}
