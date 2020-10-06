<%@page import="it.beije.oort.lauria.rubrica.JPADBtoolsRubrica"%>
<%@page import="it.beije.oort.lauria.biblioteca.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Oort Biblioteca</title>
</head>
<body>

<%-- jsp:useBean id="userBean" class="it.beije.oort.web.Utente" scope="session"/--%>

<%
Utente userBean = (Utente)session.getAttribute("userBean");

if (userBean == null) {
%>
	<b>DEVI EFFETTUARE L'AUTENTICAZIONE</b></br>
	<a href="./loginBiblio.jsp" >- Login</a>
<%
} else if(userBean != null && !userBean.isAdmin()) {
%>
<%-- UTENTE: <jsp:getProperty property="nome" name="userBean"/> <jsp:getProperty property="cognome" name="userBean"/> --%>
	<h1>Benvenuto <%= (userBean.getNome() != null) ? userBean.getNome() : "" %> <%= (userBean.getCognome() != null) ? userBean.getCognome() : "" %></h1>
		<ul>
			<a href="./visualizzaLibri.jsp" ><li>Libri in biblioteca</li></a>
			<a href="./visualizzaAutori.jsp" ><li>Catalogo autori</li></a>
			<a href="./visualizzaEditori.jsp" ><li>Catalogo editori</li></a>
			<a href="./visualizzaPrestitiUtente.jsp" ><li>I tuoi prestiti</li></a>
		</ul>
		
		<!-- RICERCA -->

<%
}else {
%>
		<h1>Benvenuto <%= (userBean.getNome() != null) ? userBean.getNome() : "" %> <%= (userBean.getCognome() != null) ? userBean.getCognome() : "" %></h1>
		<ul>
			<a href="./visualizzaLibri.jsp" ><li>Libri in biblioteca</li></a>
			<a href="./visualizzaAutori.jsp" ><li>Catalogo autori</li></a>
			<a href="./visualizzaEditori.jsp" ><li>Catalogo editori</li></a>
			<a href="./visualizzaPrestiti.jsp" ><li>Elenco prestiti</li></a>
		</ul>
		
		<!-- INSERIMENTO/ELIMINAZIONE E RICERCA -->
	
<%		
}
%>
</body>
</html>