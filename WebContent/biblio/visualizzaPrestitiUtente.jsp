<%@page import="it.beije.oort.lauria.biblioteca.JPADBtools"%>
<%@page import="it.beije.oort.lauria.biblioteca.Prestito"%>
<%@page import="it.beije.oort.lauria.biblioteca.Utente"%>
<%@page import="it.beije.oort.lauria.biblioteca.Libro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

	<style>
	table {
	  font-family: arial, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	}
	
	td, th {
	  border: 1px solid #dddddd;
	  text-align: left;
	  padding: 8px;
	}
	
	tr:nth-child(even) {
	  background-color: #dddddd;
	}
	</style>
<meta charset="ISO-8859-1">
<title>Oort Biblioteca</title>
</head>
<body>

<%
Utente userBean = (Utente)session.getAttribute("userBean");

if (userBean == null) {
%>
	<b>DEVI EFFETTUARE L'AUTENTICAZIONE</b>
	<a href="./LoginBiblio" >- Login</a>
<%
} else {
%>

<table>

	<a href="./GestioneLink">HOME</a><br>
	<%
	List<Prestito> prestiti = (List<Prestito>)session.getAttribute("catalogoPrestitiUtente");
	List<Libro> libri = (List<Libro>)session.getAttribute("catalogoLibri");
	%>
	<h2>Sono stati registrati <%=prestiti.size() %> prestiti a suo nome.</h2>
	<tr>
		<th>Id_utente</th>
		<th>Id_libro</th>
		<th>Data_inizio()</th>
		<th>Data_fine</th>
		<th>Note</th>
	</tr>
	<%
	for (Prestito prestito : prestiti) {
		// potrei inserire autore ed editore come ho fatto nelle JPADBtools e scriverli fra parentesi affianco a numero id
		%>
		<tr>
			<td><%=prestito.getId_utente()%></td>
			<td><%=prestito.getId_libro()%> (<%=libri.get(prestito.getId_libro()-1).getTitolo()%>)</td>
			<td><%=prestito.getData_inizio().toString()%></td>
			<td><%=prestito.getData_fine().toString()%></td>
			<td><%=prestito.getNote() != null ? prestito.getNote() : ""%></td>
		</tr>
		<%
		}
	%>
		
		</table>				

<%
}
%>
</body>
</html>