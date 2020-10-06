<%@page import="it.beije.oort.web.jsp.Utente"%>
<%@page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OortWeb JSP</title>
</head>
<body>

<%
	/*
String nome = (String)session.getAttribute("nome");
String cognome = (String)session.getAttribute("cognome");
*/

Utente contatto = (Utente)session.getAttribute("contatto");

//String name = request.getParameter("name");


LocalTime now = LocalTime.now();

System.out.println(now);

if (contatto.getNome() != null || contatto.getCognome() != null) {
%>
	<h1>CIAO <%= (contatto.getNome() != null) ? contatto.getNome() : "" %> <%= (contatto.getCognome() != null) ? contatto.getCognome() : "" %></h1>

<p>SONO LE ORE <%= now %></p>
<br>
<% for(char l = 'a'; l <= 'z'; l++) out.print(l); %>

	<%
} else {
	%>
	<h1>CIAO SCONOSCIUTO devi prima effettuare il login!!</h1>
	<%
}
%>


</body>
</html>