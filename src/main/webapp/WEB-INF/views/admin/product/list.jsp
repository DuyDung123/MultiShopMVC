<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:url var="APIurl" value="/api/product"/>
<c:url var ="ProductURL" value="/admin/product/list"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>List product</title>
</head>

<body>
    <style>
        td.text-center {
            width: 10%;
        }

        img.imgitem {
            width: 100%;
        }
    </style>
    <main>
        <div class="container-fluid">
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table mr-1"></i>
                    Danh sách sản phẩm
                    <div class="float-right">
                    	<a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
							title='Thêm sản phẩm' href='<c:url value="/admin/product/edit"/>'>
								<span>
									<i class="fa fa-plus-circle bigger-110 purple"></i>
								</span>	
						</a>
						<button id="btnDelete" type="button"
							class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa sản phẩm'>
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
                                        <td class="text-center"><img src="<c:url value='${item.image}'/>"
                                                class="imgitem" alt=""></td>
                                        <td>${item.name}</td>
                                        <td>${item.quantity}</td>
                                        <td>${item.active}</td>
                                        <td>
                                            <c:url var="editURL" value="//admin/product/edit">
                                                <c:param name="id" value="${item.id}" />
                                            </c:url>
                                            <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                title="Cập nhật sản phẩm" href='${editURL}'><i
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
    <script>
        var chekbox = $('tbody input[type=checkbox]');
        var checkAll = true;
        $('#checkAll').change(function () {
            if (checkAll === true) {
                for (let i = 0; i < chekbox.length; i++) {
                    const element = chekbox[i];
                    element.checked = true;
                }
                checkAll = false;
            }
            else {
                for (let i = 0; i < chekbox.length; i++) {
                    const element = chekbox[i];
                    element.checked = false;
                }
                checkAll = true;
            }
        });
        
        
        $("#btnDelete").click(function() {
			var data = {};
			var ids = $('tbody input[type=checkbox]:checked').map(function () {
	            return $(this).val();
	        }).get();
			data = ids;
			deleteProduct(data);
		});
        
        function deleteProduct(data) {
	        $.ajax({
	            url: '${APIurl}',
	            type: 'DELETE',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            success: function (result) {
	                window.location.href = "${ProductURL}?message=delete_success";
	            },
	            error: function (error) {
	            	window.location.href = "${ProductURL}?message=error_system";
	            }
	        });
	    }
    </script>
</body>

</html>