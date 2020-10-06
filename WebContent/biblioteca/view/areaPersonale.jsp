<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.beije.oort.kirolosmater.biblioteca.Utente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Area Personale</title>
</head>
<body>
<%
Utente userBean = (Utente)session.getAttribute("userBean");

if (userBean == null) {
%>
<b>DEVI EFFETTUARE L'AUTENTICAZIONE</b>
<%
} else {
%>
<%-- UTENTE: <jsp:getProperty property="nome" name="userBean"/> <jsp:getProperty property="cognome" name="userBean"/> --%>
<h1>CIAO <%= (userBean.getNome() != null) ? userBean.getNome() : "" %> <%= (userBean.getCognome() != null) ? userBean.getCognome() : "" %></h1>
<%
}
%>
</body>
</html>