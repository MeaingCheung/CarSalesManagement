package com.yyz.commons;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统一的结果集对象
 * 
 * @company 河南财经政法大学
 * @author yyz
 * @version CommonResultObject.java, v 0.1 2017年3月12日 下午3:24:04
 */
public class CommonResultObject {

	/**
	 * 结果标志，1：成功，0：失败
	 */
	private Object				statusCode	= 200;

	/**
	 * 提示信息
	 */
	private String				message;
	/**
	 * 对象数据
	 */
	private Map<Object, Object>	mdata;

	/**
	 * 列表数据
	 */
	private List<?>				list;

	/**
	 * 当前记录总的行数
	 */
	private int					totalRow;
	/**
	 * 当前页
	 */
	private int					pageCurrent;

	public CommonResultObject() {
		this.mdata = new HashMap<Object, Object>();
	}

	/**
	 * 构建列表数据
	 * 
	 * @return void
	 * @param ldata
	 */
	public CommonResultObject buildAllResult(List<?> data) {
		this.list = data;
		if (data != null) {
			this.totalRow = data.size();
		}
		return this;
	}

	/**
	 * 返回错误信息
	 * 
	 * @return void
	 */
	public CommonResultObject buildErrorResult(String message) {
		this.statusCode = "error";
		this.message = message;
		return this;
	}

	/**
	 * 添加对象
	 */
	public CommonResultObject addObject(Object key, Object value) {
		this.mdata.put(key, value);
		return this;
	}

	/**
	 * 获取 statusCode
	 */
	public Object getStatusCode() {
		return statusCode;
	}

	/**
	 * 设置 statusCode
	 */
	public void setResult(Object statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * 获取 message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 设置 message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 获取记录集
	 */
	public List<?> getList() {
		return list;
	}

	/**
	 * 设置记录集
	 */
	public void setList(List<?> data) {
		this.list = data;
		if (data != null) {
			this.totalRow = data.size();
		}
	}

	/**
	 * @return the mdata
	 */
	public Map<Object, Object> getMdata() {
		return mdata;
	}

	/**
	 * @param mdata
	 *            the mdata to set
	 */
	public void setMdata(Map<Object, Object> mdata) {
		this.mdata = mdata;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

}
