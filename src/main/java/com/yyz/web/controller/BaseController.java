package com.yyz.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyz.entity.User;
import com.yyz.service.UserService;

@Controller
public class BaseController {

	@Autowired
	private UserService userService;

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

	/**
	 * 测试json数据的返回
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/testDb", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object testDb(HttpServletRequest request) {
		Map<String, Object> obj = new HashMap<String, Object>();
		User user = new User();
		Long now = System.currentTimeMillis();
		user.setCreateTime(now.intValue());
		user.setLoginIdAsOrgUser(0L);
		user.setLoginPassword("1234");
		user.setStatus(Short.valueOf("0"));
		user.setUpdateTime(now.intValue());
		user.setVisibleInOrg(1);
		try {
			userService.insert(user);
		} catch (Exception e) {
			obj.put("msg", "插入失败");
			System.out.println(e.toString());
			return obj;
		}
		obj.put("msg", "插入成功");
		return obj;
	}
}
