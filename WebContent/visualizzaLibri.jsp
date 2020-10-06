<%@page import="it.beije.oort.lauria.biblioteca.JPADBtools"%>
<%@page import="it.beije.oort.lauria.biblioteca.Libro"%>
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
	<a href="./homeBiblio.jsp">HOME</a><br>
<%
} else {
%>	
	<a href="./confermaLogin.jsp">HOME</a><br>
<%	
}
%>
<table>
	
	<%
	List<Libro> libri = JPADBtools.selectLibri();
	%>
	<h2>Sono presenti <%=libri.size() %> libri in biblioteca</h2>
	<tr>
		<th>Id</th>
		<th>Titolo</th>
		<th>Descrizione</th>
		<th>Id_autore</th>
		<th>Id_editore</th>
		<th>Anno</th>
	</tr>
	<%
	for (Libro libro : libri) {
		// potrei inserire autore ed editore come ho fatto nelle JPADBtools e scriverli fra parentesi affianco a numero id
		%>
		<tr>
			<td><%=libro.getId()%></td>
			<td><%=libro.getTitolo()%></td>
			<td><%=libro.getDescrizione() != null ? libro.getDescrizione() : ""%></td>
			<td><%=libro.getId_autore()%></td>
			<td><%=libro.getId_editore()%></td>
			<td><%=libro.getAnno()%></td>
		</tr>
		<%
		}
	%>
		
		</table>	
		
</body>
</html>