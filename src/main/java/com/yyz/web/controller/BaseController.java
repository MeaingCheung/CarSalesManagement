package com.yyz.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {

	/**
	 * 环境测试接口
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/test", method = { RequestMethod.GET, RequestMethod.POST })
	public String test(HttpServletRequest request) {
		return "test";
	}

	/**
	 * 测试json数据的返回
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/testJson", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object testJson(HttpServletRequest request) {
		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("k1", "v1");
		obj.put("k2", "v2");
		obj.put("k3", "v3");
		return obj;
	}
}
