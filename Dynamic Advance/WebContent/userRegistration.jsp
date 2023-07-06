<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UserCtl" method="post">
		<table>

			<tr>
				<th>First Name:</th>
				<td><input type="text" name="FirstName"></td>
			</tr>

			<tr>
				<th>Last Name:</th>
				<td><input type="text" name="LastName"></td>
			</tr>


			<tr>
				<th>LoginId:</th>
				<td><input type="text" name="LoginId"></td>
			</tr>


			<tr>
				<th>Password:</th>
				<td><input type="Password" name="Password"></td>
			</tr>


			<tr>
				<th>Address:</th>
				<td><input type="Address" name="Address"></td>
			</tr>


			<tr>
				<th></th>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>