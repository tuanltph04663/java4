<%@page import="vn.edu.poly.tuanltph04663.model.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
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
			<% Account a = (Account) request.getAttribute("accountToUpdate");%>
			<form action="${pageContext.request.contextPath}/customerUpdate" method="post">
				<input type="number" hidden="true" name="id" value="<%=a.getIdAccount() %>">
				<input type="text" name="userName"  placeholder="Username" value="<%=a.getUserName()%>">
				<input type="password" name="password"  placeholder="Password" value="<%= a.getPassword()%>">
				<input type="text" name="email"  placeholder="Email" value="<%=a.getEmail() %>">
				<input type="text" name="type"  placeholder="Type" value="<%= a.getType()%>">
				<input type="submit" value="Cap nhat">
			</form>
		</div>

		<!-- include footer.jsp -->
		<%@include file="common/_footer.jsp"%>
	</div>
</body>
</html>