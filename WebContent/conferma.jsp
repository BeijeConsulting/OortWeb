<%@page import="it.beije.oort.web.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="userBean" class="it.beije.oort.web.Utente" scope="session"/>

<%
//Utente contatto = (Utente)session.getAttribute("contatto");
%>

UTENTE: <jsp:getProperty property="nome" name="userBean"/> <jsp:getProperty property="cognome" name="userBean"/>
</body>
</html>