<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<html>

<head>
	<meta charset="UTF-8">
</head>

<body>
	<main>
		<div class="container-fluid">
			<div class="breadcrumbs" id="breadcrumbs">
				<ul class="breadcrumb">
					<c:if test="${not empty model.id}">
						<li class="active">Chỉnh sửa menu ${type}</li>
					</c:if>
					<c:if test="${empty model.id}">
						<li class="active">thêm menu ${type}</li>
					</c:if>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="row">
				<div class="col-xs-12">
					<form id="formSubmit" action="<c:url value="/admin/menu/update"/>"
						method="POST">
						<div class="ml-2 input-group" style="padding-left: 3px;">
							<div class="input-group-prepend">
								<span class="input-group-text">tên menu</span>
							</div>
							<input type="text" class="form-control" name="name" style="width: 320px;" value="${model.name}"
								aria-label="Amount (to the nearest dollar)">
						</div>
						<br />
						<input type="hidden" value="${model.id}" id="id" name="id" />
						<input type="hidden" value="${type}" id="type" name="type" />
						<input type="hidden" value="${dadId}" id="dadId" name="dadId" />
						<div class="form-group">
							<div class="col-sm-12">
								<c:if test="${not empty model.id}">
									<button type="submit" class="btn btn-white btn-warning btn-bold"
										id="btnAddOrUpdateNew">Cập nhật menu</button>
								</c:if>
								<c:if test="${empty model.id}">
									<button type="submit" class="btn btn-white btn-warning btn-bold"
										id="btnAddOrUpdateNew">Thêm menu</button>
								</c:if>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>

</html>