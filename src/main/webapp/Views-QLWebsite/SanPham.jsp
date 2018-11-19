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
</head>

<body>
	<div id="header">
		<div class="inHeader">
			<div class="mosAdmin">
				Hallo, Mas Administrator<br> <a href="">Lihat website</a> | <a
					href="">Help</a> | <a href="login.html">Keluar</a>
			</div>
			<div class="clear"></div>
		</div>
	</div>

	<div id="wrapper">
		<div id="leftBar">
			<ul>
				<li><a href="index.html">Trang chủ</a></li>
				<li><a href="tabel.html">Sản Phẩm</a></li>
				<li><a href="form.html">Thành Viên</a></li>
			</ul>
		</div>
		<div id="rightContent">
			<h3>Sản Phẩm</h3>
			
						<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Image</th>
						<th>Category</th>
						<th>Unit Price</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
									<c:forEach var="sp" items="<%=ProductsDAO.DanhSach() %>">
					<tr class="data">

						<td class="data">${sp.idProducts }</td>
						<td><img src="images/home/${sp.image}" alt="" /></td>
						<td class="data">${sp.nameProduct }</td>
						<td class="data">${sp.price }</td>
						<td class="data" width="75px">
							<td>
								<i class="fa fa-trash" aria-hidden="true"></i>
							</td>
						
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
		</div>
		<div class="clear"></div>
		<div id="footer">
			&copy; 2012 MOS css template | <a href="#">Nama Website Anda</a> |
			design <a href="http://arirusmanto.com" target="_blank">arirusmanto.com</a><br>
			redesign <a href="#">Tulis nama anda disini</a> | Silahkan baca <a
				href="lisensi.txt" target="_blank">Lisensi</a>
		</div>
	</div>
</body>
</html>