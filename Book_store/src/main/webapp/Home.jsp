<%@page import="com.ab.models.Customer"%>
<%@page import="com.ab.models.Book"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel = "stylesheet" href="Home.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div class = "navContainer">
		<h2 style="padding-left:2rem;">The Book Store</h2>
		<form class="m" action="http://localhost:8080/Book_store/SearchBooksServlet" method="POST">
			<input class="inpSs" type="text" name="searchBar" placeholder="Search..">
			<input type="submit" style="visibility: hidden;">
		</form>
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
			
			<div class="cart"><a class="cartLink" href="Basket.jsp"><i class='fa fa-shopping-cart fa-lg'></i></a></div>
		</ul>
	</div>
	<c:choose>
	<c:when test="${!allBooks.isEmpty()}">
	<div class="container">
	
		<c:forEach var = "book" items = "${allBooks}">
			<div class="item">
				<div class="top">
				
				<a href="http://localhost:8080/Book_store/BookPageServlet?bookId=${book.getBookId()}"><img alt="image" src="${book.getImage()}.jpg" style="position:absolute; height: 100%; width: 100%; cursor:pointer;"></a>
				
				</div>
				<div class="bottom">
					<div style="font-weight: bold; font-size:1.1rem;" class="one">${book.getBookName()}</div>
					<div class="two">${book.getAuthor()}</div>
					<div class="three">${book.getCategory()}</div>
					<div class = "four">${book.getPrice()}£</div>
				</div>
			</div>
		</c:forEach>
	</div>
	</c:when>
	<c:otherwise>
		<div style="text-align: center;">
			<h2>No Matches found</h2>
			<p class="lin"><a style = "color: blue;" href="http://localhost:8080/Book_store/HomeServlet">Click here to view all books</a></p>
		</div>
	</c:otherwise>
	</c:choose>
	
</body>
</html>