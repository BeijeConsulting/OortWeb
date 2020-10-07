<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.oort.bm.library.Author" %>
<%@ page import="it.beije.oort.bm.library.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
	<body>
		<%User u_ascope = (User)session.getAttribute("user"); 
			if(u_ascope == null){%>
				Please login first.
			<%} else { %>
				<table>
						<tr>
							<th>Id</th>
							<th>Surname</th>
							<th>Name</th>
							<th>Date of birth</th>
							<th>Date of death</th>
							<th>Biography</th>
						</tr>
						<%for(Author a : (List<Author>)session.getAttribute("data_list")){%>
							<tr>
								<td><%= a.getId() %></td>
								<td><%= a.getSurname() %> </td>
								<td><%= a.getName() %></td>
								<td><%= a.getDate_of_birth() %></td>
								<td><%= a.getDate_of_death() %></td>
								<td><%= a.getBiography() %></td>
							</tr>
						<%} %>
				</table>
			<%} %>
	</body>
</html>