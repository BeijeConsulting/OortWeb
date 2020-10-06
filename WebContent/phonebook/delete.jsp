<%@page import="it.beije.oort.web.bassanelli.phonebook_application.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phonebook application</title>
</head>
<body>

	<fieldset>
	
		<legend><b>Delete contact</b></legend>
		
		<form method="GET" action="./search-by-id">
		
			<label>ID: </label>
			<input type="text" name="id"/><br>
			<input type="hidden" name="type" value="delete" />
			
			<input type="submit" value="SEARCH"/>
		
		</form>
		
		
		<form method="POST" action="./delete-contact">
		
		<jsp:useBean id="searchContact" class="it.beije.oort.web.bassanelli.phonebook_application.Contact" scope="session"></jsp:useBean>
		<jsp:setProperty property="name" name="searchContact"/>
		<jsp:setProperty property="surname" name="searchContact"/>
		<jsp:setProperty property="mobile" name="searchContact"/>
		<jsp:setProperty property="email" name="searchContact"/>
		
		<%
		
		// Contact contact = (Contact)session.getAttribute("searchContact");
		
		if(searchContact != null) {
			%>
			
			<label>ID: <%= searchContact.getId() %> </label><br>
			<input type="hidden" name="id" value=<jsp:getProperty property="id" name="searchContact"/>>
			<label>Name: <%= searchContact.getName() %> </label><br>
			<label>Surname: <%= searchContact.getSurname() %> </label><br>
			<label>Mobile: <%= searchContact.getMobile() %> </label><br>
			<label>Email: <%= searchContact.getEmail() %> </label><br>
			
			<%
			
			session.setAttribute("searchContact", null);
			
		} 
		%>
		
			<input type="submit" value="DELETE"/>
		
		</form>
		
	</fieldset>
	
	<a href="./index.jsp">Back</a>

</body>
</html>