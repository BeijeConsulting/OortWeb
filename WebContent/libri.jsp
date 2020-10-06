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
<a href="conferma.jsp"><mark>HOME</mark></a> <a href="contattibiblio.jsp"><mark>CONTATTI</mark></a> <a href="help.jsp"><mark>HELP</mark></a>


<%
int x = 1;
EntityManager entityManager = SingletonJPABiblio.openEntity();
String jpql = "SELECT l FROM Libri as l";
Query query = entityManager.createQuery(jpql);
List<Libri> libri = query.getResultList();
if(libri.size()!= 0){
for (Libri libro : libri) {
%><h4><p align="left"><%  out.print(x++ + ") "); out.print(libro.toString());%></p></h4> <%

}
}else{
%> <h2><p align="center">Nessun libro nel DataBase della Biblioteca!</p></h2>
<%
}
%>
</body>
</html>