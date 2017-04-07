/**
 * Copyright (c) 2015, 杭州转乾网络. All rights reserved.
 */
package com.yyz.entity;

import java.io.Serializable;

/**
 * 实体类 - 表：customer
 * 
 * @since 2017-04-06 21:46:28
 */
public class Customer implements Serializable {
	/**
	 * 自增主键
	 */
	private Long				id;

	/**
	 * 客户编号
	 */
	private Long				identifierNumber;

	/** 
	 * 
	 */
	private String				name;

	/**
	 * 性别
	 */
	private Integer				gender;

	/**
	 * 年龄
	 */
	private Integer				age;

	/**
	 * 创建人登录id
	 */
	private Long				createUserLoginId;
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
	 * 获取客户编号
	 */
	public Long getIdentifierNumber() {
		return identifierNumber;
	}

	/**
	 * 设置客户编号
	 */
	public void setIdentifierNumber(Long identifierNumber) {
		this.identifierNumber = identifierNumber;
	}

	/**
	 * 获取
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 获取性别
	 */
	public Integer getGender() {
		return gender;
	}

	/**
	 * 设置性别
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	/**
	 * 获取年龄
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * 设置年龄
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getCreateUserLoginId() {
		return createUserLoginId;
	}

	public void setCreateUserLoginId(Long createUserLoginId) {
		this.createUserLoginId = createUserLoginId;
	}

	/**
	 * 获取职业
	 */
	public String getJob() {
		return job;
	}

	/**
	 * 设置职业
	 */
	public void setJob(String job) {
		this.job = job == null ? null : job.trim();
	}

	/**
	 * 获取电话号码
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 设置电话号码
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
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
	 * 获取邮箱
	 */
	public String getEmail() {
		return email;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public Long getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Long deleteTime) {
		this.deleteTime = deleteTime;
	}

	/**
	 * 设置邮箱
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
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