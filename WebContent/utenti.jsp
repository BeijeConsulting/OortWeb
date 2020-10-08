<%@page import="it.beije.oort.web.biblioteca.Utenti"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="sfondo.jpg">
<h2><p align="left">Utenti: </p></h2>
<a href="conferma.jsp"><mark>HOME</mark></a> <a href="contattibiblio.jsp"><mark>CONTATTI</mark></a> <a href="help.jsp"><mark>HELP</mark></a><br><br>

<%
List<Utenti> userBean = (List<Utenti>)session.getAttribute("userBean6");
int x =1;
if (userBean == null) {
	%>
	<h2>Nessun utente presente</h2> <%
}else{
	for (Utenti utente : userBean) {
 	%> <p align="left"><h4> <%out.print(x++ + ") "); out.print(utente.toString());%> </h4></p><%

} }%>
</body>
</html>