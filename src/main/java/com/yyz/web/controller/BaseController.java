package com.yyz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yyz.entity.User;
import com.yyz.enumerate.SessionKey;
import com.yyz.service.UserService;

@Controller
public class BaseController {

	@Autowired
	private UserService			userService;
	private final static Logger	logger	= LoggerFactory.getLogger(BaseController.class);

	protected User getLoginUser(HttpServletRequest request) {
		Object attribute = request.getSession().getAttribute(SessionKey.USER.value());
		if (attribute != null) {
			return (User) attribute;
		} else {
			return null;
		}

	}
}
