<%@page import="com.ab.models.Customer"%>
<%@page import="java.util.Map"%>
<%@page import="com.ab.models.Book"%>
<%@page import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href="Basket.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/6626a18887.js" crossorigin="anonymous"></script>
</head>
<body>
	<%
		
		
		
	%>
	<div class = "navContainer">
		<h2 style="padding-left:2rem;">The Book Store</h2>
		<ul class="navList">
			<c:choose>
			    <c:when test="${customer==null}">
			        <li><a style="text-decoration:none" href="Login.jsp">Login</a></li>
			        <br />
			    </c:when>    
			    <c:otherwise>
			    	<li><a style="text-decoration:none" href="http://localhost:8080/Book_store/ViewOrdersServlet">Orders</a></li>
			    	<li><a style="text-decoration:none" href="Profile.jsp">Profile</a></li>
			        <li><a style="text-decoration:none" href="http://localhost:8080/Book_store/LogoutServlet">Logout</a></li>
			        <br />
			    </c:otherwise>
			</c:choose>
			<li><a style="text-decoration:none" href="http://localhost:8080/Book_store/HomeServlet">Home</a></li>
			<div class="cart"><a class="cartLink" href="Basket.jsp"><i class='fa fa-shopping-cart fa-lg'></i></a></div>
		</ul>
	</div>

	<c:choose>
		<c:when test="${order != null}">
			<div style="text-align: center;">
				<h2>Hi ${customer.getFirstName()}, Your order #${order.getOrderId()} has been placed successfully!!</h2>
			</div>
			<a href="http://localhost:8080/Book_store/HomeServlet">go back to home page!</a>
		</c:when>
		<c:otherwise>
			Order declined!
		</c:otherwise>
	</c:choose>
</body>
</html>