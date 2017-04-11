package com.yyz.entity;

import java.io.Serializable;

/**
 * 实体类 - 表：inventory
 * 
 * @since 2017-04-11 19:53:41
 */
public class Inventory implements Serializable {
	/**
	 * 自增主键
	 */
	private Long				id;

	/**
	 * 汽车编号
	 */
	private String				carSerialNumber;

	/**
	 * 数量
	 */
	private Long				amount;

	/**
	 * 进价
	 */
	private Long				costPrice;

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
	 * 获取汽车编号
	 */
	public String getCarSerialNumber() {
		return carSerialNumber;
	}

	/**
	 * 设置汽车编号
	 */
	public void setCarSerialNumber(String carSerialNumber) {
		this.carSerialNumber = carSerialNumber == null ? null : carSerialNumber.trim();
	}

	/**
	 * 获取数量
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * 设置数量
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	/**
	 * 获取进价
	 */
	public Long getCostPrice() {
		return costPrice;
	}

	/**
	 * 设置进价
	 */
	public void setCostPrice(Long costPrice) {
		this.costPrice = costPrice;
	}

	/**
	 * 获取备注
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * 设置备注
	 */
	public void setComment(String comment) {
		this.comment = comment == null ? null : comment.trim();
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
}