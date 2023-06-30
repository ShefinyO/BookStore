<%@page import="com.ab.models.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Login.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache , no-store, must-revalidate");
		Customer c = (Customer)session.getAttribute("customer");
		if(c != null){
			response.sendRedirect("Home.jsp");
		
		}
	%>
	
	<div class = "col1">
		<img class="cover" alt="book" src="book.svg.svg">
	</div>
	<div class = "col2">
		<div class="innerCol2">
			<form class = "loginForm" action="http://localhost:8080/Book_store/LoginServlet" method="POST">
			<h2 style="padding-top:2rem;">Login</h2>
				<div class = "comp1">
					<label for ="email">Email</label>
					<input class = "inputStyle" type="text" name="email">
				</div>
				<div class = "comp2">
					<label for ="password">Password</label>
					<input class = "inputStyle" type="password" name="password">
					<input class="myButton" type="submit" value="Login">
				</div>
				<a href="Register.jsp" >not registered yet? Click here to register!</a>
			</form>
		</div>
	</div>
</body>
</html>