<%@page import="it.beije.oort.web.bassanelli.library_application.User"%>
<%@page import="java.util.List"%>
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
	<!--<jsp:setProperty property="email" name="user"/>
	<jsp:setProperty property="password" name="user"/> -->

	<%
	
	if(user.getEmail() != null && user.getPassword() != null) {
		%>
		
		<h5>Hello <%= user.getName() %> <%= user.getSurname() %>, are you admin?  <%= user.getAdmin() ? "Yes" : "No" %> </h5>
		
		<%
		if(user.getAdmin()) {
			%>
			
			<ul>
				<li><a href="./profile.jsp">Profile</a></li>
				<li><a href="./view.jsp">Books</a></li>
				<li><a href="./view.jsp">Authors</a></li>
			</ul>
			
			<%
		} else {
			%>
			
			<ul>
				<li><a href="./profile.jsp">Profile</a></li>
				<li><a href="./book/view.jsp">Books</a></li>
				<li><a href="./author/view.jsp">Authors</a></li>
				<li><a href="./publisher/view.jsp">Publishers</a></li>
				<li><a href="./borrow/view.jsp">Borrows</a></li>
			</ul>
			
			<%
		}
	} else {
		%>
		<fieldset>
		
		<legend><b>Login</b></legend>

		<form method="GET" action="./login-user">

			<label>Email: </label>
			<input type="text" name="email"/><br>
			<label>Password: </label> 
			<input type="password" name="password"/><br>

			<input type="submit" value="LOGIN"/>
			
		</form>
		</fieldset>
		<%
	}
	
	%>


	<a href="../index.jsp">Back</a>

</body>
</html>