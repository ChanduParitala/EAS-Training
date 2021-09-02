<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details Verification</title>
</head>
<body>
<h1>Employee Details Verification</h1>
<table>
<tr>
<td><h4>ID:</h4></td>
<td><%
out.write(request.getParameter("id"));
%></td>


<td><h4 style="margin-left: 85px;">Name:</h4></td>
<td><%
out.write(request.getParameter("name"));
%></td>

<td><h4 style="margin-left: 85px;">Gender:</h4></td>
<td><%
out.write(request.getParameter("r"));
%></td></tr>

<tr>
<td><h4>Date Of Birth:</h4></td>
<%-- unable to get thru <fmt:formateDate> coz, unable to get value of LocalDate. --%>
<td><%
out.write(request.getParameter("dob"));
%>
</td>


<td><h4 style="margin-left: 85px;">Fulltime Employee:</h4></td>
<td><%
String n = request.getParameter("fte");
if(n == null)
out.write("No");
else 
	out.write("Yes");
%></td>

<td><h4 style="margin-left: 85px;">Department:</h4></td>
<td><%
out.write(request.getParameter("department"));
%></td></tr>

<tr>
<td><h4>Salary:</h4></td>
<%-- unable to get thru <fmt:formateNumber> coz, unable to get value. --%>
<td>
<c:set var="sal" value="<%= request.getParameter(\"sal\") %>"/>
<fmt:formatNumber type="number" value="${sal}"/>
</td></tr>

</table>

</body>
</html>
