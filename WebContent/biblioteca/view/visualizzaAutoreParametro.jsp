<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="it.beije.oort.kirolosmater.biblioteca.model.Autore"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca per parametro</title>
</head>
<body>
<% List<Autore> autori = (List<Autore>)session.getAttribute("autori");%>
<b>AUTORI</b>
<table style="width:100%">
<tr>
	<th>ID</th>
    <th>NOME</th>
    <th>COGNOME</th>
    <th>DATA NASCITA</th>
    <th>DATA MORTE</th>
    <th>BIOGRAFIA</th>
  </tr>
  <% for(Autore autore : autori) { 
	%> <tr>
	<th><% out.println(autore.getId());%></th>
	<th><% out.println(autore.getNome());%></th>
	<th><% out.println(autore.getCognome());%></th>
	<th><% out.println(autore.getData_nascita());%></th>
	<th><% out.println(autore.getData_morte());%></th>
	<th><% out.println(autore.getBiografia());%></th>
	</tr>
<% }%>
</table>
</body>
</html>