package com.yyz.dto;

import java.io.Serializable;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version InventoryDto.java, v 0.1 2017年4月11日 下午11:28:19
 */
public class InventoryDto implements Serializable {

	/** */

	private static final long	serialVersionUID	= -536701985613777692L;

	/**
	 * 自增主键
	 */
	Long						id;
	/**
	 * 厂商名称
	 */
	private String				manufacturerName;

	/**
	 * 车辆名称
	 */
	private String				carName;

	/**
	 * 车辆编号
	 */
	private String				carSerialNumber;

	/**
	 * 库存数量
	 */
	private String				amount;

	/**
	 * 进价
	 */
	private String				costPrice;

	/**
	 * 备注
	 */
	private String				comment;

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

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarSerialNumber() {
		return carSerialNumber;
	}

	public void setCarSerialNumber(String carSerialNumber) {
		this.carSerialNumber = carSerialNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

}
