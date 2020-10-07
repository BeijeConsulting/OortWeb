<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.oort.bm.library.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
			<%User u_uscope = (User)session.getAttribute("user"); 
				if(u_uscope == null){%>
					Please login first.
				<%} else { %>
					<table>
							<tr>
								<th>Id</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Fiscal Code</th>
								<th>Address</th>
								<th>Phone</th>
								<th>E-mail</th>
							</tr>
							<%for(User u : (List<User>)session.getAttribute("data_list")){%>
								<tr>
									<td><%= u.getId() %></td>
									<td><%= u.getName() %> </td>
									<td><%= u.getSurname() %></td>	
									<td><%= u.getFc() %></td>
									<td><%= u.getAddress() %> </td>
									<td><%= u.getPhone() %></td>
									<td><%= u.getEmail() %></td>	
								</tr>
							<%} %>
					</table>
				<%} 
				session.removeAttribute("data_list");%>
		</body>
</html>