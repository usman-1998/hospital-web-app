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
	String name = (String) session.getAttribute("name");
	String role = (String) session.getAttribute("role");
	if(name == null || role == null){
		%><h1>staff1</h1><%
		response.sendRedirect("login.jsp");
	}
	if(role!=null & !role.equals("staff")){
		%><h1>staff2</h1><%
		response.sendRedirect("login.jsp");
	}
	%>
	<%@ include file="staff_navbar.jsp" %>
</body>
</html>