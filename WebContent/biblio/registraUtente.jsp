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
	<h1><em>Registrazione utente</em></h1>
	
	<form action="./Registrazione?page=utente" method="post">
	  <label for="nome">Nome:</label>
	  <input type="text" name="nome" value=""><br>
	  <label for="cognome">Cognome:</label>
	  <input type="text" name="cognome" value=""><br>
	  <label for="codice_fiscale">Codice fiscale:</label>
	  <input type="text" name="codice_fiscale" value=""><br>
	  <label for="telefono">Telefono:</label>
	  <input type="text" name="telefono" value=""><br>
	  <label for="indirizzo">Indirizzo:</label>
	  <input type="text" name="indirizzo" value=""><br>
	  <label for="admin">Tipologia:</label>
	  <input type="text" name="admin" placeholder="1 se admin, 0 altrimenti"value=""><br>
	  <label for="email">E-mail:</label>
	  <input type="email" name="email" value=""><br>
	  <label for="password">Password:</label>
	  <input type="password" name="password" value=""><br>
	  <input name="insert" type="submit" value="INVIO"/>
	</form>
	
	<a href="./GestioneLink">HOME</a><br>
	
	
 
<%
	String inserimento = (String)session.getAttribute("nuovoUtente");
	if (inserimento != null && inserimento.equals("TRUE")) {

%> 
	<p>Utente registrato con successo.</p>
	
<%	
		
	}
	session.removeAttribute("nuovoUtente");
}
%>
 </body>	
</html>