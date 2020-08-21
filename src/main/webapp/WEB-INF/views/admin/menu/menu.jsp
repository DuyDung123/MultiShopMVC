<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách Menu</title>
</head>

<body>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered " id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <th>
                        <div class="float-left">Danh Sách menu</div>
                        <div class="float-right">
                            <c:url var="editURL" value="/admin/N/menu/edit">
                                <c:param name="type" value="dad" />
                            </c:url>
                            <button class="btn btn-primary addMenu" data-toggle="modal" data-target="#addMenu"
                                href='${editURL}' title='Thêm menu'><i class="fas fa-plus-circle"></i></button>
                        </div>
                    </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="itemDad" items="${modelDad.listResult}">
                        <tr>
                            <td>
                                <div class="bcc ">
                                    <button type="button" class="btn btn-primary menudad"
                                        id="myBtn">${itemDad.name}</button>
                                    <div class="action">
                                        <div class="toasts-header">
                                            <c:url var="addChild" value="/admin/N/menu/edit">
                                                <c:param name="type" value="child" />
                                                <c:param name="dadId" value="${itemDad.id}" />
                                            </c:url>
                                            <c:url var="editURL" value="/admin/N/menu/edit">
                                                <c:param name="id" value="${itemDad.id}" />
                                                <c:param name="type" value="dad" />
                                            </c:url>
                                            <c:url var="delDad" value="/admin/menu/delete">
                                                <c:param name="ids" value="${itemDad.id}" />
                                                <c:param name="type" value="dad" />
                                            </c:url>
                                            <a class="addMenu btn-edit" data-toggle="modal" data-target="#addMenu"
                                                href='${addChild}' title='thêm menu con'>
                                                <i class="icon-rotate fas fa-plus-circle ml-2 mr-2"></i>
                                            </a>
                                            <a class="addMenu btn-edit" data-toggle="modal" data-target="#addMenu"
                                                href='${editURL}' title='Cập nhật menu'><i
                                                    class="icon-rotate fas fa-pencil-alt mr-2"></i>
                                            </a>
                                            <a  href='${delDad}'><i class="icon-rotate fas fa-trash-alt mr-2" aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="ml-5 rounded border fame-item-menudad">
                                    <c:forEach var="item" items="${modelChild.listResult}">
                                        <c:if test="${item.dadId == itemDad.id}">
                                            <div class="bcc ml-3 mr-5 mb-3">
                                                <button type="button" class="btn btn-primary menudad"
                                                    id="myBtn">${item.name}</button>
                                                <div class="action">
                                                    <div class="toasts-header">
                                                        <c:url var="editURL" value="/admin/N/menu/edit">
                                                            <c:param name="id" value="${item.id}" />
                                                            <c:param name="type" value="child" />
                                                            <c:param name="dadId" value="${itemDad.id}" />
                                                        </c:url>
                                                        <c:url var="delChild" value="/admin/menu/delete">
                                                            <c:param name="ids" value="${item.id}" />
                                                            <c:param name="type" value="child" />
                                                        </c:url>
                                                        <a class="addMenu btn-edit" data-toggle="modal"
                                                            data-target="#addMenu" href='${editURL}'
                                                            title='Cập nhật menu'><i
                                                                class="icon-rotate fas fa-pencil-alt ml-2 mr-2"
                                                                aria-hidden="true"></i></a>
                                                        <a href='${delChild}'><i class="icon-rotate fas fa-trash-alt mr-2"
                                                                aria-hidden="true"></i></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
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
</body>

</html>