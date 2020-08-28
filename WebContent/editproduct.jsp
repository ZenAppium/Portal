<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Form</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	
	<h3>${item.id==null?"New Item":"Edit Item" }</h3>
	
	<form action='${item.id==null?"addItem":"saveItem" }' method="POST">
		<div>
			<label>ID: </label>
			<input type="number" value="${item.id }" name="id" required 
			 ${item.id==null?"":"readonly" } />
		</div>
		<div>
			<label>ProductName: </label>
			<input type="text" value="${item.productName }" name="productName" minlength="3" maxlength="450" required />
		</div>
		
			<div>
			<label>Cost Price: </label>
			<input type="decimal" value="${item.cost }" name="cost" required />
		</div>
		
		<div>
			<label>ProductDescription: </label>
			<input type="text" value="${item.productDescription }" name="productDescription" minlength="3" maxlength="1000" required />
		</div>
		
		<button>SAVE</button>		
	</form>
</body>
</html>