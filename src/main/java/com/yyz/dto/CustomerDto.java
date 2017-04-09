package com.yyz.dto;

import java.io.Serializable;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version CustomerDto.java, v 0.1 2017年4月6日 下午10:34:31
 */
public class CustomerDto implements Serializable {

	/** */

	private static final long	serialVersionUID	= 5983124551106935890L;
	/**
	 * 自增主键
	 */
	private Long				id;

	/**
	 * 客户编号
	 */
	private String				identifierNumber;

	/** 
	 * 
	 */
	private String				name;

	/**
	 * 性别
	 */
	private String				gender;

	/**
	 * 年龄
	 */
	private Integer				age;

	/**
	 * 创建人登录id
	 */
	private String				createUserLoginId;
	/**
	 * 职业
	 */
	private String				job;

	/**
	 * 电话号码
	 */
	private String				phoneNumber;

	/**
	 * 地址
	 */
	private String				address;

	/**
	 * 邮箱
	 */
	private String				email;

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

	public String getIdentifierNumber() {
		return identifierNumber;
	}

	public void setIdentifierNumber(String identifierNumber) {
		this.identifierNumber = identifierNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCreateUserLoginId() {
		return createUserLoginId;
	}

	public void setCreateUserLoginId(String createUserLoginId) {
		this.createUserLoginId = createUserLoginId;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
