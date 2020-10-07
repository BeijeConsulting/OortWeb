<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="it.beije.oort.web.girardi.biblioteca.Utente"%>

<!DOCTYPE html>
<!--  http://localhost:8080/OortWeb/biblioteca/homepage.jsp -->
<html>
	<head>
		<title>LA TUA BIBLIOTECA</title>
		<style>
		</style>
	</head>
	<body>
	<!--  
		<jsp:useBean id="userBean" class="it.beije.oort.web.girardi.biblioteca.Utente" scope="session"/>
		<jsp:setProperty property="nome" name="userBean" param="param_nome"/>
		<jsp:setProperty property="cognome" name="userBean" param="param_cognome"/>
	-->
			
<%
/*
//Check the login:
Utente userBean = (Utente)session.getAttribute("userBean");
if (userBean == null) {

} else {
	*/
%>

<% /*
if (userBean.getAdmin()){
	//menu che appare solo se sei admin
} */
%>

		<h2>Ciao <%= (userBean.getNome() != null) ? userBean.getNome() : "" %> 
		<%= (userBean.getCognome() != null) ? userBean.getCognome() : "" %>!</h2><br>
		<br>
		<h2><em>Benvenuto nel menu Biblioteca!</em></h2><br>
		<%
		LocalDateTime now = LocalDateTime.now();
		out.println("Oggi a Greenwich: " + now);
		%>
		<br>
		<h4>Selezionare l'operazione che si vuole eseguire:</h4>
		<form action="../HomepageSv" method = "get">
			<input type="radio" id="operazioni" name="homepage" value="operazioni">
			<label for="operazioni">Prenotazioni e Prestiti</label><br>
			
			<input type="radio" id="naviga" name="homepage" value="naviga">
			<label for="naviga">Naviga in Biblioteca!</label><br>
			
			<input type="submit" value="Invio">
		</form> 
<% //} %>
	</body>
</html>
