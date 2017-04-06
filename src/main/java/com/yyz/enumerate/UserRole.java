package com.yyz.enumerate;

public enum UserRole {
	MANAGER(0, "经理"),
	SLAER(1, "销售员"),
	accountant(2,"会计"),
	WAREHOUSE_KEEPER(3,"仓库员");
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
