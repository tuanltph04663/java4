<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@page import="vn.edu.poly.tuanltph04663.dao.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin MOS Template</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Copyright" content="arirusmanto.com">
<meta name="description" content="Admin MOS Template">
<meta name="keywords" content="Admin Page">
<meta name="author" content="Ari Rusmanto">
<meta name="language" content="Bahasa Indonesia">

<link rel="shortcut icon" href="stylesheet/img/devil-icon.png">
<!--Pemanggilan gambar favicon-->
<link rel="stylesheet" href="mos-css/mos-style.css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js" /></script>
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet/">



<!--pemanggilan file css-->


	
	<script type="text/javascript">
		$(document).ready( function() {
			$(document).on('change', '.btn-file :file', function() {
				var input = $(this),
					label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
				input.trigger('fileselect', [label]);
			});
	
			$('.btn-file :file').on('fileselect', function(event, label) {
	
				var	input = $(this).parents('.input-group').find(':text'),
					log = label;
	
				if(input.length) {
					input.val(log);
				} else {
					if( log ) alert(log);
				}
			});

			function readURL(input) {
				if (input.files && input.files[0]) {
					var reader = new FileReader();

					reader.onload = function (e) {
						$('#img-upload').attr('src', e.target.result);
					}

					reader.readAsDataURL(input.files[0]);
				}
			}
	
			$("#image").change(function(){
				readURL(this);
			}); 	
		});
	</script>
</head>
<body>
	<div class="container">


		<div class="content">
			<h1 class="page-title">${pageTitle}</h1>

			<c:if test="${hasError}">
				<div class="alert alert-danger alert-dismissible fade show" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>Opps!</strong> ${errMessage}
				</div>
			</c:if>
		
			<c:if test="${hasInvalid}">
				<div class="alert alert-warning alert-dismissible fade show" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>Opps!</strong> Please correct invalid input.
				</div>
			</c:if>

			<form action="<c:url value="/create-product" />" method="post" enctype="multipart/form-data">

				<div class="row">
					<div class="col-md">

						<div class="form-group <c:if test="${not empty errCode}">has-danger</c:if>">
							<label for="code">Code:</label>
							<input type="text" class="form-control" name="code" id="code" placeholder="Code">
							<c:if test="${not empty errCode}">
								<div class="form-control-feedback">${errCode}</div>
							</c:if>
						</div>

						<div class="form-group <c:if test="${not empty errName}">has-danger</c:if>">
							<label for="name">Name:</label>
							<input type="text" class="form-control" name="name" id="name" placeholder="Name">
							<c:if test="${not empty errName}">
								<div class="form-control-feedback">${errName}</div>
							</c:if>
						</div>

						<div class="form-group <c:if test="${not empty errFatherId}">has-danger</c:if>">
							<label for="fatherId">Category:</label>
							<select class="form-control" name="categoryId" id="categoryId">
								<c:forEach var="category" items="${listCategories}">
									<option value="${category.id}">${category.name}</option>
									<c:forEach var="subCategory" items="${category.subCategories}">
										<option value="${subCategory.id}">- ${subCategory.name}</option>
									</c:forEach>
								</c:forEach>
							</select>
							<c:if test="${not empty errFatherId}">
								<div class="form-control-feedback">${errFatherId}</div>
							</c:if>
						</div>

						<div class="form-group <c:if test="${not empty errUnitPrice}">has-danger</c:if>">
							<label for="unitPrice">Unit Price:</label>
							<input type="text" class="form-control" name="unitPrice" id="unitPrice" placeholder="Unit Price">
							<c:if test="${not empty errUnitPrice}">
								<div class="form-control-feedback">${errUnitPrice}</div>
							</c:if>
						</div>

					</div>

					<div class="col-md">
						<div class="form-group">
							<label>Upload Image</label>
							<div class="input-group">
								<span class="input-group-btn">
									<span class="btn btn-primary btn-file">
										Browse <input type="file" id="image" name="image">
									</span>
								</span>
								<input type="text" class="form-control" readonly>
							</div>
							<img id='img-upload'/>
						</div>
					</div>
				</div>

				<div>
					<button type="submit" class="btn btn-primary">Submit</button>
					<button type="reset" class="btn btn-warning">Reset</button>
					<a href="<c:url value="/list-categories" />" class="btn btn-danger">Back</a>
				</div>

			</form>
		</div>

	</div>
</body>
</html>