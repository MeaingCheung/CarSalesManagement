package com.yyz.enumerate;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version Department.java, v 0.1 2017年3月12日 下午6:50:57
 */
public enum Department {
	ADMINISTRATION(0, "人事部"),
	PURCHASE(1, "采购部"),
	SALE(2, "销售部"),
	ACCOUNTING(3, "财务部"),
	AFTER_SALE_SERVICE(4, "售后服务部");
	private final Integer	value;
	private final String	comment;

	private Department(Integer value, String comment) {
		this.value = value;
		this.comment = comment;
	}

	public static Department getByValue(Integer value) {
		if (value == null) {
			return null;
		}

		for (Department department : Department.values()) {
			if (department.getValue().equals(value)) {
				return department;
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
