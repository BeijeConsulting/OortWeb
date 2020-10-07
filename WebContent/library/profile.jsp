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
	<!-- 
	<jsp:setProperty property="email" name="user"/>
	<jsp:setProperty property="password" name="user"/>
	<jsp:setProperty property="name" name="user"/>
	<jsp:setProperty property="surname" name="user"/>
	<jsp:setProperty property="fiscalCode" name="user"/>
	<jsp:setProperty property="email" name="user"/>
	<jsp:setProperty property="mobile" name="user"/>
	<jsp:setProperty property="address" name="user"/>
	<jsp:setProperty property="password" name="user"/>
	<jsp:setProperty property="admin" name="user"/> 
	-->
	
	<%
	
	if(user.getEmail() != null && user.getPassword() != null) {
		
		%>
		
		<p><b>Profile:  <%= user.getName() %> <%= user.getSurname() %> </b></p>
		
		<form method="POST" action="./edit-user">
		
			<!-- <input type="hidden" name="id" value=<jsp:getProperty property="id" name="user"/>><br> -->
			<label>Name: </label>
			<input type="text" name="name" value=<jsp:getProperty property="name" name="user"/>><br>
			<label>Surname: </label> 
			<input type="text" name="surname" value=<jsp:getProperty property="surname" name="user"/>><br>
			<label>Fiscal code: </label> 
			<input type="text" name="fiscal_code" value=<jsp:getProperty property="fiscalCode" name="user"/> disabled><br>
			<label>Mobile: </label> 
			<input type="text" name="mobile" value=<jsp:getProperty property="mobile" name="user"/>><br>
			<label>Email: </label> 
			<input type="text" name="email" value=<jsp:getProperty property="email" name="user"/> disabled><br>
			<label>Address: </label> 
			<input type="text" name="address" value=<jsp:getProperty property="address" name="user"/>><br>
			<label>Password: </label> 
			<input type="text" name="password" value=<jsp:getProperty property="password" name="user"/>><br>
			<label>Admin: <%= user.getAdmin() ? "Yes" : "No" %></label><br>

		<input type="submit" value="EDIT"/>
		
		</form>
		
		<form method="GET" action="./exit-user">
			<input type="submit" value="LOGOUT"/>
		</form>
			
		<%
	} else {
		%>
		
		<p>Login request!</p>
		
		<%
	}
	
	%>
	
	
	
	<a href="./index.jsp">Back</a>

</body>
</html>