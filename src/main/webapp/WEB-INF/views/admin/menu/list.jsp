<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new" />
<c:url var="NewURL" value="/admin-new" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Danh sách Menu</title>
</head>

<body>
	<main>
		<div class="container-fluid">
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table mr-1"></i>
					DataTable Menu
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
							<thead>
								<th><input type="checkbox" id="checkAll"></th>
								<th>Tên Menu</th>
								<th>code</th>
								<th>Thao tác</th>
								</tr>
							</thead>
							<tfoot>
								<th><input type="checkbox" id="checkAll"></th>
								<th>Tên Menu</th>
								<th>code</th>
								<th>Thao tác</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach var="item" items="${model.listResult}">
									<tr>
										<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
										<td>${item.name}</td>
										<td>${item.code}</td>
										<td>
											<c:url var="editURL" value="/admin/menu/edit">
												<c:param name="id" value="${item.id}" />
											</c:url>
											<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
												title="Cập nhật menu" href='${editURL}'><i class="fas fa-pencil-alt"></i>											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>

</html>