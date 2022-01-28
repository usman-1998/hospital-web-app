<%@page import="com.ty.hospital.dto.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="staff_navbar.jsp"%>
	<%
	List<Person> persons = (List<Person>) request.getAttribute("persons");
	%>
	<div style="padding: 50px;">
		<table id="customers">
			<tr>
			<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Gender</th>
				<th>Age</th>
				<th>Create Encounter</th>
				<th>View Encounter</th>
			</tr>
			</div>
			<div>
			<%
			for (Person person : persons) {
			%>

			<tr>
				<td><%=person.getId()%></td>
				<td><%=person.getName()%></td>
				<td><%=person.getEmail()%></td>
				<td><%=person.getPhone()%></td>
				<td><%=person.getGender()%></td>
				<td><%=person.getAge()%></td>
				<td><a href="create_encounter.jsp?personId=<%=person.getId()%>">Create</a></td>
				<td><a href="displayencounters?personId=<%=person.getId()%>">View</a></td>
				<%
				}
				%>
			</div>
		</table>
</body>
</html>