<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personal Information</title>
</head>
<body>
	<form action="PreferenceHandlerServlet" method="post">
		<table>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="name" value="<%= session.getAttribute("u1.name") %>" required="required" /></td>
			</tr>

			<tr>
				<td>Email Address: </td>
				<td><input type="email" name="mail" value="<%= session.getAttribute("u1.mail") %>" required="required" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Next"/></td>
			</tr>
		</table>
	</form>
</body>
</html>