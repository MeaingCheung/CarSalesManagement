package com.yyz.enumerate;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version SessionKey.java, v 0.1 2017年3月11日 下午1:53:38
 */
public enum SessionKey {
	USER("USER"),
	VALIDATE("RANDOMVALIDATECODEKEY");
	private String	key;

	private SessionKey(String key) {
		this.key = key;
	}

	public String value() {
		return key;
	}
}
