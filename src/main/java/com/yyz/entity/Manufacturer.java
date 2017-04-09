package com.yyz.entity;

import java.io.Serializable;

/**
 * 实体类 - 表：manufacturer
 * 
 * @since 2017-04-07 22:01:28
 */
public class Manufacturer implements Serializable {
	/**
	 * 自增主键
	 */
	private Long				id;

	/**
	 * 创建人登录id
	 */
	private Long				createUserLoginId;

	/**
	 * 编号
	 */
	private Long				serialNumber;

	/**
	 * 名称
	 */
	private String				name;

	/**
	 * 地址
	 */
	private String				address;

	/**
	 * 联系电话
	 */
	private String				contactNumber;

	/**
	 * 联系邮箱
	 */
	private String				contactEmail;

	/**
	 * 官网地址
	 */
	private String				webSite;

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
	private Long				reserve2;

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
	 * 获取编号
	 */
	public Long getSerialNumber() {
		return serialNumber;
	}

	/**
	 * 设置编号
	 */
	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
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
	 * 获取地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置地址
	 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/**
	 * 获取联系电话
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * 设置联系电话
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber == null ? null : contactNumber.trim();
	}

	/**
	 * 获取联系邮箱
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * 设置联系邮箱
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail == null ? null : contactEmail.trim();
	}

	/**
	 * 获取官网地址
	 */
	public String getWebSite() {
		return webSite;
	}

	/**
	 * 设置官网地址
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite == null ? null : webSite.trim();
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
	public Long getReserve2() {
		return reserve2;
	}

	/**
	 * 设置备用字段2
	 */
	public void setReserve2(Long reserve2) {
		this.reserve2 = reserve2;
	}
}