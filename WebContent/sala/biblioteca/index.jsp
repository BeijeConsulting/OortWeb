<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="it.beije.oort.sala.web.db.JPAToolset" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	<% if(session.getAttribute("auth")==null) { %>
	<form action="../../Authentication" method="POST" autocomplete="off">
        <label>Email:</label>
        <input type="email" name="email" required>
        <br>
        <label>Password:</label>
        <input type="password" name="password" required>
        <br>
        <button type="submit" name="submit">Login</button>
    </form>
	<% }else if((boolean)session.getAttribute("auth")) { %>
	<header style="margin-left: 2em;">
        <div>
            <h1>Benvenuto <% out.print(session.getAttribute("nome")); %> !</h1>
            <p>Seleziona l'azione che vuoi compiere tra quelle disponibili</p>
        </div>
    </header>
	<div>
		<form action="/OortWeb/PathServlet" method="POST" autocomplete="off" style="margin-left: 2em;">
		    <button type="submit" name="req" value="download"></button>
		    <button type="submit" name="req" value="form">Form</button>
		    <button type="submit" name="req" value="select">Select</button>
		</form>
    	</div> 
    	<% } else if (!(boolean)session.getAttribute("auth")) { %>
    	 <p style="color: red;"><% out.print(session.getAttribute("error")); %></p>
    	<form action="./Authentication" method="POST" autocomplete="off">
            <label>Email:</label>
            <input type="email" name="email" required>
            <br>
            <label>Password:</label>
            <input type="password" name="password" required>
            <br>
        <button type="submit" name="submit">Login</button>
        </form>
 	<% } %>
</body>
</html>