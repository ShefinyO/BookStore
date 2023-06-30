<%@page import="com.ab.models.Customer"%>
<%@page import="com.ab.models.Book"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href="BookPage.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/6626a18887.js" crossorigin="anonymous"></script>
</head>
<body>

	<%
	response.setHeader("Cache-Control", "no-cache , no-store, must-revalidate");
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
	
	<div class = "mainProductContainer">
		
		<div class="colL">
		
			<div class="imgCon">
				<img alt="image" src="${book.getImage()}.jpg" style="position:absolute; height:90%; width:65%; left:90px;">
				
			</div>
		
		</div>
		
		<div class="colR">
			<div class="pName">
				<h2>${book.getBookName()}</h2>
			</div>
			<div class="pPrice" style="font-weight:bold; font-size:1.2rem; ">
				${book.getPrice()}
			</div>
			<div class="pDesc">
				${book.getDescription()}
			</div>
			<div class="pIsbn">
				ISBN: ${book.getIsbn()}
			</div>
			<div class="addTC">
				<a href="http://localhost:8080/Book_store/AddToBasketServlet?bookId=${book.getBookId()}" class="myButton">Add to cart</a>
			</div>
		
		</div>
	
	</div>
	
	
	
	
	
		
</body>
</html>