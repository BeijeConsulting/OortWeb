<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="it.beije.oort.kirolosmater.biblioteca.model.Prestito"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca per parametro</title>
</head>
<body>
<% List<Prestito> prestiti = (List<Prestito>)session.getAttribute("prestiti");%>
<b>AUTORI</b>
<table style="width:100%">
<tr>
	<th>ID</th>
    <th>LIBRO</th>
    <th>UTENTE</th>
    <th>DATA INIZIO</th>
    <th>DATA FINE</th>
    <th>NOTE</th>
  </tr>
  <% for(Prestito prestito : prestiti) { 
	%> <tr>
	<th><% out.println(prestito.getId());%></th>
	<th><% out.println(prestito.getLibro());%></th>
	<th><% out.println(prestito.getUtente());%></th>
	<th><% out.println(prestito.getData_inizio());%></th>
	<th><% out.println(prestito.getData_fine());%></th>
	<th><% out.println(prestito.getNote());%></th>
	</tr>
<% }%>
</table>
</body>
</html>