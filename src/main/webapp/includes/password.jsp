<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>FORGOT PASSOWRD?</title>
	<meta charset="UTF-8">
	<style><%@include file="/styles/profile.css"%></style> 
</head>
<body>
	<header>

	</header>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-b-160 p-t-50">
				<form class="login100-form validate-form" action="setupServlet" method="post">
				<input type="hidden" name="action" value="add">
					<span class="login100-form-title">

					</span>

				<div class="wrap-input100 rs1 validate-input first" data-validate="Passworde is required">
					<input class="input100" type="password" name="pswd" required>
					<span class="label-input100">Password</span>
				</div>


				<div class="wrap-input100 rs2 validate-input second" data-validate="Password is required">
					<input class="input100" type="password" name="confirm_pswd" required>
					<span class="label-input100">Confirm Password</span>
				</div>


					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Save Password
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>

</body>
</html>