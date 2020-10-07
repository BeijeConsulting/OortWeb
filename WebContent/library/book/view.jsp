<%@page import="it.beije.oort.web.bassanelli.library_application.User"%>
<%@page import="it.beije.oort.web.bassanelli.library_application.Book"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="it.beije.oort.web.bassanelli.phonebook_application.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Application</title>
</head>
<body>

	<h3>Library Application</h3>

	<jsp:useBean id="user" class="it.beije.oort.web.bassanelli.library_application.User" scope="session"></jsp:useBean>
	<jsp:useBean id="type" class="java.lang.String" scope="session"></jsp:useBean>
	<jsp:useBean id="book" class="it.beije.oort.web.bassanelli.library_application.Book" scope="session"></jsp:useBean>
	
	<%
	
	List<Book> books = (List<Book>)session.getAttribute("books");
	
	if(user.getEmail() != null && user.getPassword() != null) {
		
		if(user.getAdmin()) {
			%>
			
			<% 
		} else {
			%>
			
			<fieldset>
	
				<legend><b>View books</b></legend>
		
				<form method="GET" action="./view-book">
		
					<input type="radio" name="radioValue" value="all" checked="checked"/>
					<label>All</label><br>
			
					<input type="radio" name="radioValue" value="id"/>
					<label>ID</label><br>
			
					<input type="radio" name="radioValue" value="title"/>
					<label>Title</label><br>
			
					<input type="radio" name="radioValue" value="description"/>
					<label>Description</label><br>
			
					<input type="radio" name="radioValue" value="year"/>
					<label>Year</label><br>
			
					<label>Filter: </label>
					<input type="text" name="filter"/><br>
			
					<input type="submit" value="SEARCH"/>
			
				</form>
		
			</fieldset>
			
			<%
			
			if(type != null){
				
				switch(type) {
				
				case "single":
					%>
					
					<p><% out.print(book.toString("ID;TITLE;DESCRIPTION;YEAR")); %></p>
					
					<%
					break;
					
				case "multiple":
					
					for(int i = 0; books != null && i < books.size(); i++) {
						%>
						
						<p><% out.print(books.get(i).toString("ID;TITLE;DESCRIPTION;YEAR")); %></p>
						
						<%
					}
					break;
				}
			}
		}
	} else {
		%>
		
		<p>Login request!</p>
		
		<%
	}
	
	%>

	<a href="../index.jsp">Back</a>

</body>
</html>