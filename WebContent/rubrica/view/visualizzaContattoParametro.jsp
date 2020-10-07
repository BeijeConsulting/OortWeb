<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.beije.oort.rubrica.*"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca per parametro</title>
</head>
<body>
<% List<Contatto> contatti = (List<Contatto>)session.getAttribute("contatti");%>
<b>CONTATTI</b>
<table style="width:100%">
<tr>
	<th>ID</th>
    <th>NOME</th>
    <th>COGNOME</th>
    <th>TELEFONO</th>
    <th>EMAIL</th>
  </tr>
  <% for(Contatto contatto : contatti) { 
	%> <tr>
	<th><% out.println(contatto.getId());%></th>
	<th><% out.println(contatto.getNome());%></th>
	<th><% out.println(contatto.getCognome());%></th>
	<th><% out.println(contatto.getTelefono());%></th>
	<th><% out.println(contatto.getEmail());%></th>
	</tr>
<% }%>
</table>
</body>
</html>