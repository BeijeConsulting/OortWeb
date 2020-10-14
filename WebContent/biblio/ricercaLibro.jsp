<%@page import="it.beije.oort.lauria.biblioteca.Utente"%>
<%@page import="it.beije.oort.lauria.biblioteca.Libro"%>
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
	<h1><em>Ricerc libro per id</em></h1>
	
	<form action="./RicercaLibro" method="post">
	  <label for="id_libro">Id libro:</label>
	  <input type="text" name="id_libro" value=""><br>
	  <input name="insert" type="submit" value="INVIO"/>
	</form>
	
	<a href="./GestioneLink">HOME</a><br>
	
	
 
<%
	Libro libro = (Libro)session.getAttribute("ricercaLibro");
	if (libro != null ) {

%> 
	<p>Libro trovato.</p>
		<table>
		<tr>
			<th>Id</th>
			<th>Titolo</th>
			<th>Descrizione</th>
			<th>Id_autore</th>
			<th>Id_editore</th>
			<th>Anno</th>
		</tr>
		<tr>
			<td><%=libro.getId()%></td>
			<td><%=libro.getTitolo()%></td>
			<td><%=libro.getDescrizione() != null ? libro.getDescrizione() : ""%></td>
			<td><%=libro.getId_autore()%></td>
			<td><%=libro.getId_editore()%></td>
			<td><%=libro.getAnno()%></td>
		</tr>
		</table>
	
<%	
		
	}
	session.removeAttribute("ricercaLibro");
}
%>
 </body>	
</html>