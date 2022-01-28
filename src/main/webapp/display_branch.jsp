<%@page import="com.ty.hospital.dto.Branch"%>
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
	<%@ include file="admin_navbar.jsp"%>
	<%
	List<Branch> branchs = (List<Branch>) request.getAttribute("branchs");
	%>
	<div style="padding: 50px;">
		<table id="customers">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
			</tr>
			</div>
			<div>
				<%
				for (Branch branch : branchs) {
				%>

				<tr>
					<td><%=branch.getId()%></td>
					<td><%=branch.getName()%></td>
					<td><%=branch.getEmail()%></td>
					
					<td><a
						href="create_address.jsp?branchId=<%=branch.getId()%>">Create Adress</a></td>

					<%
					}
					%>
				
			</div>
		</table>
</body>
</html>