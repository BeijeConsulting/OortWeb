<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="it.beije.oort.kirolosmater.biblioteca.model.Utente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca per parametro</title>
</head>
<body>
<% List<Utente> utenti = (List<Utente>)session.getAttribute("utenti");%>
<b>UTENTI</b>
<table style="width:100%">
<tr>
	<th>ID</th>
    <th>NOME</th>
    <th>COGNOME</th>
    <th>CODICE FISCALE</th>
    <th>EMAIL</th>
    <th>TELEFONO</th>
    <th>INDIRIZZO</th>
    <th>ADMIN</th>
  </tr>
  <% for(Utente utente : utenti) { 
	%> <tr>
	<th><% out.println(utente.getId());%></th>
	<th><% out.println(utente.getNome());%></th>
	<th><% out.println(utente.getCognome());%></th>
	<th><% out.println(utente.getCodice_fiscale());%></th>
	<th><% out.println(utente.getEmail());%></th>
	<th><% out.println(utente.getTelefono());%></th>
	<th><% out.println(utente.getIndirizzo());%></th>
	<th><% out.println(utente.isAdmin());%></th>
	</tr>
<% }%>
</table>
</body>
</html>