<%@page import="it.beije.oort.web.biblioteca.Libri"%>
<%@page import="java.util.List"%>
<%@page import="it.beije.oort.web.biblioteca.SingletonJPABiblio"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LibriBiblio</title>
</head>
<body background="sfondo.jpg">
<h2><p align="left">Libri presenti in biblioteca: </p></h2>
<a href="conferma.jsp"><mark>HOME</mark></a> <a href="contattibiblio.jsp"><mark>CONTATTI</mark></a> <a href="help.jsp"><mark>HELP</mark></a><br><br>

<%
List<Libri> userBean = (List<Libri>)session.getAttribute("userBean2");
int x =1;
if (userBean == null) {
	%>
	<h2>Nessun libro presente</h2> <%
}else{
	for (Libri libro : userBean) {
 	%> <p align="left"><h4> <%out.print(x++ + ") "); out.print(libro.toString());%> </h4></p><%

} }%>
	

</body>
</html>