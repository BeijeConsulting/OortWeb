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
	
		<legend><b>Edit contact</b></legend>
		
		<form method="POST" action="./search-by-id">
		
			<label>ID: </label>
			<input type="text" name="id"/><br>
			<input type="hidden" name="type" value="edit" />

			<input type="submit" value="SEARCH"/>
		
		</form>
		
		<form method="POST" action="./edit-contact">
		
		<jsp:useBean id="searchContact" class="it.beije.oort.web.bassanelli.phonebook_application.Contact" scope="session"></jsp:useBean>
		<jsp:setProperty property="id" name="searchContact"/>
		<jsp:setProperty property="name" name="searchContact"/>
		<jsp:setProperty property="surname" name="searchContact"/>
		<jsp:setProperty property="mobile" name="searchContact"/>
		<jsp:setProperty property="email" name="searchContact"/>
	
	
		<%
	
		if(searchContact != null) {
			%>
			
			<label>ID: <%= searchContact.getId() %> </label><br>
			<input type="hidden" name="id" value=<jsp:getProperty property="id" name="searchContact"/>><br>
			<label>Name: </label>
			<input type="text" name="name" value=<jsp:getProperty property="name" name="searchContact"/>><br>
			<label>Surname: </label> 
			<input type="text" name="surname" value=<jsp:getProperty property="surname" name="searchContact"/>><br>
			<label>Mobile: </label> 
			<input type="text" name="mobile" value=<jsp:getProperty property="mobile" name="searchContact"/>><br>
			<label>Email: </label> 
			<input type="text" name="email" value=<jsp:getProperty property="email" name="searchContact"/>><br>

			<input type="submit" value="EDIT"/>
			
			<%
			
			session.setAttribute("searchContact", null);
			
		}
	
		%>
		
		</form>
	</fieldset>
	
	<a href="./index.jsp">Back</a>

</body>
</html>