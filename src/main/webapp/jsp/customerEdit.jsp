<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<div class="bjui-pageContent">
	<form action="/addOrUpdateCustomer?id=${customer.id}"
		class="datagrid-edit-form" data-toggle="validate"
		data-data-type="json">
		<div class="bjui-row col-2">
			<label class="row-label">姓名</label>
			<div class="row-input required">
				<input type="text" name="inputName" value="${customer.name}"
					data-rule="required">
			</div>
			<c:if test="${customer.id==null}">checked
			<label class="row-label">编号</label>
			<div class="row-input required">
				<input type="text" name="identifierNumber" value="${customer.identifierNumber}"
					data-rule="required number">
			</div>
			</c:if>
			<label class="row-label">性别</label>
			<div class="row-input required">
				<input type="radio" name="gender" id="j_datagrid_edit_sex1"
					data-toggle="icheck" value="0" data-rule="checked"
					data-label="男&nbsp;&nbsp;"
					<c:if test="${customer.gender==0}">checked</c:if>> <input
					type="radio" name="gender" id="j_datagrid_edit_sex2"
					data-toggle="icheck" value="1" data-label="女"
					<c:if test="${customer.gender==1}">checked</c:if>>
			</div>
			<label class="row-label">年龄</label>
			<div class="row-input required" >
				<input type="text" name="age" value="${customer.age}" data-rule="number">
			</div>
			<label class="row-label">手机号：</label>
			<div class="row-input">
				<input type="text" name="phoneNumber"
					value="${customer.phoneNumber}" data-rule="number">
			</div>
			<label class="row-label">邮箱：</label>
			<div class="row-input">
				<input type="text" name="email" value="${customer.email}">
			</div>
			<label class="row-label">地址：</label>
			<div class="row-input">
				<input type="text" name="address" value="${customer.address}">
			</div>
			<label class="row-label">职业：</label>
			<div class="row-input">
				<input type="text" name="job" value="${customer.job}">
			</div>
		</div>
	</form>
</div>
<div class="bjui-pageFooter">
	<ul>
		<li><button type="button" class="btn-close" data-icon="close">取消</button></li>
		<li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
	</ul>
</div>
</html>