887<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
		String msg = (String) request.getAttribute("msg");
	%>
	<%
		if (msg != null) {
	%>
	<font color="red"><%=msg%></font>
	<%
		}
	%>
	<form action="LoginCtlPract" method="post">
	<table>


		<tr>
			<th>LoginId</th>
			<td><input type="text" name="LoginId"></td>
		</tr>

		<tr>
			<th>Password</th>
			<td><input type="Password" name="Password"></td>
		</tr>

		<tr>
			<th></th>
			<td><input type="submit" value="Login"></td>
		</tr>


	</table>
	</form>

</body>
</html>