<%@ page  language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%	
		String fname = (String) request.getAttribute("fname");
	%>
	<%if(fname != null){ %>
	<h3>Hiii,<%=fname%></h3>
	<a href="UserListCtlPract">UserList</a>
	<%} else{%>
	<h3>Hiii,Guest</h3>
	<%} %>
	<hr>
</body>
</html>