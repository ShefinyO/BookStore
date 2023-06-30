<%@page import="com.ab.models.Customer"%>
<%@page import="com.ab.models.Book"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href="EditProfile.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache , no-store, must-revalidate");
		Customer c = (Customer)session.getAttribute("customer");
		if(c == null){
			response.sendRedirect("Home.jsp");
		
		}
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
	
	<div style="margin-left: 2rem;">
		<h2>Edit Your details</h2>
	</div>
	<div class="userContM">
		<div class="userCont">
			<div class="userColOne">
				<div class="firstName com">First name:</div>
				<div class="lastName com">Last Name:</div>
				<div class="email com">Email:</div>
				<div class="password com">Password:</div>
				<div class="mobileNo com">Mobile number:</div>
			</div>
			<form class="userColTwo" action="http://localhost:8080/Book_store/EditProfileServlet" method="POST">
				<div class="firstNameCont inpCom"><input class="inpS" type="text" name="firstName" ></div>
				<div class="lastNameCont inpCom"><input class="inpS" type="text" name="lastName" ></div>
				<div class="emailCont inpCom"><input class="inpS" type="text" name="email" ></div>
				<div class="password inpCom"><input class="inpS" type="password" name="password" ></div>
				<div class="mobileNoCont inpCom"><input class="inpS" type="text" name="mobileNo" ></div>
				<div><input class="button-26" type="submit" value="Save"></div>
			</form>
		</div>
		
	</div>
	
</body>
</html>