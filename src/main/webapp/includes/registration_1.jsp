<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<style><%@include file="/styles/reg1.css"%></style>
</head>
<body>
<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-b-160 p-t-50">
			<p class="wrap-message"><i>${message}</i></p>
				<form class="login100-form validate-form" action="signup1page" method="post">
				<input type="hidden" name="action" value="add">
					<span class="login100-form-title p-b-43">
						Registration 1/2
					</span>

						<div class="wrap-input100 rs1 validate-input first" data-validate = "First Name is required">
							<input class="input100" type="text" name="firstName" required>
							<span class="label-input100">First Name</span>
						</div>
	
	
						<div class="wrap-input100 rs2 validate-input second" data-validate="Last Name is required">
							<input class="input100" type="text" name="lastName" required>
							<span class="label-input100">Last Name</span>
						</div>
						<div class="wrap-input100 rs2 validate-input email" data-validate="Email is required">
							<input class="input100" type="email" name="email" required>
							<span class="label-input100">Email</span>
						</div>
						<div class="container-login100-form-btn">
							<button class="login100-form-btn">
								Next
							</button>
						</div>
					
				</form>
			</div>
		</div>
	</div>

</body>
</html>