<%@page import="com.ab.models.Customer"%>
<%@page import="com.ab.models.Book"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel = "stylesheet" href="Basket.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/6626a18887.js" crossorigin="anonymous"></script>
</head>

<body>
	<%
		response.setHeader("Cache-Control", "no-cache , no-store, must-revalidate");
		
		Map<Book, Integer> bas = (HashMap<Book, Integer>)session.getAttribute("basket");
	
		Double total = 0.0;
		
		if(bas!=null){
			for(Map.Entry<Book, Integer> set: bas.entrySet()){
				total = total + Double.parseDouble(set.getKey().getPrice()) * set.getValue();
			}
		}
		
		BigDecimal bd = new BigDecimal(Double.toString(total));
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    total = bd.doubleValue();
	    String newTotal = total.toString();
		
		
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
	
	<div style="text-align: center;">
			<h1>SHOPPING CART</h1>
	</div>
	<c:choose>
		<c:when test="${basket != null}">
			<div class="btnCont">
				<div class="check">
					<a href="http://localhost:8080/Book_store/PlaceOrderServlet?total=<%=newTotal%>" class="myButt">Checkout  <%=newTotal %>£</a>
				</div>
			</div>
			<div class="cartContainer">
				<div class="topRow">
					<div class="ch1">Product</div>
					<div class="agg">
						<div class="ch pr">Price</div>
						<div class="ch">Quantity</div>
						<div class="ch">Total</div>
					</div>
				</div>
				<c:forEach var="item" items="${basket}">
				<div class="productRow">
					<div class="part1">
						<div class="remove"><a style="text-decoration:none; color:black;" href="http://localhost:8080/Book_store/RemoveFromBasketServlet?bookId=${item.key.getBookId()}"><i class="fa fa-times"></i></a></div>
						<div class="pImage"><img alt="image" src="${item.key.getImage()}.jpg" style="position:absolute; height:100%; width:100%;"></div>
						<div class="desc">${item.key.getBookName()}</div>
					</div>
					<div class="part2">
						<div class="pValue v">${item.key.getPrice()}£</div>
						<div class="qValue v">${item.value}</div>
						<div class="tValue v">${item.key.getPrice()*item.value}</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</c:when>
		<c:otherwise>
			<div style="text-align: center;">
				<h1>You cart is Empty! Add Books to your basket to checkout..</h1>
			</div>
		</c:otherwise>
	</c:choose>
	
</body>
</html>