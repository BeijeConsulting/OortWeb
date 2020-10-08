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
					<%}%>
			</table>
		<%} 
		if(u_bscope.isAdmin()){%>
			<form action="./insertService" method="post">
				<label for="ins_title">Title: </label><input type="text" name="ins_title"><br>
				<label for="ins_author">Author: </label><select name="ins_author">
					<%for(Author a : (List<Author>)session.getAttribute("authors")){%>
						<option value="<%=a.getId()%>"><%=a.getName() + " " + a.getSurname()%></option>
					<%} %>
				</select><br>
				<label for="ins_publisher">Publisher: </label><select name="ins_publisher">
					<%for(Publisher p : (List<Publisher>)session.getAttribute("publishers")){%>
							<option value="<%=p.getId()%>"><%=p.getName()%></option>
					<%} %>
				</select><br>
				<label for="ins_year">Year: </label><input type="text" name="ins_year"><br>
				<label for="ins_descr">Description: </label><input type="text" name="ins_descr"><br>
				<input type="submit" value="Add Book">
			</form>
			<form action="./deleteService" method="post">
				<label for="del_id">Id: </label><select name="del_id">
					<%for(Book b_id : (List<Book>)session.getAttribute("data_list")){%>
							<option value="<%=b_id.getId()%>"><%=b_id.getId() + " " + b_id.getTitle()%></option>
					<%} %>
				</select><br>
				<input type="submit" value="Remove Book">
			</form>
		<%} 
		session.removeAttribute("authors");
		session.removeAttribute("publishers");
		session.removeAttribute("data_list");
		%>
	</body>
</html>