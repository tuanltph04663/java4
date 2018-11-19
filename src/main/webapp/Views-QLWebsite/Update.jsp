<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@page import="vn.edu.poly.tuanltph04663.dao.*"%>
<%@page import="vn.edu.poly.tuanltph04663.model.*"%>
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
<link rel="stylesheet" type="text/css" href="mos-css/mos-style.css">
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
		<%
			int id = Integer.parseInt(request.getParameter("idProducts"));
			Products sp=ProductsDAO.ThongTin(id);
		%>
		<form action="/Website-BanHang/ControllerProducts">
		<input type="hidden" name="idProducts" value="<%=sp.getIdProducts()%>">
		
           <input type="text" name="hinhanhsp" value="<%=sp.getImage()%>">
            <input type="text" name="tensp" value="<%=sp.getNameProduct()%>">
             <input type="text" name="giasp" value="<%=sp.getPrice()%>">
             <input type="submit" name="action" value="Update">
</form>
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