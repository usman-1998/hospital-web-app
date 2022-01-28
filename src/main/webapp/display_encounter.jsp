<%@page import="com.ty.hospital.dto.Encounter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
#customers {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #859CB2
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #476C8F;
	color: white;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="staff_navbar.jsp"%>
	<%
	List<Encounter> encounters = (List<Encounter>) request.getAttribute("encounters");
	%>
	<div style="padding: 50px;">
		<table id="customers">
			<tr>
				<th>ID</th>
				<th>Date and Time</th>
				<th>Reason for Admit</th>
				<th>Create Name</th>
				<th>Create Order</th>
				<th>View Order</th>
			</tr>
			</div>
			<div>
				<%
				for (Encounter encounter : encounters) {
				%>

				<tr>
					<td><%=encounter.getId()%></td>
					<td><%=encounter.getDate()%></td>
					<td><%=encounter.getReason()%></td>
					<td><%=encounter.getCreatorName()%></td>
					<td><a
						href="create_order.jsp?encounterId=<%=encounter.getId()%>">Create</a></td>
					<td><a
						href="displayorder?encounterId=<%=encounter.getId()%>">View</a></td>
					<%
					}
					%>
				
			</div>
		</table>
</body>
</html>