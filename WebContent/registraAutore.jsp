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
	<h1><em>Registrazione autore</em></h1>
	
	<form action="./Registrazione?page=autore" method="post">
	  <label for="nome">Nome:</label>
	  <input type="text" name="nome" value=""><br>
	  <label for="cognome">Cognome:</label>
	  <input type="text" name="cognome" value=""><br>
	  <label for="data_nascita">Data di nascita:</label>
	  <input type="text" name="data_nascita" placeholder="dd MM yyyy" value=""><br>
	  <label for="data_morte">Data di morte:</label>
	  <input type="text" name="data_morte" placeholder="dd MM yyyy" value=""><br>
	  <label for="biografia">Biografia:</label>
	  <input type="text" name="biografia" value=""><br>
	  <input name="insert" type="submit" value="INVIO"/>
	</form>
	
	<a href="./GestioneLink">HOME</a><br>
	
	
 
<%
	String inserimento = (String)session.getAttribute("nuovoAutore");
	if (inserimento != null && inserimento.equals("TRUE")) {

%> 
	<p>Autore registrato con successo.</p>
	
<%	
		
	}
	session.removeAttribute("nuovoAutore");
}
%>
 </body>	
</html>