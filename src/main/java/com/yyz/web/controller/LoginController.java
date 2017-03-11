package com.yyz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yyz.entity.User;
import com.yyz.enumerate.SessionKey;
import com.yyz.service.UserService;
import com.yyz.util.ValidateCodeGenerator;

/**
 * 登录模块Controller
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version LoginController.java, v 0.1 2017年3月11日 上午11:58:44
 */
@Controller
public class LoginController {
	@Autowired
	private UserService			userService;
	private final static Logger	logger	= LoggerFactory.getLogger(BaseController.class);

	/**
	 * 登录接口
	 *
	 * @return
	 */
	@RequestMapping(value = "/loginApi", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginApi(HttpServletRequest request, String username, String password, String validateCode,
			ModelMap modelMap) {
		String errorMsg = "";
		if (StringUtils.isBlank(username)) {
			errorMsg = "用户名不能为空！";
		}
		if (StringUtils.isBlank(password)) {
			errorMsg = "密码不能为空！";
		}
		if (StringUtils.isBlank(validateCode)) {
			errorMsg = "验证码不能为空！";
		}
		if (StringUtils.isNotBlank(errorMsg)) {
			modelMap.addAttribute("errorMsg", errorMsg);
			return "login";
		}
		String validateCodeInSession = (String) request.getSession().getAttribute(SessionKey.VALIDATE.value());
		if (!StringUtils.equalsIgnoreCase(validateCode, validateCodeInSession)) {
			logger.info("validateCode=" + validateCode + ",validateCodeInSession=" + validateCodeInSession);
			errorMsg = "验证码错误！";
			modelMap.addAttribute("errorMsg", errorMsg);
			return "login";
		}
		User user = userService.findNormalUserByLoginName(username);
		if (user == null) {
			errorMsg = "用户不存在！";
			modelMap.addAttribute("errorMsg", errorMsg);
			logger.info(errorMsg);
			return "login";
		}
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		String encodePassword = md5PasswordEncoder.encodePassword(password, "password");
		if (!StringUtils.endsWithIgnoreCase(user.getLoginPassword(), encodePassword)) {
			errorMsg = "密码错误！";
			modelMap.addAttribute("errorMsg", errorMsg);
			logger.info("password=" + password + ",encodePassword=" + encodePassword);
			return "login";
		}
		logger.info("user id =" + user.getId());
		request.getSession().setAttribute(SessionKey.USER.value(), user);
		return "redirect:index";
	}

	/**
	 * 登录成功进行跳转
	 *
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Object attribute = request.getSession().getAttribute(SessionKey.USER.value());
		if (attribute == null) {
			return "error";
		}
		User user = (User) attribute;
		modelMap.addAttribute("user", user);
		return "index";
	}
}
