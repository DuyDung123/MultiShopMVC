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
						<li class="active">upload ${type}</li>
					</c:if>
					<c:if test="${empty model.id}">
						<li class="active">upload ${type}</li>
					</c:if>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="row">
				<div class="col-xs-12">
					<form method="post" action="<c:url value="/admin/menu/upload"/>" enctype="multipart/form-data">
    					<input type="file" name="file" />
    					<input type="submit" value="Upload" />
  					</form>
				</div>
			</div>
		</div>
	</main>
</body>

</html>