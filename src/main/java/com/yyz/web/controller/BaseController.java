package com.yyz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

	@RequestMapping(value = "/test", method = { RequestMethod.GET, RequestMethod.POST })
	public String test(HttpServletRequest request) {
		return "test";
	}
}
