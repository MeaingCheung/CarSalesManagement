package com.yyz.enumerate;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version CarType.java, v 0.1 2017年4月9日 下午12:51:51
 */
public enum CarType {

	CAR(0, "普通轿车"),
	SUV(1, "运动型多用途汽车"),
	SPORTS_CAR(2, "跑车");
	private final Integer	value;
	private final String	comment;

	private CarType(Integer value, String comment) {
		this.value = value;
		this.comment = comment;
	}

	public static CarType getByValue(Integer value) {
		if (value == null) {
			return null;
		}

		for (CarType carType : CarType.values()) {
			if (carType.getValue().equals(value)) {
				return carType;
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
