<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Corona Kit-Add User Details</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<h3>New User</h3>
	
	<form action='showproducts' method="POST">
	
		<div>
			<label>User Name: </label>
			<input type="text" value="${coronakit.personName }" name="personName" minlength="3" maxlength="450" required />
		</div>
		
			<div>
			<label>Contact Number: </label>
			<input type="text" value="${coronakit.contactNumber }" name="contactNumber" required />
		</div>
		
		<div>
			<label>Email Address: </label>
			<input type="text" value="${coronakit.email }" name="email" minlength="3" maxlength="1000" required />
		</div>
		
		<button>Save and Add Products</button>		

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>