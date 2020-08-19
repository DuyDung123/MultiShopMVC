<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value='/api/menu'/>
<c:url var="MenuURL" value='/admin/menu/list'/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="UTF-8">
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
					<div class="float-right">
						<button class="btn btn-primary addMenu" data-toggle="modal" data-target="#addMenu"
							href='<c:url value="/admin/N/menu/edit"/>' title='Thêm menu'><i
								class="fas fa-plus-circle"></i></button>
						<button id="btnDelete" type="button"
							class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip"
							title='Xóa bài viết'>
							<span>
								<i class="fas fa-trash-alt"></i>
							</span>
						</button>
					</div>
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
											<c:url var="editURL" value="/admin/N/menu/edit">
												<c:param name="id" value="${item.id}" />
											</c:url>
											<a class="btn btn-primary addMenu btn-edit" data-toggle="modal"
												data-target="#addMenu" href='${editURL}' title='Cập nhật menu'><i
													class="fas fa-pencil-alt"></i>
											</a>
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
	<!-- modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					...
				</div>
			</div>
		</div>
	</div>
	<script>
		 $("#btnDelete").click(function () {
				var data = {};
				var ids = $('tbody input[type=checkbox]:checked').map(function () {
					return $(this).val();
				}).get();
				data = ids;
				console.log(data);
				deleteNew(data);
				var url = '${APIurl}';
				console.log(url);
			});

			function deleteNew(data) {
				$.ajax({
					url: '${APIurl}',
					type: 'DELETE',
					contentType: 'application/json',
					data: JSON.stringify(data),
					success: function (result) {
						window.location.href = "${MenuURL}";
					},
					error: function (error) {
						window.location.href = "${MenuURL}";
					}
				});
			}
	</script>
</body>

</html>