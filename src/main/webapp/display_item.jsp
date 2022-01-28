<%@page import="com.ty.hospital.dto.Item"%>
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
	List<Item> items = (List<Item>) request.getAttribute("items");
	%>
	<div style="padding: 50px;">
		<table id="customers">
			<tr>
				<th>ID</th>
				<th>Name of Item</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Message</th>
			</tr>
			</div>
			<div>
				<%
				for (Item item : items) {
				%>

				<tr>
					<td><%=item.getId()%></td>
					<td><%=item.getName()%></td>
					<td><%=item.getPrice()%></td>
					<td><%=item.getQuantity()%></td>
					<td><%=item.getMessage()%></td>
					
					<%
					}
					%>
				
			</div>
		</table>
</body>
</html>