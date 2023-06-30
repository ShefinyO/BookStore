
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href="OrderHistory.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/6626a18887.js" crossorigin="anonymous"></script>
</head>
<body>
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
	
	<div style="padding: 0 2rem;">
		<h2>Order History</h2>
	</div>
	<div class="ordersMain">
		<div class = "ordersComp">
			<div class="orderID">
				<div class="text b">Order ID</div>
			</div>
			<div class="date">
				<div class="text b">Order date</div>
			</div>
			<div class="paid">
				<div class="text b">Paid</div>
			</div>
			<div class="orderItms">
				<div class="text b">Items</div>
			</div>
		</div>
		<c:forEach var="order" items="${ordersList}">
			<div class="contentCont">
				<div class="IDContent">
					<div class="text">#${order.getOrderId()}</div>
				</div>
				<div class="dateContent">
					<div class="text">${order.getOrderDate()}</div>
				</div>
				<div class="paidContent">
					<div class="text">${order.getTotalPrice()}£</div>
				</div>
				<div class="orderItmsContent">
					<c:forEach var="item" items="${order.getBooks()}">
						<div class="text">${item.key.getBookName()}X ${item.value}</div>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
		
	</div>
	

</body>
</html>