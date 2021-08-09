<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>FORGOT PASSWORD</title>
	<meta charset="UTF-8">
	<style><%@include file="/styles/profile.css"%></style>  
</head>
<body>
	<header>

	</header>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-b-160 p-t-50">
			<p class="wrap-message"><i>${message}</i></p>
				<form class="login100-form validate-form" action="forgetServlet" method="post">
				<input type="hidden" name="action" value="add">
					<span class="login100-form-title">
					</span>

				<div class="wrap-input100 rs1 validate-input first" data-validate="Email is required">
					<input class="input100" type="email" name="email" required>
					<span class="label-input100">EMAIL</span>
				</div>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							SEND
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>

</body>
</html>
