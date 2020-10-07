<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualizzazione utente ricercato</title>
</head>
<body>
	<% 
    String nome = (String)session.getAttribute("nome");
    String cognome = (String)session.getAttribute("cognome"); 
    String codice_fiscale = (String)session.getAttribute("codice_fiscale");
    String email = (String)session.getAttribute("email");
    String telefono = (String)session.getAttribute("telefono");
    String indirizzo = (String)session.getAttribute("indirizzo");
    boolean admin = (boolean)session.getAttribute("admin");
    %>
    <p>Hai selezionato questo utente:   </p>
    <p>nome: <%=nome %> </p>
    <p>cognome: <%=cognome%> </p>
    <p>codice_fiscale: <%=codice_fiscale %> </p>
    <p>email: <%=email %> </p>
    <p>telefono: <%=telefono %> </p>
    <p>admin: <%=admin %> </p>
    <p>telefono: <%=telefono %> </p>
</body>
</html>