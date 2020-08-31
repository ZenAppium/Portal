<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-My Kit(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<%-- Required View Template --%>

<h3>New User</h3>
	
	<form action='placeorder' method="POST">
	
		<div>
			<label>Address: </label>
			<input type="text"  value="${coronakit.deliveryAddress }" name="deliveryAddress" size="=100" minlength="3" maxlength="450" required/>
		</div>
		
		<button>Place Order</button>	
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>