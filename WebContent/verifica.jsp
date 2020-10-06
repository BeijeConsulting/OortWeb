<%@page import="it.beije.oort.sb.jpa.JPDBtools"%>
<%@page import="it.beije.oort.sb.biblioteca.Utenti"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 	String email = request.getParameter("email");
		String password = request.getParameter("password"); 
		Utenti utente = JPDBtools.ricercaUtente(email, password);
		if(utente==null) {session.setAttribute("errore", "Credenziali Errate");
		response.sendRedirect("login.jsp"); }
		else { 
			session.setAttribute("utente", utente);
			session.setAttribute("login", "true");
			response.sendRedirect("menubiblioteca.jsp");
			//session.setAttribute("admin", on/off);
			
			} %>
</body>
</html>