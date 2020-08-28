<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Add New Product(Admin)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<h3>${(item.id==null || item.id==0)?"New Item":"Edit Item" }</h3>
	
	<form action='${(item.id==null || item.id==0) ?"addItem":"saveItem" }' method="POST">
	
		<div>
			<label>ID: </label>
			<input type="number" value="${item.id }" name="id" required />
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

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>