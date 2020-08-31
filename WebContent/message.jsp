
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<html>
	<head>
		<title>Corona Portal - Home</title>
	</head>
	<body>
		<jsp:include page="header.jsp" />
		<a href="list">Items List</a>
		<c:if test="${msg != null}">
			<p><strong>${msg }</strong>
		</c:if>
	</body>
</html>