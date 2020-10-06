<%@page import="it.beije.oort.lauria.rubrica.Contatto"%>
<%@page import="it.beije.oort.lauria.rubrica.JPADBtoolsRubrica"%>
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
<title>Oort Rubrica</title>
</head>
<body>
<table>
	<a href="./home.html">home</a><br>
	<%
	List<Contatto> contatti = JPADBtoolsRubrica.selectContacts();
	%>
	<h2>Sono presenti <%=contatti.size() %> contatti in rubrica</h2>
	<tr>
		<th>id</th>
		<th>Nome</th>
		<th>Cognome</th>
		<th>Telefono</th>
		<th>Email</th>
	</tr>
	<%
	for (Contatto contatto : contatti) {
		%>
		<tr>
			<td><%=contatto.getId()%></td>
			<td><%=contatto.getNome()%></td>
			<td><%=contatto.getCognome()%></td>
			<td><%=contatto.getTelefono()%></td>
			<td><%=contatto.getEmail()%></td>
		</tr>
		<%
		}
	%>
		
		</table>
	
</body>
</html>