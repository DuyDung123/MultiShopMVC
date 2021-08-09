<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/upLoadFile"/>
<html>
<head>
    <c:if test="${empty model.id}">
        <title>Thêm sản phẩm</title>
    </c:if>
    <c:if test="${not empty model.id}">
            <title>Chỉnh sửa sản phẩm</title>
    </c:if>
    <style>
    #lbupload-photo {
   		cursor: pointer;
   		/* Style as you please, it will become the visible UI component. */
	}

	#upload-photo {
   		opacity: 0;
   		position: absolute;
   		z-index: -1;
	}
	</style>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a><span> > </span>
                </li>
                <c:if test="${empty model.id}">
                    <li class="active">Thêm sản phẩm</li>
                </c:if>
                <c:if test="${not empty model.id}">
                    <li class="active">Chỉnh sửa sản phẩm</li>
                </c:if>
                
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12 mx-auto">
                        <c:if test="${not empty messageResponse}">
									<div class="alert alert-${alert}">
  										<%-- ${messageResponse} --%>
  										Thêm thành công
									</div>
						</c:if>
                        <form style="width: 80%; margin-left: 5%;" id="formSubmit" action="<c:url value="/admin/product/add"/>" method="Post" enctype="multipart/form-data">
                            <div class="form-group row">
                                <label class="col-sm-3 control-label no-padding-right">Thể loại sản phẩm</label>
                                <div class="col-sm-4">
                                    <select class="form-control">
                                         <c:if test="${empty model.menuchild}">
                                            <option value="">Phân loại</option>
                                            <c:forEach var="item" items="${menuchilds.listResult}">
                                                <option value="${item.id}">${item.name}</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${not empty model.menuchild}">
                                            <option value="">Chọn loại sản phẩm</option>
                                            <c:forEach var="item" items="${menuchilds.listResult}">
                                                <option value="${item.id}" <c:if test="${item.id == model.menuchild}">selected="selected"</c:if>>
                                                        ${item.name}
                                                </option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                                <div class="col-sm-5">
                                    <select class="form-control" id="menuchild" name="menuchild">
                                         <c:if test="${empty model.menuchild}">
                                            <option value="">Chọn loại sản phẩm</option>
                                            <c:forEach var="item" items="${menuchilds.listResult}">
                                                <option value="${item.id}">${item.name}</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${not empty model.menuchild}">
                                            <option value="">Chọn loại sản phẩm</option>
                                            <c:forEach var="item" items="${menuchilds.listResult}">
                                                <option value="${item.id}" <c:if test="${item.id == model.menuchild}">selected="selected"</c:if>>
                                                        ${item.name}
                                                </option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group row">
                                <label class="col-sm-3 control-label no-padding-right">Tên sản phẩm</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="name" name="name" value="${model.name}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group row">
                                <label class="col-sm-3 control-label no-padding-right">Hình ảnh sản phẩm</label>
                                <div class="col-sm-9">
                                	<div class="row">
                                		<img class="col-sm-5" id="imgProduct" alt="" src="<c:url value='${model.image}'/>">
                                		<div class="col-sm-4" style="text-align:inherit; margin-left: auto">
                                			<div style="margin-top: 70px;">
                                				<label style="cursor: pointer;" for="upload-photo">Chọn ảnh</label>
												<input style="opacity: 0; position: absolute; z-index: -1;" type="file" name="file" id="upload-photo"/>
                                			</div>
                                		</div>
                                	</div>
                                    <input type="hidden" class="form-control" id="image" name="image" value="${model.image}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group row">
                                <label class="col-sm-3 control-label no-padding-right">sản phẩm HOT</label>
                                <div class="col-sm-9">
                                	<select class="form-control" id="hotProduct" name="hotProduct">
                                		<option value="0">False</option>
                                		<option value="1">True</option>
                                	</select>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group row">
                                <label class="col-sm-3 control-label no-padding-right">active</label>
                                <div class="col-sm-9">
                                    <select class="form-control" id="active" name="active">
                                		<option value="0">False</option>
                                		<option value="1">True</option>
                                	</select>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group row">
                                <label class="col-sm-3 control-label no-padding-right">quantity</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="quantity" name="quantity" value="${model.quantity}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group row">
                                <label class="col-sm-3 control-label no-padding-right">giá Gốc</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="initialPrice" name="initialPrice" value="${model.initialPrice}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group row">
                                <label class="col-sm-3 control-label no-padding-right">giá khuyến mãi</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="currentPrice" name="currentPrice" value="${model.currentPrice}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group row">
                                <label class="col-sm-3 control-label no-padding-right">Thông tin sản phẩm</label>
                                <div class="col-sm-9">                                 
                                    <textarea rows="" cols="" id="infoDetail" name="infoDetail" style="width: 820px;height: 175px">${model.infoDetail}</textarea>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <c:if test="${not empty model.id}">
                                        <input type="submit" class="btn btn-white btn-warning btn-bold" value="Cập nhật sản phẩm" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                    <c:if test="${empty model.id}">
                                        <input type="submit" class="btn btn-white btn-warning btn-bold" value="Thêm sản phẩm" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                </div>
                            </div>
                            <input type="hidden" value="${model.id}" id="id" name="id"/>
                        </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
	
	var editor = '';
	$(document).ready(function(){
		editor = CKEDITOR.replace( 'infoDetail');
	});
	
	$('input[type=file]').change(function () {
	      console.dir(this.files[0]);
	      var formData = new FormData();
          var singleFileUploadInput = document.querySelector('#upload-photo');
          var files = singleFileUploadInput.files[0];
          formData.append('file',files);
          //formData.append('file', $('input[type=file]')[0].files[0]);
          console.log("form data " + formData);
          $.ajax({
              url : '${APIurl}',
              data : formData,
              processData : false,
              contentType : false,
              type : 'POST',
              success : function(data) {
              	console.log(data);
              	document.getElementById("imgProduct").src= data.fileDownloadUri;
              	document.getElementById("image").value = data.fileName;
              },
              error : function(err) {
              	console.log(err);
              }
          });
	})
	
	
</script>
</body>
</html>
