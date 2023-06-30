<%@page import="com.ab.models.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Register.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache , no-store, must-revalidate");
		Customer c = (Customer)session.getAttribute("customer");
		if(c != null){
			response.sendRedirect("HomeLoggedIn.jsp");
		
		}
	%>
	
	
	<div class = "col1">
		<img class = "cover" alt="signup" src="signup.svg.svg">
	</div>
	<div class = "col2">
		<form class="registerForm" action="http://localhost:8080/Book_store/RegisterServlet" method = "POST">
		<h2>Register Here</h2>
			<div class="inp inpOne">
				<label for = "firstName">FirstName</label>
				<input class = "inputStyle" type="text" name="firstName">
			</div>
			<div class="inp inpTwo">
				<label for = "lastName">LastName</label>
				<input class = "inputStyle" type="text" name="lastName">
			</div>
			<div class="inp inpThree">
				<label for = "email">Email</label>
				<input class = "inputStyle" type="text" name="email">
			</div>
			<div class="inp inpFour">
				<label for = "password">Password</label>
				<input class = "inputStyle" type="password" name="password">
				<input class="myButton" type = "submit" value="Register">
			</div>
		</form>
	</div>
</body>
</html>