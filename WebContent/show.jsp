<%@page import="it.beije.oort.web.servlet.Contatto"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="it.beije.oort.web.servlet.SingletonJPA"%>
<%@page import="javax.persistence.EntityManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>showpage</title>
</head>
<body>
	<h1>Lista contatti in rubrica:</h1>
		<p align="right">Clicca <a href="menu.jsp"><mark>QUI</mark></a> per tornare al menu' principale.</p>	
		<%
		EntityManager entityManager = SingletonJPA.openEntity();
		String jpql = "SELECT c FROM Contatto as c";
		Query query = entityManager.createQuery(jpql);
		List<Contatto> contatti = query.getResultList();
		for (Contatto contatto : contatti) { 
		%><div align="left"><%	out.print(contatto);%></div>
			<br><%
			
		}
		entityManager.close();
		
 		%>
 		
</body>
</html>