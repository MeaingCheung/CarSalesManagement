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
import com.yyz.dto.ManufacturerDto;
import com.yyz.entity.Manufacturer;
import com.yyz.entity.User;
import com.yyz.service.ManufacturerService;
import com.yyz.util.VerificationUtil;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version ManufacturerController.java, v 0.1 2017年4月7日 下午10:09:28
 */
@Controller
public class ManufacturerController extends BaseController {
	private final static Logger	logger	= LoggerFactory.getLogger(ManufacturerController.class);
	@Autowired
	private ManufacturerService	manufacturerService;

	@RequestMapping(value = "/getManufacturerInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public CommonResultObject getManufacturerInfo(HttpServletRequest request, String pageSize, String pageCurrent) {
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

		List<ManufacturerDto> manufacturerDtoList = manufacturerService.findByConditionAndPage(createUserLoginId,
				beginIndex, size);
		commonResultObject.setPageCurrent(beginIndex);
		commonResultObject.setList(manufacturerDtoList);

		return commonResultObject;
	}

	@RequestMapping(value = "/addOrupdateManufacturerUi", method = { RequestMethod.GET, RequestMethod.POST })
	public String addOrupdateManufacturerUi(HttpServletRequest request, ModelMap modelMap) {
		String id = request.getParameter("id");
		if (NumberUtils.isNumber(id)) {
			Manufacturer manufacturer = manufacturerService.findByPrimaryKey(Long.valueOf(id));
			modelMap.addAttribute("manufacturer", manufacturer);
		}
		return "jsp/manufacturerEdit";
	}

	@RequestMapping(value = "/addOrUpdateManufacturer", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public CommonResultObject addOrUpdateManufacturer(HttpServletRequest request) {
		CommonResultObject commonResultObject = new CommonResultObject();
		User loginUser = getLoginUser(request);
		if (loginUser == null) {
			return commonResultObject.buildErrorResult("请先登录！");
		}
		String id = request.getParameter("id");
		String name = request.getParameter("inputName");
		String contactNumber = request.getParameter("contactNumber");
		String serialNumber = request.getParameter("serialNumber");
		String contactEmail = request.getParameter("contactEmail");
		String address = request.getParameter("address");
		String webSite = request.getParameter("webSite");
		if (StringUtils.isBlank(id)) {
			if (!NumberUtils.isDigits(serialNumber)) {
				logger.error("参数错误，serialNumber=" + serialNumber);
				return commonResultObject.buildErrorResult("请输入厂商编号");
			} else {
				Manufacturer manufacturer = manufacturerService.findByUniqueKey(Long.valueOf(serialNumber));
				if (manufacturer != null) {
					logger.error("厂商编号已存在,serialNumber=" + serialNumber);
					return commonResultObject.buildErrorResult("厂商编号已存在");
				}
			}
		}

		if (StringUtils.isBlank(name)) {
			return commonResultObject.buildErrorResult("请输入厂商名称");
		}

		if (StringUtils.isNotBlank(contactEmail)) {
			if (!VerificationUtil.checkLoginMail(contactEmail)) {
				logger.info("邮箱格式不对，contactEmail=" + contactEmail);
				return commonResultObject.buildErrorResult("请contactEmail正确的邮箱");
			}
		}

		long now = System.currentTimeMillis();
		Manufacturer manufacturerForUpdate = new Manufacturer();
		manufacturerForUpdate.setAddress(address);
		manufacturerForUpdate.setContactEmail(contactEmail);
		manufacturerForUpdate.setContactNumber(contactNumber);
		manufacturerForUpdate.setName(name);
		manufacturerForUpdate.setWebSite(webSite);
		manufacturerForUpdate.setUpdateTime(now);
		try {
			if (NumberUtils.isNumber(id)) {// 编辑
				Manufacturer manufacturer = manufacturerService.findByPrimaryKey(Long.valueOf(id));
				if (manufacturer == null) {
					logger.info("根据manufacturer id=" + id + ",查询不到厂商。");
					return commonResultObject.buildErrorResult("编辑失败");
				}
				manufacturerForUpdate.setId(Long.valueOf(id));
				manufacturerService.update(manufacturerForUpdate);
			} else {// 新增
				manufacturerForUpdate.setCreateTime(now);
				manufacturerForUpdate.setCreateUserLoginId(loginUser.getLoginId());
				manufacturerForUpdate.setSerialNumber(Long.valueOf(serialNumber));
				manufacturerService.insert(manufacturerForUpdate);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return commonResultObject.buildErrorResult("操作失败");
		}

		return commonResultObject;
	}
}
