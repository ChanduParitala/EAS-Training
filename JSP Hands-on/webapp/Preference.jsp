<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NewsLetter Preference</title>
</head>
<body>
	<form action="PersonalInformation.jsp" autocomplete="on" method="post">
		<table>
			<tr>
				<td>Include Promos & offers :</td>
				<!-- unable to store this, toggling is not possible. -->
				<td><input type="checkbox" name="pref" value="Yes" /></td></tr>
				<tr>
				<td><input type="submit" value="Back" /></td>
			</tr>
		</table>
	</form>
</body>
</html>