<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.oort.bm.library.User" %>
<%@ page import="it.beije.oort.bm.library.Book" %>
<%@ page import="it.beije.oort.bm.library.Author" %>
<%@ page import="it.beije.oort.bm.library.Publisher" %>
<%@ page import="java.util.List" %>
<%@ page import="it.beije.oort.bm.library.database.*" %>
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
				<% Database db = ConcreteDatabase.getDatabase(); 
				List<Book> list = db.getAll(Book.class);
				for(Book b : list){%>
					<tr>
						<td><%= b.getId() %></td>
						<td><%= b.getTitle() %> </td>
						<% Author a = new Author();
						a.setId(b.getAuthor());
						a = db.searchRecord(Author.class, a).get(0);
						String author_name = a.getName() + " " + a.getSurname();%>
						<td><%= author_name %></td>
						<% Publisher p = new Publisher();
						p.setId(b.getPublisher());
						p = db.searchRecord(Publisher.class, p).get(0);%>
						<td><%= p.getName() %></td>
						<td><%= b.getYear() %></td>
						<td><%= b.getDescription() %></td>
					</tr>
				<%} %>
		</table>
	<%} %>
</body>
</html>