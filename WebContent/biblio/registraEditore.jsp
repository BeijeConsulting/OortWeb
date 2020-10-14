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

<%

Utente userBean = (Utente)session.getAttribute("userBean");

if (userBean == null) {
%>
	<b>DEVI EFFETTUARE L'AUTENTICAZIONE</b>
	<a href="./LoginBiblio">- Login</a>
<%
} else {
%>
	<h1><em>Registrazione editore</em></h1>
	
	<form action="./Registrazione?page=editore" method="post">
	  <label for="denominazione">Denominazione:</label>
	  <input type="text" name="denominazione" value=""><br>
	  <label for="descrizione">Descrizione:</label>
	  <input type="text" name="descrizione" value=""><br>
	  <input name="insert" type="submit" value="INVIO"/>
	</form>
	
	<a href="./GestioneLink">HOME</a><br>
	
	
 
<%
	String inserimento = (String)session.getAttribute("nuovoEditore");
	if (inserimento != null && inserimento.equals("TRUE")) {

%> 
	<p>Editore registrato con successo.</p>
	
<%	
		
	}
	session.removeAttribute("nuovoEditore");
}
%>
 </body>	
</html>