<%@page import="it.beije.oort.web.biblioteca.Autore"%>
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
<h2><p align="left">Autori: </p></h2>
<a href="conferma.jsp"><mark>HOME</mark></a> <a href="contattibiblio.jsp"><mark>CONTATTI</mark></a> <a href="help.jsp"><mark>HELP</mark></a><br><br>
<%
List<Autore> userBean = (List<Autore>)session.getAttribute("userBean4");
int x =1;
if (userBean == null) {
	%>
	<h2>Nessun autore presente</h2> <%
}else{
	for (Autore autori : userBean) {
 	%> <p align="left"><h4> <%out.print(x++ + ") "); out.print(autori.toString());%> </h4></p><%

} }%>
</html>