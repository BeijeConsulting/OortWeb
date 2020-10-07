<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="it.beije.oort.kirolosmater.biblioteca.model.Editore"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca per parametro</title>
</head>
<body>
<% List<Editore> editori = (List<Editore>)session.getAttribute("editori");%>
<b>EDITORI</b>
<table style="width:100%">
<tr>
	<th>ID</th>
    <th>DENOMINAZIONE</th>
    <th>DESCRIZIONE</th>

  </tr>
  <% for(Editore editore : editori) { 
	%> <tr>
	<th><% out.println(editore.getId());%></th>
	<th><% out.println(editore.getDenominazione());%></th>
	<th><% out.println(editore.getDescrizione());%></th>

	</tr>
<% }%>
</table>
</body>
</html>