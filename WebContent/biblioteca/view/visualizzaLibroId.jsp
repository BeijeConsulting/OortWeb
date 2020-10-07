<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualizzazione libro ricercato</title>
</head>
<body>
	<% 
    String titolo = (String)session.getAttribute("titolo");
    String autore = (String)session.getAttribute("autore"); 
    String editore = (String)session.getAttribute("editore");
    int anno = (int)session.getAttribute("anno");
    String descrizione = (String)session.getAttribute("descrizione");
    %>
    <p>Hai selezionato questo libro:   </p>
    <p>titolo: <%=titolo %> </p>
    <p>autore: <%=autore%> </p>
    <p>editore: <%=editore %> </p>
    <p>anno: <%=anno %> </p>
    <p>descrizione: <%=descrizione %> </p>
</body>
</html>