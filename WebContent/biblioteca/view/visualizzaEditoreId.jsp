<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualizzazione editore ricercato</title>
</head>
<body>
	<% 
    String denominazione = (String)session.getAttribute("denominazione");
    String descrizione = (String)session.getAttribute("descrizione"); 
    %>
    <p>Hai selezionato questo editore:   </p>
    <p>denominazione: <%=denominazione %> </p>
    <p>descrizione: <%=descrizione%> </p>
</body>
</html>