<%@page import="it.beije.oort.sb.jpa.JPDBtools"%>
<%@page import="it.beije.oort.sb.biblioteca.Utenti"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo Utenti</title>
</head>
<body>
<h3>Utenti Biblioteca Oort</h3>
<% 	List<Utenti> utenti = JPDBtools.catalogoUtenti();
	for(Utenti e : utenti){%>
	<p><b>ID</b> <%=e.getId() %> <b>Nome</b> <%=e.getNome() %> <b>Cognome</b> <%=e.getCognome() %>
	<b>Telefono</b> <%=e.getTelefono() %> <b>Email</b> <%= e.getEmail() %> <b>Codice fiscale</b> <%=e.getCodice_fiscale() %>
	<%} %>
	<form action="./Smistatore" method="get">
	<input type="submit" value="NewPrestito" name="NewPrestito"/>
	</form>
	<form action="./Smistatore" method="get">
	<input type="submit" value="HOME" name="Menu"/>
	</form>

</body>
</html>