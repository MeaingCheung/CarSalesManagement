package com.yyz.entity;

import java.io.Serializable;

/**
 * 实体类 - 表：car
 * 
 * @since 2017-04-09 12:36:31
 */
public class Car implements Serializable {
	/**
	 * 自增主键
	 */
	private Long				id;

	/**
	 * 创建人登录id
	 */
	private Long				createUserLoginId;

	/**
	 * 厂商id
	 */
	private Long				manufacturerId;

	/**
	 * 厂商名称
	 */
	private String				manufacturerName;

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
	private Integer				type;

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
	 * 获取创建人登录id
	 */
	public Long getCreateUserLoginId() {
		return createUserLoginId;
	}

	/**
	 * 设置创建人登录id
	 */
	public void setCreateUserLoginId(Long createUserLoginId) {
		this.createUserLoginId = createUserLoginId;
	}

	/**
	 * 获取厂商id
	 */
	public Long getManufacturerId() {
		return manufacturerId;
	}

	/**
	 * 设置厂商id
	 */
	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	/**
	 * 获取名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置名称
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 获取颜色
	 */
	public String getColor() {
		return color;
	}

	/**
	 * 设置颜色
	 */
	public void setColor(String color) {
		this.color = color == null ? null : color.trim();
	}

	/**
	 * 获取产地
	 */
	public String getProductAddress() {
		return productAddress;
	}

	/**
	 * 设置产地
	 */
	public void setProductAddress(String productAddress) {
		this.productAddress = productAddress == null ? null : productAddress.trim();
	}

	/**
	 * 获取类型(suv,普通轿车，跑车等)
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置类型(suv,普通轿车，跑车等)
	 */
	public void setType(Integer type) {
		this.type = type;
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
	 * 获取编号
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * 设置编号
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber == null ? null : serialNumber.trim();
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

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	
}