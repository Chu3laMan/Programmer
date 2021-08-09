<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Sign in to Programmer Web Site</title>
	<meta charset="UTF-8">
    <META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
    <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
    
	<style><%@include file="/styles/login.css"%></style> 
	

</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-b-160 p-t-50">
			<p class="wrap-message"><i>${message}</i></p>
				<form class="login100-form validate-form" action="signInPage" method="post">
				<input type="hidden" name="action" value="add">
					<span class="login100-form-title p-b-43">
						Account Login
					</span>

					<div class="wrap-input100 rs1 validate-input" data-validate = "Email is required">
						<input class="input100" type="email" name="username" required>
						<span class="label-input100">Email</span>
					</div>


					<div class="wrap-input100 rs2 validate-input" data-validate="Password is required">
						<input class="input100" type="password" name="pswd" required>
						<span class="label-input100">Password</span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Sign in
						</button>
					</div>

					<div class="text-center w-full p-t-23">
						<a href="http://localhost:8002/Programmer/includes/forgot.jsp" class="txt1">
							Forgot password?
						</a>

					</div>
				</form>
			</div>
		</div>
	</div>



</body>
</html>
