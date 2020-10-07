<%@page import="it.beije.oort.lauria.biblioteca.JPADBtools"%>
<%@page import="it.beije.oort.lauria.biblioteca.Autore"%>
<%@page import="it.beije.oort.lauria.biblioteca.Utente"%>
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
	<a href="./LoginBiblio">- Login</a>
<%
} else {
%>

<table>
	<a href="./GestioneLink">HOME</a><br>
	<%
	List<Autore> autori = (List<Autore>)session.getAttribute("catalogoAutori");
	%>
	<h2>Sono presenti <%=autori.size() %> autori di libri nel catalogo della biblioteca</h2>
	<tr>
		<th>Id</th>
		<th>Cognome</th>
		<th>Nome</th>
		<th>Data_nascita</th>
		<th>Data_morte</th>
		<th>Biografia</th>
	</tr>
	<%
	for (Autore autore : autori) {
		// potrei inserire autore ed editore come ho fatto nelle JPADBtools e scriverli fra parentesi affianco a numero id
		%>
		<tr>
			<td><%=autore.getId()%></td>
			<td><%=autore.getCognome()%></td>
			<td><%=autore.getNome()%></td>
			<td><%=autore.getData_nascita().toString()%></td>
			<td><%=autore.getData_morte().toString()%></td>
			<td><%=autore.getBiografia() != null ? autore.getBiografia() : ""%></td>
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