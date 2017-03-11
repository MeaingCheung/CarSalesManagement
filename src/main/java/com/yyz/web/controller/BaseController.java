package com.yyz.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyz.entity.User;
import com.yyz.service.UserService;
import com.yyz.util.ValidateCodeGenerator;
import com.yyz.util.VerificationCodeUtil;

@Controller
public class BaseController {

	@Autowired
	private UserService			userService;
	private final static Logger	logger	= LoggerFactory.getLogger(BaseController.class);

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
		logger.info("打印日志。");
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
		// user.setCreateTime(now.intValue());
		// user.setLoginIdAsOrgUser(0L);
		// user.setLoginPassword("1234");
		// user.setStatus(Short.valueOf("0"));
		// user.setUpdateTime(now.intValue());
		// user.setVisibleInOrg(1);
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

	@RequestMapping(value = "/imageServlet", method = { RequestMethod.POST, RequestMethod.GET })
	public void imageServlet(HttpServletRequest request, HttpServletResponse response) {
		// 设置相应类型,告诉浏览器输出的内容为图片
		response.setContentType("image/jpeg");
		// 设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);
		ValidateCodeGenerator randomValidateCode = new ValidateCodeGenerator();
		try {
			// 输出图片方法
			randomValidateCode.getPicRandcode(request, response);
		} catch (Exception e) {
			logger.error(e.toString());
		}
	}
}
