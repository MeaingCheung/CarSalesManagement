package com.yyz.enumerate;

public enum UserPosition {
	MANAGER(0, "经理"),
	SLAER(1, "销售员"),
	ACCOUNTANT(2, "会计"),
	WAREHOUSE_KEEPER(3, "仓库员");
	private final Integer	value;
	private final String	comment;

	private UserPosition(Integer value, String comment) {
		this.value = value;
		this.comment = comment;
	}

	public static UserPosition getByValue(Integer value) {
		if (value == null) {
			return null;
		}

		for (UserPosition userPosition : UserPosition.values()) {
			if (userPosition.getValue().equals(value)) {
				return userPosition;
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
