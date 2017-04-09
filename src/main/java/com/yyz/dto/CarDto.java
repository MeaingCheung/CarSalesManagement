package com.yyz.dto;

import java.io.Serializable;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version CarDto.java, v 0.1 2017年4月9日 下午12:48:42
 */
public class CarDto implements Serializable {

	/** */

	private static final long	serialVersionUID	= -2069249309915027200L;

	/**
	 * 自增主键
	 */
	private Long				id;

	/**
	 * 创建人登录id
	 */
	private Long				createUserLoginId;

	/**
	 * 厂商名称
	 */
	private String				manufacturerName;

	/**
	 * 厂商id
	 */
	private String				manufacturerId;

	/**
	 * 名称
	 */
	private String				name;

	/**
	 * 颜色
	 */
	private String				color;

	/**
	 * 产地
	 */
	private String				productAddress;

	/**
	 * 类型(suv,普通轿车，跑车等)
	 */
	private String				type;

	/**
	 * 备注
	 */
	private String				comment;

	/**
	 * 编号
	 */
	private String				serialNumber;

	/**
	 * 创建时间
	 */
	private String				createTime;

	/**
	 * 更新时间
	 */
	private String				updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreateUserLoginId() {
		return createUserLoginId;
	}

	public void setCreateUserLoginId(Long createUserLoginId) {
		this.createUserLoginId = createUserLoginId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getProductAddress() {
		return productAddress;
	}

	public void setProductAddress(String productAddress) {
		this.productAddress = productAddress;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

}
