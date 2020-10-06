<%@page import="java.util.List"%>
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
	
		<legend><b>Views contacts</b></legend>
		
		<form method="GET" action="./view-contact">
		
			<input type="radio" name="radioValue" value="all" checked="checked"/>
			<label>All</label><br>
			
			<input type="radio" name="radioValue" value="id"/>
			<label>ID</label><br>
			
			<input type="radio" name="radioValue" value="name"/>
			<label>Name</label><br>
			
			<input type="radio" name="radioValue" value="surname"/>
			<label>Surname</label><br>
			
			<input type="radio" name="radioValue" value="mobile"/>
			<label>Mobile</label><br>
			
			<input type="radio" name="radioValue" value="email"/>
			<label>Email</label><br>
			
			<label>Filter: </label>
			<input type="text" name="filter"/><br>
			
			<input type="submit" value="SEARCH"/>
			
		</form>
		
		<%
		
		String type = (String)session.getAttribute("type");

		if(type != null && type.equals("list")) {
			
			List<Contact> contacts = (List<Contact>)session.getAttribute("contacts");
			
			for(int i = 0; contacts != null && i < contacts.size(); i++) {
				%>
				<p><% out.print(contacts.get(i).toString("ID;NAME;SURNAME;MOBILE;EMAIL")); %></p>
				<%
			}
			
		} else if(type != null) {
			
			Contact contact = (Contact)session.getAttribute("contact");
			
			if(contact != null) {
				%>
				<p><% out.print(contact.toString("ID;NAME;SURNAME;MOBILE;EMAIL")); %></p>
				<% 
			}

		}
		%>
	
	</fieldset>
	
	<a href="./index.jsp">Back</a>

</body>
</html>