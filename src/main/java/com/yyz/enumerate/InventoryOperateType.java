package com.yyz.enumerate;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version InventoryOperateType.java, v 0.1 2017年4月11日 下午9:14:53
 */
public enum InventoryOperateType {

	IN(0, "入库"),
	OUT(1, "出库");
	private final Integer	value;
	private final String	comment;

	private InventoryOperateType(Integer value, String comment) {
		this.value = value;
		this.comment = comment;
	}

	public static InventoryOperateType getByValue(Integer value) {
		if (value == null) {
			return null;
		}

		for (InventoryOperateType inventoryOperateType : InventoryOperateType.values()) {
			if (inventoryOperateType.getValue().equals(value)) {
				return inventoryOperateType;
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
