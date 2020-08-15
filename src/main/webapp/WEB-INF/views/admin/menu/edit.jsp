<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<c:if test="${not empty model.id}">
	<title>Chỉnh sửa menu</title>
</c:if>
<c:if test="${empty model.id}">
	<title>Thêm menu</title>
</c:if>
</head>

<body>
	<main>
		<div class="container-fluid">
			<div class="breadcrumbs" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trangchủ</a></li>
					<c:if test="${not empty model.id}">
						<li class="active">Chỉnh sửa menu</li>
					</c:if>
					<c:if test="${empty model.id}">
						<li class="active">thêm menu</li>
					</c:if>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="row">
				<div class="col-xs-12">
					<c:if test="${not empty messageResponse}">
						<div class="alert alert-${alert}">${messageResponse}</div>
					</c:if>
					<form id="formSubmit" action="<c:url value="/admin/menu/update"/>"
						method="post">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">Tên
								menu</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="name" name="name"
									value="${model.name}" />
							</div>
						</div>
						<br /> <br />
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">code</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="code" name="code"
									value="${model.code}" />
							</div>
						</div>
						<br /> <br /> <input type="hidden" value="${model.id}" id="id"
							name="id" />
						<div class="form-group">
							<div class="col-sm-12">
								<c:if test="${not empty model.id}">
									<button type="submit"
										class="btn btn-white btn-warning btn-bold"
										id="btnAddOrUpdateNew">Cập nhật menu</button>
								</c:if>
								<c:if test="${empty model.id}">
									<button type="submit"
										class="btn btn-white btn-warning btn-bold"
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