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

	<%if(session.getAttribute("auth")==null) { %>
			<%
	}else %>
	<header style="margin-left: 2em;">
        <div>
            <h1>Welcome <%= (String)session.getAttribute("nome") %> !</h1>
        </div>
    </header>
	<div>
	        <form action="/OortWeb/PathServlet" method="POST" autocomplete="off" style="margin-left: 2em;">
	            <button type="submit" name="req" value="download">Download</button>
	            <button type="submit" name="req" value="form">Form</button>
	            <button type="submit" name="req" value="select">Select</button>
	        </form>
    	</div>
</body>
</html>