package com.yyz.dto;

import java.io.Serializable;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version ManufacturerDto.java, v 0.1 2017年4月7日 下午10:13:26
 */
public class ManufacturerDto implements Serializable {

	/** */

	private static final long	serialVersionUID	= 1270442496489470778L;

	/**
	 * 自增主键
	 */
	private Long				id;

	/**
	 * 创建人登录id
	 */
	private String				createUserLoginId;

	/**
	 * 编号
	 */
	private String				serialNumber;

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

	public String getCreateUserLoginId() {
		return createUserLoginId;
	}

	public void setCreateUserLoginId(String createUserLoginId) {
		this.createUserLoginId = createUserLoginId;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
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
