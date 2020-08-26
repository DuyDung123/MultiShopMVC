<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <main>
        <div class="container-fluid">
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table mr-1"></i>
                    DataTable Example
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="checkAll"></th>
                                    <th>image</th>
                                    <th>Name</th>
                                    <th>quantity</th>
                                    <th>active</th>
                                    <th>action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${model.listResult}">
                                    <tr>
                                        <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                        <td>${item.image}</td>
                                        <td>${item.name}</td>
                                        <td>${item.quantity}</td>
                                        <td>${item.active}</td>
                                        <td>
                                            <c:url var="editURL" value="/admin-new">
                                                <c:param name="type" value="edit" />
                                                <c:param name="id" value="${item.id}" />
                                            </c:url>
                                            <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                title="Cập nhật bài viết" href='${editURL}'><i
                                                    class="fas fa-pencil-alt    "></i>
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
</body>

</html>