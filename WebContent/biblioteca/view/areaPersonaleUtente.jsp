<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.beije.oort.kirolosmater.biblioteca.model.Utente"%>
    <%@page import="it.beije.oort.kirolosmater.biblioteca.model.Prestito"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="java.util.List"%>
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
<b>PRESTITI</b>
<table style="width:100%">
<tr>
    <th>LIBRO</th>
    <th>DATA INIZIO</th>
    <th>DATA FINE</th>
    <th>NOTE</th>
  </tr>
<% List<Prestito> prestitiUserBean = (List<Prestito>)session.getAttribute("prestitiUserBean"); %>
<% for(Prestito prestito : prestitiUserBean) { 
	%> <tr>
	<th><% out.println(prestito.getLibro());%></th>
	<th><% out.println(prestito.getData_inizio());%></th>
	<th><% out.println(prestito.getData_fine());%></th>
	<th><% out.println(prestito.getNote());%></th>
	</tr>
<% }%>
</table>

</body>
</html>