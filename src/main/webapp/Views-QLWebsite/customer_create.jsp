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
			<form action="${pageContext.request.contextPath}/customerCreate" method="post">
				<input type="text" name="userName" placeholder="Username"> 
				<input type="password" name="password" placeholder="Password">
				<input type="text" name="email" placeholder="Email"> 
				<input type="text" name="type" placeholder="Type"> 
				<input type="submit" value="Create">
			</form>
		</div>

		<!-- include footer.jsp -->
		<%@include file="common/_footer.jsp"%>
	</div>
</body>
</html>