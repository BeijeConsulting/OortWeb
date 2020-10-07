<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="it.beije.oort.sala.web.db.JPAToolset" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
</head>
<body>

	<% if(session.getAttribute("error")==null) { %>
	<form action="../../Authentication" method="POST" autocomplete="off">
        <label>Email:</label>
        <input type="email" name="email" required>
        <br>
        <label>Password:</label>
        <input type="password" name="password" required>
        <br>
        <button type="submit" name="submit">Login</button>
    </form>
	<% } else { %>
    	 <p style="color: red;"><% out.print(session.getAttribute("error")); %></p>
    	<form action="../../Authentication" method="POST" autocomplete="off">
            <label>Email:</label>
            <input type="email" name="email" required>
            <br>
            <label>Password:</label>
            <input type="password" name="password" required>
            <br>
        <button type="submit" name="submit">Login</button>
        </form>
 	<% session.removeAttribute("error"); } %>
</body>
</html>