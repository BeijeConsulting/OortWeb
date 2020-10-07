<%@page import="it.beije.oort.sb.jpa.JPDBtools"%>
<%@page import="it.beije.oort.sb.biblioteca.Editori"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo Autori</title>
</head>
<body>
<h3>Editori disponibili nel nostro catalogo</h3>
<% 	List<Editori> editori = JPDBtools.catalogoEditori();
	for(Editori e : editori){%>
	<p><b>ID</b> <%=e.getId() %> <b>Denominazione</b> <%=e.getDenominazione() %> 
	<%if(e.getDescrizione()!=null) {%> <b>Con Descrizione</b> <%=e.getDescrizione() %> <%} %></p>
	<%} %>
	<form action="./Smistatore" method="get">
	<input type="submit" value="CATALOGO" name="Catalogo"/>
	</form>
</body>
</html>