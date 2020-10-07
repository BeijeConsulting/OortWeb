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
	<h1><em>Registrazione prestito</em></h1>
	
	<form action="./Registrazione?page=utente" method="post">
	  <label for="nome">Id libro:</label>
	  <input type="text" name="nome" value=""><br>
	  <label for="cognome">Id utente:</label>
	  <input type="text" name="cognome" value=""><br>
	   <label for="data_inizio">Data di inizio prestito:</label>
	  <input type="text" name="data_inizio" placeholder="dd MM yyyy" value=""><br>
	  <label for="data_fine">Data di fine prestito:</label>
	  <input type="text" name="data_fine" placeholder="dd MM yyyy" value=""><br>
	  <label for="note">Note:</label>
	  <input type="text" name="note" value=""><br>
	  <input name="insert" type="submit" value="INVIO"/>
	</form>
	
	<a href="./GestioneLink">HOME</a><br>
	
	
 
<%
	String inserimento = (String)session.getAttribute("nuovoPrestito");
	if (inserimento != null && inserimento.equals("TRUE")) {

%> 
	<p>Prestito registrato con successo.</p>
	
<%	
		
	}
	session.removeAttribute("nuovoPrestito");
}
%>
 </body>	
</html>