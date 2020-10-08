<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualizzazione autore rimosso</title>
</head>
<body>
	<% 
    String nome = (String)session.getAttribute("nome");
    String cognome = (String)session.getAttribute("cognome"); 
    LocalDate data_nascita = (LocalDate)session.getAttribute("data_nascita");
    LocalDate data_morte = (LocalDate)session.getAttribute("data_morte");
    String biografia = (String)session.getAttribute("biografia");
    %>
    <p>Hai rimosso questo autore:   </p>
    <p>nome: <%=nome %> </p>
    <p>cognome: <%=cognome%> </p>
    <p>data nascita: <%=data_nascita %> </p>
    <p>data morte: <%=data_morte %> </p>
    <p>biografia: <%=biografia %> </p>
</body>
</html>