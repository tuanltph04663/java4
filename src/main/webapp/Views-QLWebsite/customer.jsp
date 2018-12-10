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
			<!-- Content here... -->
			<h3>
				Khach hang - <a href="${pageContext.request.contextPath}/customerCreate">Them khach hang</a>
			</h3>

			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Cap nhat</th>
						<th>Xoa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${accounts}" var="a">
						<tr class="data">

							<td class="data">${a.idAccount }</td>
							<td class="data">${a.userName}</td>
							<td class="data">${a.email }</td>
							<td class="data">
								<form action="${pageContext.request.contextPath}/customerUpdate"
									method="get">
									<input type="number" hidden="true" name="id"
										value="${a.idAccount}"> <input type="submit"
										value="Cap nhat">
								</form>
							</td>
							<td class="data">
								<form action="${pageContext.request.contextPath}/customerDelete"
									method="post">
									<input type="number" hidden="true" name="id"
										value="${a.idAccount}"> <input type="submit"
										value="Xoa">
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