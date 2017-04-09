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
import com.yyz.dto.CarDto;
import com.yyz.entity.Car;
import com.yyz.entity.Manufacturer;
import com.yyz.entity.User;
import com.yyz.enumerate.CarType;
import com.yyz.service.CarService;
import com.yyz.service.ManufacturerService;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version CarController.java, v 0.1 2017年4月9日 下午12:45:50
 */
@Controller
public class CarController extends BaseController {
	private final static Logger	logger	= LoggerFactory.getLogger(CarController.class);
	@Autowired
	private ManufacturerService	manufacturerService;
	@Autowired
	private CarService			carService;

	@RequestMapping(value = "/getCarInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public CommonResultObject getCarInfo(HttpServletRequest request, String pageSize, String pageCurrent) {
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
		String typeStr = request.getParameter("type");
		Integer type = null;
		if (StringUtils.isNotBlank(typeStr)) {
			if (NumberUtils.isDigits(typeStr)) {
				type = Integer.valueOf(typeStr);
			} else {
				logger.error("参数错误，type=" + type);
				return commonResultObject;
			}
		}

		List<CarDto> carDtoList = carService.findByConditionAndPage(createUserLoginId, type, beginIndex, size);
		commonResultObject.setPageCurrent(beginIndex);
		commonResultObject.setList(carDtoList);

		return commonResultObject;
	}

	@RequestMapping(value = "/addOrupdateCarUi", method = { RequestMethod.GET, RequestMethod.POST })
	public String addOrupdateCarUi(HttpServletRequest request, ModelMap modelMap) {
		String id = request.getParameter("id");
		if (NumberUtils.isNumber(id)) {
			Car car = carService.findByPrimaryKey(Long.valueOf(id));
			Manufacturer manufacturer = manufacturerService.findByPrimaryKey(car.getManufacturerId());
			if (manufacturer != null) {
				car.setManufacturerName(manufacturer.getName());
			}
			modelMap.addAttribute("car", car);
		}
		return "jsp/carEdit";
	}

	@RequestMapping(value = "/addOrUpdateCar", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public CommonResultObject addOrUpdateCar(HttpServletRequest request) {
		CommonResultObject commonResultObject = new CommonResultObject();
		User loginUser = getLoginUser(request);
		if (loginUser == null) {
			return commonResultObject.buildErrorResult("请先登录！");
		}
		String id = request.getParameter("id");
		String name = request.getParameter("inputName");
		String color = request.getParameter("color");
		String serialNumber = request.getParameter("serialNumber");
		String type = request.getParameter("type");
		String productAddress = request.getParameter("productAddress");
		String comment = request.getParameter("comment");
		String manufacturerId = request.getParameter("manufacturerId");
		if (StringUtils.isBlank(id)) {
			if (StringUtils.isBlank(serialNumber)) {
				logger.error("参数错误，serialNumber=" + serialNumber);
				return commonResultObject.buildErrorResult("请输入车辆编号");
			} else {
				Car car = carService.findByUniqueKey(serialNumber);
				if (car != null) {
					logger.error("车辆编号已存在,serialNumber=" + serialNumber);
					return commonResultObject.buildErrorResult("车辆编号已存在");
				}
			}
		}

		if (StringUtils.isBlank(name)) {
			return commonResultObject.buildErrorResult("请输入车辆名称");
		}
		if (NumberUtils.isDigits(type)) {
			CarType carType = CarType.getByValue(Integer.valueOf(type));
			if (carType == null) {
				logger.error("参数错误,type=" + type);
				return commonResultObject.buildErrorResult("请选择正确的车辆类型");
			}
		} else {
			return commonResultObject.buildErrorResult("请选择车辆类型");
		}
		if (NumberUtils.isDigits(manufacturerId)) {
			Manufacturer manufacturer = manufacturerService.findByPrimaryKey(Long.valueOf(manufacturerId));
			if (manufacturer == null) {
				logger.error("参数错误,manufacturerId=" + manufacturerId);
				return commonResultObject.buildErrorResult("厂商不存在");
			}
		} else {
			return commonResultObject.buildErrorResult("请选择厂商");
		}
		long now = System.currentTimeMillis();
		Car carForUpdate = new Car();
		carForUpdate.setColor(color);
		carForUpdate.setComment(comment);
		carForUpdate.setManufacturerId(Long.valueOf(manufacturerId));
		carForUpdate.setName(name);
		carForUpdate.setProductAddress(productAddress);
		carForUpdate.setType(Integer.valueOf(type));
		carForUpdate.setUpdateTime(now);
		try {
			if (NumberUtils.isNumber(id)) {// 编辑
				Car car = carService.findByPrimaryKey(Long.valueOf(id));
				if (car == null) {
					logger.info("根据car id=" + id + ",查询不到车辆。");
					return commonResultObject.buildErrorResult("编辑失败");
				}
				carForUpdate.setId(Long.valueOf(id));
				carService.update(carForUpdate);
			} else {// 新增
				carForUpdate.setCreateTime(now);
				carForUpdate.setCreateUserLoginId(loginUser.getLoginId());
				carForUpdate.setSerialNumber(serialNumber);
				carService.insert(carForUpdate);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return commonResultObject.buildErrorResult("操作失败");
		}

		return commonResultObject;
	}
}
