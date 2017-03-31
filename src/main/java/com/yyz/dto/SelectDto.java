package com.yyz.dto;

import java.io.Serializable;

/**
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version SelectDto.java, v 0.1 2017年3月12日 下午9:24:26
 */
public class SelectDto implements Serializable {

	/** */

	private static final long	serialVersionUID	= -276652960143694669L;

	private String				value;
	private String				label;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
