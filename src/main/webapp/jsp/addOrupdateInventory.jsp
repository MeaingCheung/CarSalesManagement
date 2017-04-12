<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<div class="bjui-pageContent">
	<form action="/changeInventory?type=0" class="datagrid-edit-form"
		data-toggle="validate" data-data-type="json">
		<div class="bjui-row col-2">
			<label class="row-label">编号</label>
			<div class="row-input">
				<input type="text" name="serialNumber" value="${car.serialNumber}"
					readonly="">
			</div>
			<label class="row-label">车辆名称</label>
			<div class="row-input">
				<input type="text" name="inputName" value="${car.name}" disabled="">
			</div>
			<label class="row-label">入库数量</label>
			<div class="row-input required">
				<input type="text" name="amount" value="1" data-toggle="spinner"
					data-min="1" data-max="10000" data-step="1"
					data-rule="required;integer">
			</div>
			<label class="row-label">进价</label>
			<div class="row-input required">
				<input type="text" name="costPrice" data-rule="required;number">
			</div>
			<label class="row-label">入库日期</label>
			<div class="row-input required">
				<input type="text" name="changeInventoryTime"
					data-toggle="datepicker" data-rule="required"
					data-pattern="yyyy-MM-dd HH:mm:ss">
			</div>
			<label class="row-label">备注：</label>
			<div class="row-input">
				<input type="text" name="comment" value="">
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
<script type="text/javascript">
	function closeDialog() {
		BJUI.dialog('close', 'in_inventory_dialog');
	}
</script>
</html>