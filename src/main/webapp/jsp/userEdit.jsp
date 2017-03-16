<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<div class="bjui-pageContent">
	<form action="/addOrUpdateUser?id=${user.id}"
		class="datagrid-edit-form" data-toggle="validate"
		data-data-type="json">
		<div class="bjui-row col-2">
			<label class="row-label">登录名</label>
			<div class="row-input required">
				<input type="text" name="loginName" value="${user.loginName}"
					data-rule="required">
			</div>
			<label class="row-label">性别</label>
			<div class="row-input required">
				<input type="radio" name="gender" id="j_datagrid_edit_sex1"
					data-toggle="icheck" value="0" data-rule="checked"
					data-label="男&nbsp;&nbsp;"
					<c:if test="${user.gender==0}">checked</c:if>> <input
					type="radio" name="gender" id="j_datagrid_edit_sex2"
					data-toggle="icheck" value="1" data-label="女"
					<c:if test="${user.gender==1}">checked</c:if>>
			</div>
			<label class="row-label">年龄</label>
			<div class="row-input">
				<input type="text" name="age" value="${user.age}">
			</div>
			<label class="row-label">手机号：</label>
			<div class="row-input">
				<input type="text" name="loginPhone" value="${user.loginPhone}">
			</div>
			<label class="row-label">邮箱：</label>
			<div class="row-input">
				<input type="text" name="loginMail" value="${user.loginMail}">
			</div>
			<label class="row-label">部门：</label>
			<div class="row-input required">
				<select name="department" data-toggle="selectpicker"
					data-rule="required" data-width="100%">
					<option value="0"
						<c:if test="${user.department==0}">selected</c:if>>行政部</option>
					<option value="1"
						<c:if test="${user.department==1}">selected</c:if>>技术部</option>
					<option value="2"
						<c:if test="${user.department==2}">selected</c:if>>销售部</option>
					<option value="3"
						<c:if test="${user.department==3}">selected</c:if>>财务部</option>
					<option value="4"
						<c:if test="${user.department==4}">selected</c:if>>售后服务部</option>
				</select>
			</div>
			<label class="row-label">角色：</label>
			<div class="row-input required">
				<select name="role" data-toggle="selectpicker" data-rule="required"
					data-width="100%">
					<option value="0" <c:if test="${user.role==0}">selected</c:if>>管理员</option>
					<option value="1" <c:if test="${user.role==1}">selected</c:if>>普通员工</option>
				</select>
			</div>
			<label class="row-label">备注：</label>
			<div class="row-input">
				<input type="text" name="userRemark" value="${user.userRemark}">
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