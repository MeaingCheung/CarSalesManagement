/**
 *  Copyright (c) 2015, 杭州转乾网络. All rights reserved.
 */
package com.yyz.util;

import java.util.Random;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version VerificationCodeUtil.java, v 0.1 2017年3月11日 上午9:32:40
 */
public final class VerificationCodeUtil {

	/** 手机验证码种子 */
	private static final String	AUTH_CODE	= "0123456789";

	/**
	 * JVM 构造方法
	 */
	private VerificationCodeUtil() {
	}

	/*
	 * 获取随机的字符 "0123456789"
	 */
	public static String getRandomString() {
		int num = new Random().nextInt(AUTH_CODE.length());
		return String.valueOf(AUTH_CODE.charAt(num));
	}

	/**
	 * 获取手机验证码
	 * 
	 * @return
	 */
	public static String getCheckCode() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			int index = new Random().nextInt(AUTH_CODE.length());
			sb.append(AUTH_CODE.charAt(index));
		}
		return sb.toString();
	}

	/**
	 * 获取Rrid
	 * 
	 * @return
	 */
	public static String getRrid() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 18; i++) {
			int index = new Random().nextInt(AUTH_CODE.length());
			sb.append(AUTH_CODE.charAt(index));
		}
		return sb.toString();
	}

}
