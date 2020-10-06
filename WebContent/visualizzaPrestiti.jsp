<%@page import="it.beije.oort.lauria.biblioteca.JPADBtools"%>
<%@page import="it.beije.oort.lauria.biblioteca.Prestito"%>
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
	<a href="./loginBiblio.jsp" >- Login</a>
<%
} else {
%>

<table>

	<a href="./confermaLogin.jsp">HOME</a><br>
	<%
	List<Prestito> prestiti = JPADBtools.selectPrestiti();
	%>
	<h2>Sono stati registrati <%=prestiti.size() %> prestiti.</h2>
	<tr>
		<th>Id</th>
		<th>Id_libro</th>
		<th>Id_utente</th>		
		<th>Data_inizio()</th>
		<th>Data_fine</th>
		<th>Note</th>
	</tr>
	<%
	for (Prestito prestito : prestiti) {
		// potrei inserire autore ed editore come ho fatto nelle JPADBtools e scriverli fra parentesi affianco a numero id
		%>
		<tr>
			<td><%=prestito.getId()%></td>
			<td><%=prestito.getId_libro()%></td>
			<td><%=prestito.getId_utente()%></td>
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