package com.yyz.entity;

import java.io.Serializable;

/**
 * 实体类 - 表：inventoryrecord
 * 
 * @since 2017-04-11 19:54:23
 */
public class InventoryRecord implements Serializable {
	/**
	 * 自增主键
	 */
	private Long				id;

	/**
	 * 类型(0-入库，1-出库)
	 */
	private Integer				type;

	/**
	 * 库存
	 */
	private Long				inventoryId;

	/**
	 * 汽车编号
	 */
	private String				carSerialNumber;

	/**
	 * 变更前数量
	 */
	private Long				originalAmount;

	/**
	 * 变更数量
	 */
	private Long				changeAmount;

	/**
	 * 操作人登录id
	 */
	private Long				operateUserLoginId;

	/**
	 * 出入库时间
	 */
	private Long				changeInventoryTime;

	/**
	 * 备注
	 */
	private String				comment;

	/**
	 * 创建时间
	 */
	private Long				createTime;

	/**
	 * 更新时间
	 */
	private Long				updateTime;

	/**
	 * 删除时间
	 */
	private Long				deleteTime;

	/**
	 * 备用字段0
	 */
	private Long				reserve0;

	/**
	 * 备用字段1
	 */
	private Long				reserve1;

	/**
	 * 备用字段2
	 */
	private String				reserve2;

	private static final long	serialVersionUID	= 1L;

	/**
	 * 获取自增主键
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置自增主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取类型(0-入库，1-出库)
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置类型(0-入库，1-出库)
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取库存
	 */
	public Long getInventoryId() {
		return inventoryId;
	}

	/**
	 * 设置库存
	 */
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	/**
	 * 获取汽车编号
	 */
	public String getCarSerialNumber() {
		return carSerialNumber;
	}

	/**
	 * 设置汽车编号
	 */
	public void setCarSerialNumber(String carSerialNumber) {
		this.carSerialNumber = carSerialNumber;
	}

	/**
	 * 获取变更前数量
	 */
	public Long getOriginalAmount() {
		return originalAmount;
	}

	/**
	 * 设置变更前数量
	 */
	public void setOriginalAmount(Long originalAmount) {
		this.originalAmount = originalAmount;
	}

	/**
	 * 获取变更数量
	 */
	public Long getChangeAmount() {
		return changeAmount;
	}

	/**
	 * 设置变更数量
	 */
	public void setChangeAmount(Long changeAmount) {
		this.changeAmount = changeAmount;
	}

	/**
	 * 获取操作人登录id
	 */
	public Long getOperateUserLoginId() {
		return operateUserLoginId;
	}

	/**
	 * 设置操作人登录id
	 */
	public void setOperateUserLoginId(Long operateUserLoginId) {
		this.operateUserLoginId = operateUserLoginId;
	}

	/**
	 * 获取出入库时间
	 */
	public Long getChangeInventoryTime() {
		return changeInventoryTime;
	}

	/**
	 * 设置出入库时间
	 */
	public void setChangeInventoryTime(Long changeInventoryTime) {
		this.changeInventoryTime = changeInventoryTime;
	}

	/**
	 * 获取创建时间
	 */
	public Long getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取更新时间
	 */
	public Long getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置更新时间
	 */
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取删除时间
	 */
	public Long getDeleteTime() {
		return deleteTime;
	}

	/**
	 * 设置删除时间
	 */
	public void setDeleteTime(Long deleteTime) {
		this.deleteTime = deleteTime;
	}

	/**
	 * 获取备用字段0
	 */
	public Long getReserve0() {
		return reserve0;
	}

	/**
	 * 设置备用字段0
	 */
	public void setReserve0(Long reserve0) {
		this.reserve0 = reserve0;
	}

	/**
	 * 获取备用字段1
	 */
	public Long getReserve1() {
		return reserve1;
	}

	/**
	 * 设置备用字段1
	 */
	public void setReserve1(Long reserve1) {
		this.reserve1 = reserve1;
	}

	/**
	 * 获取备用字段2
	 */
	public String getReserve2() {
		return reserve2;
	}

	/**
	 * 设置备用字段2
	 */
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2 == null ? null : reserve2.trim();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}