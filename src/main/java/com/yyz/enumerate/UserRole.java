package com.yyz.enumerate;

public enum UserRole {
	ADMIN(0, "管理员"),
	NORMAL_USER(1, "普通用户");
	private final Integer	value;
	private final String	comment;

	private UserRole(Integer value, String comment) {
		this.value = value;
		this.comment = comment;
	}

	public static UserRole getByValue(Integer value) {
		if (value == null) {
			return null;
		}

		for (UserRole userRole : UserRole.values()) {
			if (userRole.getValue().equals(value)) {
				return userRole;
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
