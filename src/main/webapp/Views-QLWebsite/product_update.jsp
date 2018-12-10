<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@page import="vn.edu.poly.tuanltph04663.dao.*"%>
<%@page import="vn.edu.poly.tuanltph04663.model.*"%>
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
			<%
				Products p = (Products) request.getAttribute("productToUpdate");
			%>
			<form action="${pageContext.request.contextPath}/productUpdate" method="post">
				<input type="hidden" name="idProducts" value="<%=p.getIdProducts()%>"> 
				<select name="categoryId">
					<c:forEach items="${categories}" var="category">
						<option value="${category.getIdCategory()}">${category.getNameCategory()}</option>
					</c:forEach>
				</select>
				<input type="text" name="image" value="<%=p.getImage()%>"> 
				<input type="text" name="nameProduct" value="<%=p.getNameProduct()%>">
				<input type="number" name="price" value="<%=p.getPrice()%>">
				<input type="submit" name="susbmit" value="Update">
			</form>
		</div>

		<!-- include footer.jsp -->
		<%@include file="common/_footer.jsp"%>
	</div>
</body>
</html>