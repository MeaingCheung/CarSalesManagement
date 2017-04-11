package com.yyz.util;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version VerificationUtil.java, v 0.1 2017年3月15日 下午7:59:14
 */
public class VerificationUtil {

	/** 国内手机格式的正则表达式 */
	public final static String	REGEX_MOBILE			= "^[1](3|4|5|7|8)[0-9]{9}$";

	/** 国外手机格式的正则表达式 */
	public final static String	REGEX_FOREIGN_MOBILE	= "^(00)?\\d{1,3}\\-\\d{6,13}$";

	/** Email格式的正则表达式 */
	public final static String	REGEX_EMAIL				= "^([a-zA-Z0-9_\\.\\-\\+])+\\@(([a-zA-Z0-9\\-])+\\.)+[a-zA-Z0-9]{2,20}$";

	public final static String	PATTERN_CHINA_MOBILE	= "^1(3[4-9]|5[01789]|8[78])\\d{8}$";

	public final static String	PATTERN_CHINA_UNICOM	= "^1(3[0-2]|5[256]|8[56])\\d{8}$";

	public final static String	PATTERN_CHINA_TELECOM	= "^(18[09]|1[35]3)\\d{8}$";
	public final static String	PATTERN_AGE				= "[1]?[0-9]{1,2}";

	/*
	 * 检查手机号是否合法
	 */
	public static boolean checkLoginPhone(String loginPhone) {
		boolean checkResult = true;
		if (loginPhone == null || !loginPhone.matches(REGEX_MOBILE)) {
			checkResult = false;
		}
		return checkResult;
	}

	public static boolean checkLoginMail(String loginMail) {
		boolean checkResult = true;
		if (loginMail == null || !loginMail.matches(REGEX_EMAIL)) {
			checkResult = false;
		}
		return checkResult;
	}

	public static boolean checkAge(String age) {
		boolean checkResult = true;
		if (age == null || !age.matches(PATTERN_AGE)) {
			checkResult = false;
		}
		if (Integer.valueOf(age) == 0) {
			checkResult = false;
		}
		return checkResult;
	}
}
