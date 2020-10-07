<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="it.beije.oort.web.girardi.biblioteca.Libro"%>
<%@page import="it.beije.oort.web.girardi.jpa.JPAfactory"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LibroId</title>
</head>
<body>
		<h2><em>Ricerca libro tramite id</em></h2><br>
		<br>
		<%		
		String errore = (String)session.getAttribute("errore");
		if (errore != null && errore.length() > 0) {
			out.print("<b>"+errore+"</b><br/>");
			session.removeAttribute("errore");
		}
		%>
		<form action="../VisualizzaIdServlet" method = "get">
			<label for="id">ID:</label>
			<input type="text" id="id" name="id" placeholder="id">
			
			<input type="submit" value="Conferma">
		</form> 
		<br>
		<%
		Integer id = (Integer)session.getAttribute("intId");
		if (id != null ) {
			//apro EntityManagerFactory
			EntityManager entityManager = JPAfactory.openEntityFactory();
			//SELECT
			Libro libro = entityManager.find(Libro.class, id);
			//entityManager.close();
			out.print("<b>" + libro + "</b><br/>");
			session.removeAttribute("intId");
		}
		%>
		<br>
		<p> Ritorna all' homepage:  </p>
		<form action="http://localhost:8080/OortWeb/biblioteca/homepage.jsp" >
			<input type="submit" value="homepage">
		</form> 
	</body>
</html>