<%@page import="in.co.rays.bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
		<%@ include file="Header.jsp"%>


		<%
			List list = (List) request.getAttribute("list");
			Iterator it = list.iterator();
		%>

		<table border="1">
		
			<tr>
				<th>Id</th>
				<th>firstName</th>
				<th>lastName</th>
				<th>loginId</th>
				<th>password</th>
				<th>address</th>
				<th>edit</th>
			<tr />

			<%
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
			%>
			<tr>
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getPassword()%></td>
				<td><%=bean.getAddress()%></td>
				<td><a href="UserCtl.do?Id=<%=bean.getId()%>"> edit</a></td>
			</tr>
			<%
				}
			%>

		</table>

	</form>
</body>
</html>