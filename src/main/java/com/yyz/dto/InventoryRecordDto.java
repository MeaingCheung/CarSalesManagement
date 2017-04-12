package com.yyz.dto;

import java.io.Serializable;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version InventoryRecordDto.java, v 0.1 2017年4月12日 下午8:57:41
 */
public class InventoryRecordDto implements Serializable {

	/** */

	private static final long	serialVersionUID	= 5586947493196618087L;

	/**
	 * 自增主键
	 */
	private Long				id;

	/**
	 * 类型(0-入库，1-出库)
	 */
	private String				type;

	/**
	 * 库存编号
	 */
	private Long				inventoryId;

	/**
	 * 汽车编号
	 */
	private String				carSerialNumber;

	/**
	 * 汽车名称
	 */
	private String				carName;

	/**
	 * 变更前数量
	 */
	private String				originalAmount;

	/**
	 * 变更数量
	 */
	private String				changeAmount;

	/**
	 * 进价
	 */
	private String				costPrice;

	/**
	 * 操作人登录id
	 */
	private Long				operateUserLoginId;

	/**
	 * 出入库时间
	 */
	private String				changeInventoryTime;

	/**
	 * 备注
	 */
	private String				comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getCarSerialNumber() {
		return carSerialNumber;
	}

	public void setCarSerialNumber(String carSerialNumber) {
		this.carSerialNumber = carSerialNumber;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(String originalAmount) {
		this.originalAmount = originalAmount;
	}

	public String getChangeAmount() {
		return changeAmount;
	}

	public void setChangeAmount(String changeAmount) {
		this.changeAmount = changeAmount;
	}

	public Long getOperateUserLoginId() {
		return operateUserLoginId;
	}

	public void setOperateUserLoginId(Long operateUserLoginId) {
		this.operateUserLoginId = operateUserLoginId;
	}

	public String getChangeInventoryTime() {
		return changeInventoryTime;
	}

	public void setChangeInventoryTime(String changeInventoryTime) {
		this.changeInventoryTime = changeInventoryTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}

}
