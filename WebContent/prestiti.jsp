<%@page import="it.beije.oort.web.biblioteca.Prestiti"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PrestitiBiblio</title>
</head>
<body background="sfondo.jpg">
<h2><p align="left">Prestiti: </p></h2>
<a href="conferma.jsp"><mark>HOME</mark></a> <a href="contattibiblio.jsp"><mark>CONTATTI</mark></a> <a href="help.jsp"><mark>HELP</mark></a><br><br>

<%
List<Prestiti> userBean = (List<Prestiti>)session.getAttribute("userBean5");
int x =1;
if (userBean == null) {
	%>
	<h2>Nessun libro presente</h2> <%
}else{
	for (Prestiti prestito : userBean) {
 	%> <p align="left"><h4> <%out.print(x++ + ") "); out.print(prestito.toString());%> </h4></p><%

} }%>
</body>
</html>