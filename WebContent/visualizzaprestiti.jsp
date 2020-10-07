<%@page import="it.beije.oort.sb.jpa.JPDBtools"%>
<%@page import="it.beije.oort.sb.biblioteca.Prestiti"%>
<%@page import="it.beije.oort.sb.biblioteca.Utenti"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Storico prestiti</title>
</head>
<body>
<%Utenti utente = ((Utenti)session.getAttribute("utente")); %>
<h3>Questi sono i prestiti di <%=utente.getNome()%> <%=utente.getCognome() %></h3>
<% List<Prestiti> list = JPDBtools.ricercaPrestitiId("utente",utente.getId());
	for(Prestiti p : list) { %>
		<p><b>Libro</b> <%=JPDBtools.ricercaLibro(p.getLibro()).getTitolo() %> <b>Data Inizio</b> <%=p.getData_inizio() %> 
		<b>Data Fine</b> <%=p.getData_fine() %> </p>
	<%}%>
	<form action="./Smistatore" method="get">
	<input type="submit" value="HOME" name="Menu">
	</form>

</body>
</html>