<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<div class="bjui-pageContent">
	<form action="/addOrUpdateManufacturer?id=${manufacturer.id}"
		class="datagrid-edit-form" data-toggle="validate"
		data-data-type="json">
		<div class="bjui-row col-2">
			<label class="row-label">公司名称</label>
			<div class="row-input required">
				<input type="text" name="inputName" value="${manufacturer.name}"
					data-rule="required">
			</div>
			<c:if test="${manufacturer.id==null}">checked
			<label class="row-label">编号</label>
			<div class="row-input required">
				<input type="text" name="serialNumber" value="${manufacturer.serialNumber}"
					data-rule="required number">
			</div>
			</c:if>
			<label class="row-label">联系电话：</label>
			<div class="row-input">
				<input type="text" name="contactNumber"
					value="${manufacturer.contactNumber}" data-rule="number">
			</div>
			<label class="row-label">联系邮箱：</label>
			<div class="row-input">
				<input type="text" name="contactEmail" value="${manufacturer.contactEmail}">
			</div>
			<label class="row-label">地址：</label>
			<div class="row-input">
				<input type="text" name="address" value="${manufacturer.address}">
			</div>
			<label class="row-label">网址：</label>
			<div class="row-input">
				<input type="text" name="webSite" value="${manufacturer.webSite}">
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