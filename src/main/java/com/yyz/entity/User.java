package com.yyz.entity;



import java.io.Serializable;

/**
 * 
 * @company yyz
 * @author MeaingCheung
 * @version User.java, v 0.1 2017年2月27日 下午9:56:28
 */
public class User implements Serializable {
	/**
	 * 自增主键
	 */
	private Long				id;

	/**
	 * 机构用户id. 如果用户本身是机构用户，orgUserId与id相同
	 */
	private Long				orgUserId;

	/**
	 * 登陆名称
	 */
	private String				loginName;

	/**
	 * 登陆邮箱
	 */
	private String				loginMail;

	/**
	 * 登陆电话:只允许手机
	 */
	private String				loginPhone;

	/**
	 * 登陆名称绑定时间
	 */
	private Integer				loginNameBindTime;

	/**
	 * 登陆邮箱绑定时间
	 */
	private Integer				loginMailBindTime;

	/**
	 * 登陆电话绑定时间
	 */
	private Integer				loginPhoneBindTime;

	/**
	 * 登陆密码
	 */
	private String				loginPassword;

	/**
	 * 可见的登录密码
	 */
	private String				loginPasswordVisible;

	/**
	 * 最后一次登陆方式:名称,邮箱,手机
	 */
	private Byte				loginLastType;

	/**
	 * 最后一次登陆时间
	 */
	private Integer				loginLastTime;

	/**
	 * 状态:默认0
	 */
	private Short				status;

	/**
	 * 实名信息编号
	 */
	private Long				identityId;
	/** 用户匹配的费率方案ID */
	private Long				rateSchemeId;

	/**
	 * 支付密码
	 */
	private String				payPassword;

	/**
	 * 创建时间
	 */
	private Integer				createTime;

	/**
	 * 更新时间
	 */
	private Integer				updateTime;

	/**
	 * 删除时间
	 */
	private Integer				deleteTime;

	/**
	 * 备用字段
	 */
	private Long				reserve0;

	/**
	 * 备用字段
	 */
	private Long				reserve1;

	/**
	 * 登录失败次数
	 */
	private Byte				loginFailedTimes;
	/**
	 * 备用字段
	 */
	private String				reserve2;

	/** 用户角色 */
	private Short				role;

	/** 父ID **/
	private Long				parentId;

	/** 备注 **/
	private String				userRemark;

	private static final long	serialVersionUID	= 1L;

	/** token明文 **/
	private String				openToken;

	/*** 密码密文 **/
	private String				openPassword;

	/** 机构登陆的编号 **/
	private Long				loginIdAsOrgUser;

	/*** 登录锁定失效时间 **/
	private Integer				loginLockExpireTime;

	/** 用户投资评估表ID */
	private Long				userInvestmentAssessmentInfoId;

	/***
	 * 管理员分组ID
	 */
	private Long				groupId;
	/***
	 * 是否支持隐藏
	 */
	private Integer				visibleInOrg;

	// public String getPlateName() {
	// return plateName;
	// }
	//
	// public void setPlateName(String plateName) {
	// this.plateName = plateName;
	// }
	//
	// public Short getPlateStatus() {
	// return plateStatus;
	// }
	//
	// public void setPlateStatus(Short plateStatus) {
	// this.plateStatus = plateStatus;
	// }

	public Integer getVisibleInOrg() {
		return visibleInOrg;
	}

	public void setVisibleInOrg(Integer visibleInOrg) {
		this.visibleInOrg = visibleInOrg;
	}

	/**
	 * 获取自增主键
	 */
	public Long getId() {
		return id;
	}

	public Long getOrgUserId() {
		return orgUserId;
	}

	public void setOrgUserId(Long orgUserId) {
		this.orgUserId = orgUserId;
	}

	/**
	 * 设置自增主键
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * 获取登陆名称绑定时间
	 */
	public Integer getLoginNameBindTime() {
		return loginNameBindTime;
	}

	/**
	 * 设置登陆名称绑定时间
	 */
	public void setLoginNameBindTime(Integer loginNameBindTime) {
		this.loginNameBindTime = loginNameBindTime;
	}

