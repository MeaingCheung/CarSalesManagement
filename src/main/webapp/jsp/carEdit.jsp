<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<div class="bjui-pageContent">
	<form action="/addOrUpdateCar?id=${car.id}"
		class="datagrid-edit-form" data-toggle="validate"
		data-data-type="json">
		<div class="bjui-row col-2">
			<label class="row-label">车辆名称</label>
			<div class="row-input required">
				<input type="text" name="inputName" value="${car.name}"
					data-rule="required">
			</div>
			<label class="row-label">厂商</label>
			 <input type="hidden" name="manufacturerId" value="${car.manufacturerId}" >
        <div class="row-input required">
            <input type="text" name="manufacturerName" value="${car.manufacturerName}" data-toggle="findgrid" data-options="{
                include: 'manufacturerName:name,manufacturerId:id',
                dialogOptions: {title:'查询厂商'},
                gridOptions: {
                    local: 'local',
                    dataUrl: '/getManufacturerInfo',
                    columns: [
                        {name:'name', label:'公司名称',align:'center'},
                        {name:'serialNumber', label:'编号',align:'center'},
                        {name:'createTime', label:'创建日期',align:'center'},
                        {name:'id', hide:'true'}
                    ]
                }
            }">
        </div>
			<c:if test="${car.id==null}">checked
			<label class="row-label">编号</label>
			<div class="row-input required">
				<input type="text" name="serialNumber" value="${car.serialNumber}"
					data-rule="required">
			</div>
			</c:if>
			<label class="row-label">类型：</label>
			<div class="row-input required">
				<select name="type" data-toggle="selectpicker"
					data-rule="required" data-width="100%">
					<option value="0"
						<c:if test="${car.type==0}">selected</c:if>>普通轿车</option>
					<option value="1"
						<c:if test="${car.type==1}">selected</c:if>>SUV</option>
					<option value="2"
						<c:if test="${car.type==2}">selected</c:if>>跑车</option>
				</select>
			</div>
			<label class="row-label">颜色：</label>
			<div class="row-input">
				<input type="text" name="color" value="${car.color}">
			</div>
			<label class="row-label">产地：</label>
			<div class="row-input">
				<input type="text" name="productAddress" value="${car.productAddress}">
			</div>
			<label class="row-label">备注：</label>
			<div class="row-input">
				<input type="text" name="comment" value="${car.comment}">
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