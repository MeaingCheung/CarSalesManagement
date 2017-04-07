package com.yyz.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyz.commons.CommonResultObject;
import com.yyz.dto.CustomerDto;
import com.yyz.entity.Customer;
import com.yyz.entity.User;
import com.yyz.enumerate.Gender;
import com.yyz.service.CustomerService;
import com.yyz.service.UserService;
import com.yyz.util.VerificationUtil;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version CustomerController.java, v 0.1 2017年4月6日 下午10:09:11
 */
@Controller
public class CustomerController extends BaseController {
	private final static Logger	logger	= LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private UserService			userService;
	@Autowired
	private CustomerService		customerService;

	@RequestMapping(value = "/getCustomerInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public CommonResultObject getCustomerInfo(HttpServletRequest request, String pageSize, String pageCurrent) {
		CommonResultObject commonResultObject = new CommonResultObject();
		User loginUser = getLoginUser(request);
		if (loginUser == null) {
			return commonResultObject.buildErrorResult("请先登录！");
		}
		int beginIndex = 0;
		int size = 10;
		if (NumberUtils.isNumber(pageSize) && NumberUtils.isNumber(pageCurrent)) {
			beginIndex = Integer.valueOf(pageCurrent) - 1;
			size = Integer.valueOf(pageSize);
		}
		String createUserLoginIdStr = request.getParameter("createUserLoginId");
		Long createUserLoginId = null;
		if (StringUtils.isNotBlank(createUserLoginIdStr)) {
			if (NumberUtils.isDigits(createUserLoginIdStr)) {
				createUserLoginId = Long.valueOf(createUserLoginIdStr);
			} else {
				logger.error("参数错误，createUserLoginId=" + createUserLoginIdStr);
				return commonResultObject;
			}
		}
		String genderStr = request.getParameter("gender");
		Integer gender = null;
		if (StringUtils.isNotBlank(genderStr)) {
			if (NumberUtils.isDigits(genderStr)) {
				gender = Integer.valueOf(genderStr);
			} else {
				logger.error("参数错误，gender=" + genderStr);
				return commonResultObject;
			}
		}
		List<CustomerDto> customerDtoList = customerService.findByConditionAndPage(createUserLoginId, gender,
				beginIndex, size);
		commonResultObject.setPageCurrent(beginIndex);
		commonResultObject.setList(customerDtoList);

		return commonResultObject;
	}

	@RequestMapping(value = "/addOrupdateCustomerUi", method = { RequestMethod.GET, RequestMethod.POST })
	public String addOrupdateCustomerUi(HttpServletRequest request, ModelMap modelMap) {
		String id = request.getParameter("id");
		if (NumberUtils.isNumber(id)) {
			Customer customer = customerService.findByPrimaryKey(Long.valueOf(id));
			modelMap.addAttribute("customer", customer);
		}
		return "jsp/customerEdit";
	}

	@RequestMapping(value = "/addOrUpdateCustomer", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public CommonResultObject addOrUpdateUser(HttpServletRequest request) {
		CommonResultObject commonResultObject = new CommonResultObject();
		User loginUser = getLoginUser(request);
		if (loginUser == null) {
			return commonResultObject.buildErrorResult("请先登录！");
		}
		String id = request.getParameter("id");
		String name = request.getParameter("inputName");
		String phoneNumber = request.getParameter("phoneNumber");
		String identifierNumber = request.getParameter("identifierNumber");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String job = request.getParameter("job");
		String ageStr = request.getParameter("age");
		String genderStr = request.getParameter("gender");
		if (StringUtils.isBlank(id)) {
			if (!NumberUtils.isDigits(identifierNumber)) {
				logger.error("参数错误，identifierNumber=" + identifierNumber);
				return commonResultObject.buildErrorResult("请输入客户编号");
			} else {
				Customer customer = customerService.findByUniqueKey(Long.valueOf(identifierNumber));
				if (customer != null) {
					logger.error("客户编号已存在,identifierNumber=" + identifierNumber);
					return commonResultObject.buildErrorResult("客户编号已存在");
				}
			}
		}

		if (StringUtils.isBlank(name)) {
			return commonResultObject.buildErrorResult("请输入客户姓名");
		}
		if (StringUtils.isNotBlank(phoneNumber)) {
			if (!VerificationUtil.checkLoginPhone(phoneNumber)) {
				logger.info("手机号格式不对，loginPhone=" + phoneNumber);
				return commonResultObject.buildErrorResult("请输入正确的手机号");
			}
		} else {
			return commonResultObject.buildErrorResult("请输入正确的手机号");
		}
		if (StringUtils.isNotBlank(email)) {
			if (!VerificationUtil.checkLoginMail(email)) {
				logger.info("邮箱格式不对，loginMail=" + email);
				return commonResultObject.buildErrorResult("请输入正确的邮箱");
			}
		}

		if (StringUtils.isNotBlank(ageStr)) {
			if (!VerificationUtil.checkAge(ageStr)) {
				logger.info("编辑失败，年龄参数错误，age=" + ageStr);
				return commonResultObject.buildErrorResult("年龄非法！");
			}
		}
		if (StringUtils.isNotBlank(ageStr)) {
			Gender gender = Gender.getByValue(Integer.valueOf(genderStr));
			if (gender == null) {
				logger.info("编辑失败，性别参数错误，gender=" + genderStr);
				return commonResultObject.buildErrorResult("性别非法！");
			}
		}
		long now = System.currentTimeMillis();
		Customer customerForUpdate = new Customer();
		customerForUpdate.setAddress(address);
		customerForUpdate.setAge(Integer.valueOf(ageStr));
		customerForUpdate.setEmail(email);
		customerForUpdate.setGender(Integer.valueOf(genderStr));
		customerForUpdate.setJob(job);
		customerForUpdate.setName(name);
		customerForUpdate.setPhoneNumber(phoneNumber);
		customerForUpdate.setUpdateTime(now);
		try {
			if (NumberUtils.isNumber(id)) {// 编辑
				Customer customer = customerService.findByPrimaryKey(Long.valueOf(id));
				if (customer == null) {
					logger.info("根据user id=" + id + ",查询不到客户户。");
					return commonResultObject.buildErrorResult("编辑失败");
				}
				customerForUpdate.setId(Long.valueOf(id));
				customerService.update(customerForUpdate);
			} else {// 新增
				customerForUpdate.setCreateTime(now);
				customerForUpdate.setCreateUserLoginId(loginUser.getLoginId());
				customerForUpdate.setIdentifierNumber(Long.valueOf(identifierNumber));
				customerService.insert(customerForUpdate);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return commonResultObject.buildErrorResult("操作失败");
		}

		return commonResultObject;
	}
}
