<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@page import="vn.edu.poly.tuanltph04663.dao.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<!-- include head.jsp -->
<%@include file="common/_head.jsp"%>

<body>
	<!-- include header.jsp -->
	<%@include file="common/_header.jsp"%>

	<div id="wrapper">
		<!-- include sidebar.jsp -->
		<%@include file="common/_sidebar.jsp"%>

		<div id="rightContent">
			<h3>Sản Phẩm - <a href="${pageContext.request.contextPath}/productCreate">Them san pham</a></h3>
			<%-- <form action="${pageContext.request.contextPath}/productCreate" method="get">
				<input type="submit" value="Them san pham">
			</form> --%>

			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Image</th>
						<th>Category</th>
						<th>Cap nhat</th>
						<th>Xoa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${products}" var="p">
						<tr class="data">

							<td class="data">${p.idProducts }</td>
							<td class="data"><img src="images/home/${p.image}" alt="" /></td>
							<td class="data">${p.nameProduct }</td>
							<td class="data">${p.price }</td>
							<td class="data">
								<form action="${pageContext.request.contextPath}/productUpdate" method="get">
									<input type="number" hidden="true" name="id" value="${p.idProducts}">
									<input type="submit" value="Cap nhat">
								</form>
							</td>
							<td class="data">
								<form action="${pageContext.request.contextPath}/productDelete" method="post">
									<input type="number" hidden="true" name="id" value="${p.idProducts}">
									<input type="submit" value="Xoa">
								</form>
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>

		<!-- include footer.jsp -->
		<%@include file="common/_footer.jsp"%>
	</div>
</body>
</html>