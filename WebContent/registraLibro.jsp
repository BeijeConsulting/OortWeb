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
	String erroreIdAutore = (String)session.getAttribute("erroreIdAutore");
	if (erroreIdAutore != null && erroreIdAutore.length() > 0) {
		out.print("<b>"+erroreIdAutore+"</b><br/>");
		session.removeAttribute("erroreIdAutore");
	}
	
	String erroreIdEditore = (String)session.getAttribute("erroreIdEditore");
	if (erroreIdEditore != null && erroreIdEditore.length() > 0) {
		out.print("<b>"+erroreIdEditore+"</b><br/>");
		session.removeAttribute("erroreIdEditore");
	}

%>
	<h1><em>Registrazione libro</em></h1>
	
	<form action="./Registrazione?page=libro" method="post">
	  <label for="titolo">Titolo:</label>
	  <input type="text" name="titolo" value=""><br>
	  <label for="descrizione">Descrizione:</label>
	  <input type="text" name="descrizione" value=""><br>
	  <label for="id_autore">Id Autore:</label>
	  <input type="text" name="id_autore" value=""><br>
	  <label for="id_editore">Id Editore:</label>
	  <input type="text" name="id_editore" value=""><br>
	  <label for="anno">Anno:</label>
	  <input type="text" name="anno" placeholder="dd MM yyyy" value=""><br>
	  <input name="insert" type="submit" value="INVIO"/>
	</form>
	
	<a href="./GestioneLink">HOME</a><br>
	
	
 
<%
	String inserimento = (String)session.getAttribute("nuovoLibro");
	if (inserimento != null && inserimento.equals("TRUE")) {

%> 
	<p>Libro registrato con successo.</p>
	
<%	
		
	}
	session.removeAttribute("nuovoLibro");
}
%>
 </body>	
</html>