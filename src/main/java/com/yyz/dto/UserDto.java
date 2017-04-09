package com.yyz.dto;

import java.io.Serializable;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version UserDto.java, v 0.1 2017年3月12日 下午5:22:03
 */
public class UserDto implements Serializable {

	/** */

	private static final long	serialVersionUID	= -3641214877332479607L;

	/**
	 * 自增主键
	 */
	private Long				id;

	/**
	 * 分组ID
	 */
	private String				department;
	private String				gender;
	private Integer				age;

	/** 
	 * 
	 */
	private Long				loginId;

	/**
	 * 登陆电话:只允许手机
	 */
	private String				loginPhone;

	public Long getId() {
		return id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public String getLoginPhone() {
		return loginPhone;
	}

	public void setLoginPhone(String loginPhone) {
		this.loginPhone = loginPhone;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginMail() {
		return loginMail;
	}

	public void setLoginMail(String loginMail) {
		this.loginMail = loginMail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getUserRemark() {
		return userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * 登陆名称
	 */
	private String	loginName;

	/**
	 * 登陆邮箱
	 */
	private String	loginMail;

	/**
	 * 登陆密码
	 */
	private String	loginPassword;

	/**
	 * 用户职位
	 */
	private String	position;

	/**
	 * 状态:默认0
	 */
	private Integer	status;

	/**
	 * 创建时间
	 */
	private String	createTime;

	/**
	 * 更新时间
	 */
	private String	updateTime;

	/**
	 * 用户说明
	 */
	private String	userRemark;

}
