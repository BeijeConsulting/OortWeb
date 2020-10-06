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
		<legend><b>Add contact</b></legend>

		<form method="POST" action="./add-contact">

			<label>Name: </label>
			<input type="text" name="name"/><br>
			<label>Surname: </label> 
			<input type="text" name="surname"/><br>
			<label>Mobile: </label> 
			<input type="text" name="mobile"/><br>
			<label>Email: </label> 
			<input type="text" name="email"/><br>

			<input type="submit" value="ADD"/>
			
		</form>
		
		<p>Last contact added</p>
		
		<jsp:useBean id="addContact" class="it.beije.oort.web.bassanelli.phonebook_application.Contact" scope="session"></jsp:useBean>
		<jsp:setProperty property="name" name="addContact"/>
		<jsp:setProperty property="surname" name="addContact"/>
		<jsp:setProperty property="mobile" name="addContact"/>
		<jsp:setProperty property="email" name="addContact"/>
		
		<%
		
		// Contact contact = (Contact)session.getAttribute("addContact");
		
		if(addContact != null) {
			
			%>
			<p>Name: <jsp:getProperty property="name" name="addContact"/> </p>
			<p>Surname: <jsp:getProperty property="surname" name="addContact"/> </p>
			<p>Mobile: <jsp:getProperty property="mobile" name="addContact"/> </p>
			<p>Email: <jsp:getProperty property="email" name="addContact"/> </p>
			<%
			
		}
		
		%>
		
	</fieldset>
	
	<a href="./index.jsp">Back</a>

</body>
</html>