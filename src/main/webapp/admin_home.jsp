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
	if (name == null || role == null) {
		response.sendRedirect("login.jsp");
	}
	if (role != null & !role.equals("admin")) {
		response.sendRedirect("login.jsp");
	}
	%>
	<%@ include file="admin_navbar.jsp" %>
	
</body>
</html>