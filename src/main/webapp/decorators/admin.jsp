<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>

<head>
	<title>
		<dec:title default="Trang chủ" />
	</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
	<link href="<c:url value='/template/admin/css/styles.css'/>" rel="stylesheet" />
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<link href="<c:url value='/template/admin/css/menu.css'/>"  rel="stylesheet"/>
	<script src="<c:url value='/template/admin/paging/jquery.twbsPagination.js'/>"></script>
	<script src="<c:url value='/ckeditor/ckeditor.js' />"></script>
</head>

<body class="sb-nav-fixed">

	<!-- header -->
	<%@ include file="/common/admin/header.jsp" %>
	<!-- header -->

	<div id="layoutSidenav">
		<!-- menu -->
		<%@ include file="/common/admin/menu.jsp" %>
		<!-- menu -->
		<div id="layoutSidenav_content">
			<dec:body />
			<!-- footer -->
			<%@ include file="/common/admin/footer.jsp" %>
			<!-- footer -->
		</div>
	</div>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
	<script src="<c:url value='/template/admin/js/scripts.js'/>"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
	<script src="<c:url value='/template/admin/assets/demo/datatables-demo.js'/>"></script>
	<script src="<c:url value='/template/admin/assets/js/menu.js'/>"></script>
</body>

</html>