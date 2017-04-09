package com.yyz.entity;

import java.io.Serializable;

/**
 * 实体类 - 表：user
 * 
 * @since 2017-03-11 11:36:40
 */
public class User implements Serializable {
	/**
	 * 自增主键
	 */
	private Long				id;

	/**
	 * 部门
	 */
	private Integer				department;

	/** 
	 * 
	 */
	private Long				loginId;

	/**
	 * 登陆电话:只允许手机
	 */
	private String				loginPhone;

	/**
	 * 登陆名称
	 */
	private String				loginName;

	/**
	 * 登陆邮箱
	 */
	private String				loginMail;

	/**
	 * 登陆密码
	 */
	private String				loginPassword;

	/**
	 * 用户职位
	 */
	private Integer				position;

	/**
	 * 状态:默认0
	 */
	private Integer				status;
	/**
	 * 性别
	 */
	private Integer				gender;
	/**
	 * 年龄
	 */
	private Integer				age;

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
	 * 用户说明
	 */
	private String				userRemark;

	/**
	 * 备用字段
	 */
	private Long				reserve0;

	/**
	 * 备用字段
	 */
	private Long				reserve1;

	/**
	 * 备用字段
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
	 * 获取分组ID
	 */
	public Integer getDepartment() {
		return department;
	}

	/**
	 * 设置分组ID
	 */
	public void setDepartment(Integer department) {
		this.department = department;
	}

	/**
	 * 获取
	 */
	public Long getLoginId() {
		return loginId;
	}

	/**
	 * 设置
	 */
	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	/**
	 * 获取登陆电话:只允许手机
	 */
	public String getLoginPhone() {
		return loginPhone;
	}

	/**
	 * 设置登陆电话:只允许手机
	 */
	public void setLoginPhone(String loginPhone) {
		this.loginPhone = loginPhone == null ? null : loginPhone.trim();
	}

	/**
	 * 获取登陆名称
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 设置登陆名称
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName == null ? null : loginName.trim();
	}

	/**
	 * 获取登陆邮箱
	 */
	public String getLoginMail() {
		return loginMail;
	}

	/**
	 * 设置登陆邮箱
	 */
	public void setLoginMail(String loginMail) {
		this.loginMail = loginMail == null ? null : loginMail.trim();
	}

	/**
	 * 获取登陆密码
	 */
	public String getLoginPassword() {
		return loginPassword;
	}

	/**
	 * 设置登陆密码
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword == null ? null : loginPassword.trim();
	}

	/**
	 * 获取状态:默认0
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置状态:默认0
	 */
	public void setStatus(Integer status) {
		this.status = status;
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
	 * 获取用户说明
	 */
	public String getUserRemark() {
		return userRemark;
	}

	/**
	 * 设置用户说明
	 */
	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark == null ? null : userRemark.trim();
	}

	/**
	 * 获取备用字段
	 */
	public Long getReserve0() {
		return reserve0;
	}

	/**
	 * 设置备用字段
	 */
	public void setReserve0(Long reserve0) {
		this.reserve0 = reserve0;
	}

	/**
	 * 获取备用字段
	 */
	public Long getReserve1() {
		return reserve1;
	}

	/**
	 * 设置备用字段
	 */
	public void setReserve1(Long reserve1) {
		this.reserve1 = reserve1;
	}

	/**
	 * 获取备用字段
	 */
	public String getReserve2() {
		return reserve2;
	}

	/**
	 * 设置备用字段
	 */
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2 == null ? null : reserve2.trim();
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

}