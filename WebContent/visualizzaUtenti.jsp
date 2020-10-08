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
	List<Utente> utenti = (List<Utente>)session.getAttribute("catalogoUtenti");
	%>
	<h2>Sono stati registrati <%=utenti.size() %> utenti.</h2>
	<tr>
		<th>Id</th>
		<th>Nome</th>
		<th>Cognome</th>		
		<th>Codice_fiscale</th>
		<th>Telefono</th>
		<th>Indirizzo</th>
		<th>Tipologia</th>
		<th>E-mail</th>
	</tr>
	<%
	for (Utente utente : utenti) {
		// potrei inserire autore ed editore come ho fatto nelle JPADBtools e scriverli fra parentesi affianco a numero id
		%>
		<tr>
			<td><%=utente.getId()%></td>
			<td><%=utente.getNome()%></td>
			<td><%=utente.getCognome()%></td>
			<td><%=utente.getCodice_fiscale()%></td>
			<td><%=utente.getTelefono()%></td>
			<td><%=utente.getIndirizzo() != null ? utente.getIndirizzo() : ""%></td>
			<td><%=utente.isAdmin()%></td>
			<td><%=utente.getEmail()%></td>
		</tr>
		<%
		}
	%>
		
		</table>				
<%
}
%>