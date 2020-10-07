<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.oort.bm.library.User" %>
<%@ page import="it.beije.oort.bm.library.Book" %>
<%@ page import="it.beije.oort.bm.library.Author" %>
<%@ page import="it.beije.oort.bm.library.Publisher" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<%User u_bscope = (User)session.getAttribute("user"); 
		if(u_bscope == null){%>
			Please login first.
		<%} else { %>
			<table>
					<tr>
						<th>Id</th>
						<th>Title</th>
						<th>Author</th>
						<th>Publisher</th>
						<th>Year</th>
						<th>Description</th>
					</tr>
					<% for(Book b : (List<Book>)session.getAttribute("data_list")){%> 
						<tr>
							<td><%= b.getId() %></td>
							<td><%= b.getTitle() %> </td>
							<td><%= b.getAuthor().getName() + " " + b.getAuthor().getSurname() %></td>
							<td><%= b.getPublisher().getName() %></td>
							<td><%= b.getYear() %></td>
							<td><%= b.getDescription() %></td>
						</tr>
					<%} 
					session.removeAttribute("data_list");%>
			</table>
		<%} %>
	</body>
</html>