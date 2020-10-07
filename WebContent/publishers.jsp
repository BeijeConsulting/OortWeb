<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.oort.bm.library.User" %>
<%@ page import="it.beije.oort.bm.library.Publisher" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
			<%User u_pscope = (User)session.getAttribute("user"); 
				if(u_pscope == null){%>
					Please login first.
				<%} else { %>
					<table>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Description</th>
							</tr>
							<%for(Publisher p : (List<Publisher>)session.getAttribute("data_list")){%>
								<tr>
									<td><%= p.getId() %></td>
									<td><%= p.getName() %> </td>
									<td><%= p.getDescription() %></td>		
								</tr>
							<%} %>
					</table>
				<%} 
				session.removeAttribute("data_list");%>
		</body>
</html>