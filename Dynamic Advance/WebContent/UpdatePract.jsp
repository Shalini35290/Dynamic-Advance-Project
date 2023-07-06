<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		UserBean bean = (UserBean) request.getAttribute("Bean");
	%>
	
	<form action="UserCtlPract" method="post">
		<td><input type="hidden" name="id" value=<%=bean.getId()%>></td>
		<table>
			<tr>
				<th>First Name:</th>
				<td><input type="text" name="FirstName"
				value="<%=bean.getFirstName() %>"></td>
			</tr>

			<tr>
				<th>Last Name:</th>
				<td><input type="text" name="LastName"
				value="<%=bean.getLastName() %>"></td>
			</tr>


			<tr>
				<th>LoginId:</th>
				<td><input type="text" name="LoginId"
				value="<%=bean.getLoginId() %>"></td>
			</tr>


			<tr>
				<th>Password:</th>
				<td><input type=text name="Password"
				value="<%=bean.getPassword() %>"></td>
			</tr>


			<tr>
				<th>Address:</th>
				<td><input type="text" name="Address"
				value="<%=bean.getAddress() %>"></td>
			</tr>

			<tr>
				<th></th>
				<td><input type="submit" name="Operation" value="Update"></td>
			</tr>
		</table>

	</form>
	

</body>
</html>