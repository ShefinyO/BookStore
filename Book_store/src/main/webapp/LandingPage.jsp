<%@page import="com.ab.models.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="LandingPage.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

	response.setHeader("Cache-Control", "no-cache , no-store, must-revalidate");
	
%>
	<div class="ma">
		<div class = "navContainer">
			<h2 style="padding-left:2rem;">The Book Store</h2>
			<ul class="navList">
				<li><a style="text-decoration:none" href="http://localhost:8080/Book_store/HomeServlet">Home</a></li>
				<c:if test="${customer == null}">
					<li><a style="text-decoration:none" href="Login.jsp">Login</a></li>
					<li><a style="text-decoration:none" href="Register.jsp">Register</a></li>
				</c:if>
			</ul>
		</div>
		<div class="dialog">
			<div style="color:white;font-weight: 20px;font-size:2rem;">Change your life with Books</div>
			<div style="color:white;font-weight: 15px;font-size:1.5rem;">A place that has it all!</div>
			<div style="color:white;font-weight: 10px;font-size:1rem;">All you need under one roof</div>
			<a href = "http://localhost:8080/Book_store/HomeServlet"><button class="button-85" role="button">Shop Now</button></a>
		</div>
	</div>
</body>
</html>