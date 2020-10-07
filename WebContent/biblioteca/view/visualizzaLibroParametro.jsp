<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="it.beije.oort.kirolosmater.biblioteca.model.Libro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca per parametro</title>
</head>
<body>
<% List<Libro> libri = (List<Libro>)session.getAttribute("libri");%>
<b>LIBRI</b>
<table style="width:100%">
<tr>
	<th>ID</th>
    <th>TITOLO</th>
    <th>AUTORE</th>
    <th>EDITORE</th>
    <th>ANNO</th>
    <th>DESCRIZIONE</th>
  </tr>
  <% for(Libro libro : libri) { 
	%> <tr>
	<th><% out.println(libro.getId());%></th>
	<th><% out.println(libro.getTitolo());%></th>
	<th><% out.println(libro.getAutore());%></th>
	<th><% out.println(libro.getEditore());%></th>
	<th><% out.println(libro.getAnno());%></th>
	<th><% out.println(libro.getDescrizione());%></th>
	</tr>
<% }%>
</table>
</body>
</html>