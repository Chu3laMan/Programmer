<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Profile</title>
	<meta charset="UTF-8">
	<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
    <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
	
	<style><%@include file="/styles/profile.css"%></style>  
</head>
<body>
<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Expires","0");
response.setDateHeader("Expires",-1);
%>
    <header>
		<nav>
		<form action="PgmrProfile2" method="get">
		<input type="hidden" name="action2" value="search">
			<button class="btn1" > Search</button>
		</form>
		<form action="PgmrProfile3" method="get">
		<input type="hidden" name="action3" value="logout">
			<button class="btn2" > Logout</button>
		</form>
		</nav>
	</header>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-b-160 p-t-50">
			<p class="wrap-message"><i>${message}</i></p>
				<form class="login100-form validate-form" action="PgmrProfile" method="post">
				<input type="hidden" name="action" value="add">
					<span class="login100-form-title">
						<img src="http://localhost:8002/Programmer/images/logo.jpg" alt=""> 
					</span>

				<div class="wrap-input100 rs1 validate-input first" data-validate="First Name is required">
					<input class="input100" type="text" name="firstName" value="${programmer2.firstName}">
					<span class="label-input100">First Name</span>
				</div>


				<div class="wrap-input100 rs2 validate-input second" data-validate="Last Name is required">
					<input class="input100" type="text" name="lastName" value="${programmer2.lastName}">
					<span class="label-input100">Last Name</span>
				</div>
				<div class="wrap-input100 rs2 validate-input" data-validate="Email is required">
					<input class="input100" type="email" name="email" value="${programmer2.email}">
					<span class="label-input100">Email</span>
				</div>
				<div class="wrap-input100 rs2 validate-input" data-validate="Password is required">
					<input class="input100" type="password" name="password" value="">
					<span class="label-input100">Password</span>
				</div>
				<div class="wrap-input100 rs2 validate-input" data-validate="Confirm Password is required">
					<input class="input100" type="password" name="confirm_password" value="">
					<span class="label-input100">Confirm Password</span>
				</div>
				
				
				<div class="wrap-input100 rs2 validate-input" data-validate="Language is required">  
					<input class="input100" type="text" name="lang" value="${lang}">
					<span class="label-input100">Programming Languages</span>
				</div>
				
				
				<div class="wrap-input100 rs2 validate-input" data-validate="Framework is required">
					<input class="input100" type="text" name="fwk" value="${fwk}">
					<span class="label-input100">Framework</span>
				</div>
				<div class="wrap-input100 rs2 validate-input" data-validate="GitHub Account is required">
					<input class="input100" type="text" name="github_account" value="${programmer2.github_account}">
					<span class="label-input100">GitHub Account</span>
				</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Update
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>

</body>
</html>