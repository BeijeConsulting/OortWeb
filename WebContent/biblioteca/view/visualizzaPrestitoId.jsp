<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualizzazione prestito ricercato</title>
</head>
<body>
	<% 
    String libro = (String)session.getAttribute("libro");
    String utente = (String)session.getAttribute("utente"); 
    LocalDate data_inizio = (LocalDate)session.getAttribute("data_inizio");
    LocalDate data_fine = (LocalDate)session.getAttribute("data_fine");
    String note = (String)session.getAttribute("note");
    %>
    <p>Hai selezionato questo prestito:   </p>
    <p>libro: <%=libro %> </p>
    <p>utente: <%=utente%> </p>
    <p>data_inizio: <%=data_inizio %> </p>
    <p>data_fine: <%=data_fine %> </p>
    <p>note: <%=note %> </p>
</body>
</html>