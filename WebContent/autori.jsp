<%@page import="it.beije.oort.sb.jpa.JPDBtools"%>
<%@page import="it.beije.oort.sb.biblioteca.Autori"%>
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
<h3>Autori disponibili nel nostro catalogo</h3>
<% 	List<Autori> autori = JPDBtools.catalogoAutori();
	for(Autori a : autori){%>
	<p><b>ID</b> <%=a.getId() %> <b>Nome</b> <%=a.getNome() %> <b>Cognome</b> <%=a.getCognome() %> 
	<b>Nato il</b> <%=a.getData_nascita()%>
	<%if(a.getData_morte()!=null) {%> <b>Morto il</b> <%=a.getData_morte() %> <%} %></p>
	<%} %>
	<form action="./Smistatore" method="get">
	<input type="submit" value="CATALOGO" name="Catalogo"/>
	</form>
</body>
</html>