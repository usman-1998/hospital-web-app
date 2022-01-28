<%@page import="com.ty.hospital.dto.MedOrder"%>
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
	List<MedOrder> medOrders = (List<MedOrder>) request.getAttribute("medOrders");
	%>
	<div style="padding: 50px;">
		<table id="customers">
			<tr>
				<th>ID</th>
				<th>Date and Time</th>
				<th>Message</th>
				<th>Create Name</th>
				<th>Create Item</th>
				<th>View Iem</th>
			</tr>
			</div>
			<div>
				<%
				for (MedOrder medOrder : medOrders) {
				%>

				<tr>
					<td><%=medOrder.getId()%></td>
					<td><%=medOrder.getCreateDateTime()%></td>
					<td><%=medOrder.getMessage()%></td>
					<td><%=medOrder.getCreatorName()%></td>
					<td><a
						href="create_item.jsp?medOrderId=<%=medOrder.getId()%>">Create</a></td>
					<td><a
						href="displayitem?medOrderId=<%=medOrder.getId()%>">View</a></td>
					<%
					}
					%>
				
			</div>
		</table>
</body>
</html>