<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>

<body>
	<form action="DisplayDetailsServlet" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id" /><br /></td></tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /><br /></td></tr>
			<tr>
				<td>Gender:</td>
				<td>Male <input type="radio" name="r" value="male"/><br /></td>
				<td>Female <input type="radio" name="r" value="female"/><br /></td>
				</tr>
					
				<tr>
				<td>Date Of Birth:</td>
				<td><input type="date" name="dob" /><br /></td></tr>	
				
				<tr>
				<td>Fulltime Employee:</td>
				<td><input type="checkbox" name="fte" value="yes"/></td>
				</tr>
					
				<tr>
				<td>Department:</td>
				<!-- how to do c:forEach??? -->
				<td><select name="department">
				<option value="IT">IT</option>
				<option value="ECE">ECE</option>
				<option value="EEE">EEE</option>
				<option value="CSE">CSE</option>
				<option value="Mech">Mech</option>
				</td>
				
				<tr>
				<td>Salary:</td>
				<td><input type="number" name="sal" /><br /></td></tr>	
				<tr>
				
				<tr>
				<td><input type="submit" value="submit" /><br /></td></tr>
				
		</table>
	</form>
</body>
</html>