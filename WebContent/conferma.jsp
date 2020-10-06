<%@page import="java.time.LocalTime"%>
<%@page import="it.beije.oort.web.biblioteca.Utenti"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="sfondo.jpg">




<%-- jsp:useBean id="userBean" class="it.beije.oort.web.Utente" scope="session"/--%>


<%
Utenti userBean = (Utenti)session.getAttribute("userBean");

if (userBean == null) {
%>
<b>DEVI PRIMA EFFETTUARE L'AUTENTICAZIONE, clicca <a href ="login.jsp"><mark>QUI</mark></a></b>

<%
} else {
%>
<%-- UTENTE: <jsp:getProperty property="nome" name="userBean"/> <jsp:getProperty property="cognome" name="userBean"/> --%>
<h1>Benvenuto,  <mark> <%= (userBean.getNome() != null) ? userBean.getNome() : "" %> <%= (userBean.getCognome() != null) ? userBean.getCognome() : "" %></mark></h1>
<% LocalTime time = LocalTime.now();
%><p align="right"><mark><% out.print(time);%></mark></p>


<h3><p align ="left">Operazione che puoi effettuare:   </p></h3>
<p align ="left">1) Visualizzare <a href="libri.jsp">libri</a>, <a href="autori.jsp">autori</a>, <a href="editori.jsp">editori</a>.
<%
}
%>
</body>
</html>