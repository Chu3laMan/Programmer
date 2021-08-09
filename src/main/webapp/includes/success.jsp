<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <META http-equiv="refresh" content="5;URL=login.jsp">
    <title>Registration was Successful</title>
    <style><%@include file="/styles/success.css"%></style>
</head>
<body>
    <div class="container">
    
        <h1>Thank you for joining Programmer Web site</h1>
        <p>Here is the information you entered:
        </p>
        
        <strong><label>First Name :</label></strong>
        <span>${programmer2.firstName}</span><br>
        
        <strong><label>Last Name :</label></strong>
        <span>${programmer2.lastName}</span><br>
        
        <strong><label>Email :</label></strong>
        <span>${programmer2.email}</span><br>
        
        <strong><label>GitHub Account :</label></strong>
        <span>${programmer2.github_account}</span><br>
        
        <p></p><br>
        <p class="wrap-p">Hold on, it will redirect you in a moment!</p>
        
        
        
    </div>
</body>
</html>