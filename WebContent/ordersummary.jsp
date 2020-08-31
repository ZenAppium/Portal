<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Order Summary(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<h3>Corona Kit-Order Summary</h3>

<%-- Required View Template --%>
		<div>
			<label>Name: </label>
			<label>${coronakit.personName }</label>
		</div>
		</br>
		<div>
			<label>Email: </label>
			<label>${coronakit.email }</label>
		</div>
		</br>
		<div>
			<label>Contact Number: </label>
			<label>${coronakit.contactNumber }</label>
		</div>
		</br>
		<div>
			<label>Total Amount: </label>
			<label>${coronakit.totalAmount }</label>
		</div>
		</br>
		<div>
			<label>Address: </label>
			<label>${coronakit.deliveryAddress }</label>
		</div>
		</br>
		<div>
			<label>Order Date and time: </label>
			<label>${coronakit.orderDate }</label>
		</div>
		</br>
		<div>
			<label>Quantity </label>
			<label>${coronakit.quantity }</label>
		</div>
		
		
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>