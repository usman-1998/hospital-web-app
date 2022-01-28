<%@page import="com.ty.hospital.dto.Hospital"%>
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
	List<Hospital> hospitals = (List<Hospital>) request.getAttribute("hospitals");
	%>
	<div style="padding: 50px;">
		<table id="customers">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Website</th>
				<th>Gst Number</th>
				<th>Create Branch</th>
				<th>View Branch</th>
			</tr>
			</div>
			<div>
				<%
				for (Hospital hospital : hospitals) {
				%>

				<tr>
					<td><%=hospital.getId()%></td>
					<td><%=hospital.getName()%></td>
					<td><%=hospital.getWebsite()%></td>
					<td><%=hospital.getGst()%></td>
					<td><a
						href="create_branch.jsp?hospitalId=<%=hospital.getId()%>">Create</a></td>
					<td><a
						href="getallbranch?hospitalId=<%=hospital.getId()%>">View</a></td>
					<%
					}
					%>
				
			</div>
		</table>
</body>
</html>