	/**
	 * 获取登陆邮箱绑定时间
	 */
	public Integer getLoginMailBindTime() {
		return loginMailBindTime;
	}

	/**
	 * 设置登陆邮箱绑定时间
	 */
	public void setLoginMailBindTime(Integer loginMailBindTime) {
		this.loginMailBindTime = loginMailBindTime;
	}

	/**
	 * 获取登陆电话绑定时间
	 */
	public Integer getLoginPhoneBindTime() {
		return loginPhoneBindTime;
	}

	/**
	 * 设置登陆电话绑定时间
	 */
	public void setLoginPhoneBindTime(Integer loginPhoneBindTime) {
		this.loginPhoneBindTime = loginPhoneBindTime;
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
	 * 获取最后一次登陆方式:名称,邮箱,手机
	 */
	public Byte getLoginLastType() {
		return loginLastType;
	}

	/**
	 * 设置最后一次登陆方式:名称,邮箱,手机
	 */
	public void setLoginLastType(Byte loginLastType) {
		this.loginLastType = loginLastType;
	}

	/**
	 * 获取最后一次登陆时间
	 */
	public Integer getLoginLastTime() {
		return loginLastTime;
	}

	/**
	 * 设置最后一次登陆时间
	 */
	public void setLoginLastTime(Integer loginLastTime) {
		this.loginLastTime = loginLastTime;
	}

	/**
	 * 获取状态:默认0
	 */
	public Short getStatus() {
		return status;
	}

	/**
	 * 设置状态:默认0
	 */
	public void setStatus(Short status) {
		this.status = status;
	}

	/**
	 * 获取实名信息编号
	 */
	public Long getIdentityId() {
		return identityId;
	}

	/**
	 * 设置实名信息编号
	 */
	public void setIdentityId(Long identityId) {
		this.identityId = identityId;
	}

	/**
	 * 获取支付密码
	 */
	public String getPayPassword() {
		return payPassword;
	}

	/**
	 * 设置支付密码
	 */
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword == null ? null : payPassword.trim();
	}

	/**
	 * 获取创建时间
	 */
	public Integer getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取更新时间
	 */
	public Integer getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置更新时间
	 */
	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取删除时间
	 */
	public Integer getDeleteTime() {
		return deleteTime;
	}

	/**
	 * 设置删除时间
	 */
	public void setDeleteTime(Integer deleteTime) {
		this.deleteTime = deleteTime;
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

	public Byte getLoginFailedTimes() {
		return loginFailedTimes;
	}

	public void setLoginFailedTimes(Byte loginFailedTimes) {
		this.loginFailedTimes = loginFailedTimes;
	}

	public Short getRole() {
		return role;
	}

	public void setRole(Short role) {
		this.role = role;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getLoginPasswordVisible() {
		return loginPasswordVisible;
	}

	public void setLoginPasswordVisible(String loginPasswordVisible) {
		this.loginPasswordVisible = loginPasswordVisible;
	}

	public String getUserRemark() {
		return userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	public String getOpenToken() {
		return openToken;
	}

	public void setOpenToken(String openToken) {
		this.openToken = openToken;
	}

	public String getOpenPassword() {
		return openPassword;
	}

	public void setOpenPassword(String openPassword) {
		this.openPassword = openPassword;
	}

	public Long getLoginIdAsOrgUser() {
		return loginIdAsOrgUser;
	}

	public void setLoginIdAsOrgUser(Long loginIdAsOrgUser) {
		this.loginIdAsOrgUser = loginIdAsOrgUser;
	}

	public Integer getLoginLockExpireTime() {
		return loginLockExpireTime;
	}

	public void setLoginLockExpireTime(Integer loginLockExpireTime) {
		this.loginLockExpireTime = loginLockExpireTime;
	}

	public Long getUserInvestmentAssessmentInfoId() {
		return userInvestmentAssessmentInfoId;
	}

	public void setUserInvestmentAssessmentInfoId(Long userInvestmentAssessmentInfoId) {
		this.userInvestmentAssessmentInfoId = userInvestmentAssessmentInfoId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getRateSchemeId() {
		return rateSchemeId;
	}

	public void setRateSchemeId(Long rateSchemeId) {
		this.rateSchemeId = rateSchemeId;
	}
}