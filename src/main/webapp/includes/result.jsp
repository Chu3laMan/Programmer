<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style><%@include file="/styles/result.css"%></style>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
</head>
<body>
    <div class="top">
        <h1>
            Search Keyword : ${keyword}
        </h1>
        <p class="wrap-message"><i>${message}</i></p>
    </div>
    <c:forEach var="p" items="${list}">
    <div class="bottom">
        <div class="box">
        <div>
        <label>Full Name :</label>
            <h2>${p.firstName} ${p.lastName}</h2>
            </div>
            <div>
            <label>GitHub Account :</label>
            <p class="price">${p.github_account}</p>
            </div>
            <button class="btn">
            <i class="fas fa-info"></i> Details
            </button>
        </div>
        </c:forEach>
        

    </div>
</body>
</html>
