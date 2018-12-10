<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<!-- import _head.jsp -->
<%@include file="common/_head.jsp"%>

<body>
	<!-- import _header.jsp -->
	<%@include file="common/_header.jsp"%>

	<section id="form">
		<!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form">
						<!--login form-->
						<h2>Login to your account</h2>
						<form action="/Assignment/CheckLogin" method="get">

							<input type="text" name="username" placeholder="UserName" /> <input
								type="password" name="password" placeholder="Password" /> <span>
								<input type="checkbox" class="checkbox"> Keep me signed
								in
							</span>
							<button type="submit" class="btn btn-default">Login</button>
						</form>
					</div>
					<!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form">
						<!--sign up form-->
						<h2>New User Signup!</h2>
						<form action="/Assignment/Register" method="post">
							<input type="text" name="username" placeholder="Name" /> <input
								type="email" name="email" placeholder="Email Address" /> <input
								type="password" name="password" placeholder="Password" />
							<button type="submit" class="btn btn-default">Signup</button>
						</form>
					</div>
					<!--/sign up form-->
				</div>
			</div>
		</div>
	</section>
	<!--/form-->


	<!-- import _footer.jsp -->
	<%@include file="common/_footer.jsp"%>

	<!-- import _head.jsp -->
	<%@include file="common/_external_js.jsp"%>
</body>
</html>