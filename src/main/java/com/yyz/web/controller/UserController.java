package com.yyz.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyz.commons.CommonResultObject;
import com.yyz.constant.Constant;
import com.yyz.dto.SelectDto;
import com.yyz.dto.UserDto;
import com.yyz.entity.User;
import com.yyz.enumerate.Department;
import com.yyz.enumerate.SessionKey;
import com.yyz.enumerate.UserRole;
import com.yyz.service.UserService;

/**
 * 
 * @company 河南财经政法大学
 * @author
 * @version UserController.java, v 0.1 2017年3月12日 下午1:30:31
 */
@Controller
public class UserController {
	private final static Logger	logger	= LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService			userService;

	/**
	 * 修改用户密码页面路由
	 *
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/changepasswordUi", method = { RequestMethod.GET, RequestMethod.POST })
	public String changepasswordUi(HttpServletRequest request, ModelMap modelMap) {
		Object attribute = request.getSession().getAttribute(SessionKey.USER.value());
		if (attribute == null) {
			return "login";
		}
		User user = (User) attribute;
		modelMap.addAttribute("user", user);
		return "changepassword";
	}

	@RequestMapping(value = "/changepassword", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public CommonResultObject changepassword(HttpServletRequest request) {
		Object attribute = request.getSession().getAttribute(SessionKey.USER.value());
		CommonResultObject commonResultObject = new CommonResultObject();
		if (attribute == null) {
			return commonResultObject.buildErrorResult("请先登录！");
		}
		String id = request.getParameter("id");
		if (!NumberUtils.isNumber(id)) {
			logger.info("参数错误，id=" + id);
			return commonResultObject.buildErrorResult("操作失败！");
		}
		User user = userService.findByPrimaryKey(Long.valueOf(id));
		User loginUser = (User) attribute;
		UserRole role = UserRole.getByValue(loginUser.getRole());
		if (!UserRole.ADMIN.equals(role) && !user.getId().equals(loginUser.getId())) {
			return commonResultObject.buildErrorResult("无权限！");
		}
		String oldpassword = request.getParameter("oldpassword");
		if (StringUtils.isBlank(oldpassword)) {
			return commonResultObject.buildErrorResult("请输入旧密码！");
		}
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		String encodePassword = md5PasswordEncoder.encodePassword(oldpassword, Constant.MD5_SALT);
		if (!StringUtils.equalsIgnoreCase(user.getLoginPassword(), encodePassword)) {
			return commonResultObject.buildErrorResult("密码错误！");
		}
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		logger.info("newPassword=" + newPassword + ",confirmPassword=" + confirmPassword);
		if (StringUtils.isBlank(newPassword) || StringUtils.isBlank(confirmPassword)) {
			return commonResultObject.buildErrorResult("请输入新密码！");
		}
		if (!StringUtils.equalsIgnoreCase(newPassword, confirmPassword)) {
			return commonResultObject.buildErrorResult("两次输入的密码不一致！");
		}
		if (newPassword.length() < 6) {
			return commonResultObject.buildErrorResult("密码长度太短！");
		}
		String encodeNewPassword = md5PasswordEncoder.encodePassword(newPassword, Constant.MD5_SALT);
		User newUser = new User();
		newUser.setId(user.getId());
		newUser.setLoginPassword(encodeNewPassword);
		newUser.setUpdateTime(System.currentTimeMillis());
		userService.update(newUser);
		commonResultObject.setMessage("修改成功！");
		return commonResultObject;
	}

	@RequestMapping(value = "/getUserInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public CommonResultObject getUserInfo(HttpServletRequest request, String pageSize, String pageCurrent) {
		Object attribute = request.getSession().getAttribute(SessionKey.USER.value());
		CommonResultObject commonResultObject = new CommonResultObject();
		if (attribute == null) {
			return commonResultObject.buildErrorResult("请先登录！");
		}
		int beginIndex = 0;
		int size = 10;
		if (NumberUtils.isNumber(pageSize) && NumberUtils.isNumber(pageCurrent)) {
			beginIndex = Integer.valueOf(pageCurrent) - 1;
			size = Integer.valueOf(pageSize);
		}
		User loginUser = (User) attribute;
		UserRole userRole = UserRole.getByValue(loginUser.getRole());
		String roleStr = request.getParameter("role");
		Integer role = null;
		if (NumberUtils.isNumber(roleStr)) {
			role = Integer.valueOf(roleStr);
		}
		String departmentStr = request.getParameter("department");
		Integer department = null;
		if (NumberUtils.isNumber(departmentStr)) {
			department = Integer.valueOf(departmentStr);
		}
		List<UserDto> userList = userService.findByConditionAndPage(role, department, beginIndex, size);
		commonResultObject.setList(userList);

		return commonResultObject;
	}

	@RequestMapping(value = "/getDepartments", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object getDepartments(HttpServletRequest request, String pageSize, String pageCurrent) {
		List<SelectDto> selectDtoList = new ArrayList<SelectDto>();
		for (Department department : Department.values()) {
			SelectDto selectDto = new SelectDto();
			selectDto.setValue(department.getValue() + "");
			selectDto.setLabel(department.getComment());
			selectDtoList.add(selectDto);
		}
		return selectDtoList;
	}
}
