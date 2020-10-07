<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.oort.bm.library.Loan" %>
<%@ page import="it.beije.oort.bm.library.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
		<body>
			<%User u_lscope = (User)session.getAttribute("user"); 
				if(u_lscope == null){%>
					Please login first.
				<%} else { %>
					<table>
							<tr>
								<th>Id</th>
								<th>User</th>
								<th>Book</th>
								<th>Start Date</th>
								<th>End Date</th>
								<th>Notes</th>
							</tr>
							<%for(Loan l : (List<Loan>)session.getAttribute("data_list")){%>
								<tr>
									<td><%= l.getId() %></td>
									<td><%= l.getUser().getName() + " " + l.getUser().getSurname() %> </td>
									<td><%= l.getBook().getTitle() %></td>	
									<td><%= l.getStart_date() %></td>
									<td><%= l.getEnd_date() %> </td>
									<td><%= l.getNotes() %></td>		
								</tr>
							<%} %>
					</table>
				<%} %>
		</body>
</html>