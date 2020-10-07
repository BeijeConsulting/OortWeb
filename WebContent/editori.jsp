<%@page import="it.beije.oort.web.biblioteca.Editori"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditoriBiblio</title>
</head>
<body background="sfondo.jpg">
<h2><p align="left">Editori: </p></h2>
<a href="conferma.jsp"><mark>HOME</mark></a> <a href="contattibiblio.jsp"><mark>CONTATTI</mark></a> <a href="help.jsp"><mark>HELP</mark></a><br><br>
<%
List<Editori> userBean = (List<Editori>)session.getAttribute("userBean3");
int x =1;
if (userBean == null) {
	%>
	<h2>Nessun editore presente</h2> <%
}else{
	for (Editori editore : userBean) {
 	%> <p align="left"><h4> <%out.print(x++ + ") "); out.print(editore.toString());%> </h4></p><%

} }%>

</body>
</html>