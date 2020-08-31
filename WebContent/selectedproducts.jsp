<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>
<jsp:include page="header.jsp"/>


<hr/>

<h2>Items</h2>
	<form action='addaddress' method="POST">
	<c:choose>
		<c:when test="${items==null || items.isEmpty() }">
			<p>No Items Found</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>ProductID</th>
					<th>ProductName</th>
					<th>ProductCost</th>
					<th>ProductDescription</th>
					</tr>
				<c:forEach items="${items }" var="item">
					<tr>
					<td>${item.id }</td>
					<td>${item.productName }</td>
					<td>${item.cost }</td>
					<td>${item.productDescription }</td>
					
				</tr>				
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
		<div>
			<label>Qty: </label>
			<input type="number" value="${coronakit.quantity }" name="quantity" minlength="1" maxlength="10" size="2" required />
		</div>
<button>Proceed</button>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>