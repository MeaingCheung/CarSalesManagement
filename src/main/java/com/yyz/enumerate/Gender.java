package com.yyz.enumerate;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version Gender.java, v 0.1 2017年3月12日 下午6:56:55
 */
public enum Gender {

	MALE(0, "男"),
	FEMALE(1, "女");
	private final Integer	value;
	private final String	comment;

	private Gender(Integer value, String comment) {
		this.value = value;
		this.comment = comment;
	}

	public static Gender getByValue(Integer value) {
		if (value == null) {
			return null;
		}

		for (Gender gender : Gender.values()) {
			if (gender.getValue().equals(value)) {
				return gender;
			}
		}
		return null;
	}

	public Integer getValue() {
		return value;
	}

	public String getComment() {
		return comment;
	}

}
