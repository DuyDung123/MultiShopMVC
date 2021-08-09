<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/upLoadFile"/>
<c:url var="APIurlMulti" value="/upLoadMultiFile"/>
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
				<div class="col-xs-6">
					<input id="singleFileUploadInput" type="file" name="fileupload"/>
					<button id="upload-button" onclick="uploadFile()"> Upload </button>
				</div>
				<div class="col-xs-6 text-center">
					<div style="margin-left: 100px">
						<input id="multipleFileUploadInput" type="file" name="files" multiple required />
						<button id="upload-button" onclick="startUpload()"> Upload </button>
					</div>
				</div>
			</div>
			
		</div>
		<script>
		    function uploadFile() {
		            var formData = new FormData();
		            var singleFileUploadInput = document.querySelector('#singleFileUploadInput');
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
		                },
		                error : function(err) {
		                	console.log(err);
		                }
		            });
		        }
		    
		    function startUpload() {
		    	var multipleFileUploadInput = document.querySelector('#multipleFileUploadInput');
		    	var files = multipleFileUploadInput.files;
		    	var formData = new FormData();
		    	for(var index = 0; index < files.length; index++) {
		            formData.append("file", files[index]);
		        }
	            console.log("form data " + formData);
	            $.ajax({
	                url : '${APIurlMulti}',
	                data : formData,
	                processData : false,
	                contentType : false,
	                type : 'POST',
	                success : function(data) {
	                	console.log(data);
	                },
	                error : function(err) {
	                	console.log(err);
	                }
	            });
		    }
		</script>
	</main>
</body>

</html>