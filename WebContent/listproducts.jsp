<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(Admin)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h4><a href="newItem">AddNewPRODUCTS</a></h4>
<h5><a href= "logout"> LOGOUT</a></h5>

<hr/>

<h3>Items</h3>
	
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
					
					<td>
						
						<a href="editItem?action=editproduct&id=${item.id }">EDIT</a> <span>|</span>
					
						
					</td>
				</tr>				
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>