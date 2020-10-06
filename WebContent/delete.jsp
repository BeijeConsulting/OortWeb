<%@page import="javax.persistence.Query"%>
<%@page import="it.beije.oort.web.servlet.SingletonJPA"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>deletepage</title>
</head>
<body>
		<h1>Eliminare un contatto!</h1>
		<form action="" method="POST">
			<fieldset>
			<legend><p align="left"> Inserire un ID! Se non si conoscono ID ---> <a href ="show.jsp"> "Visualizza Contatti!"</a></p></legend><br>
			<label>ID: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="id" type="text"></label><br><br>
			</fieldset>
			<br>
			<button type ="submit"> Conferma e invia!</button> 
		</form>
		<br>
		<form action="menu.jsp">
			<button type ="submit">Annulla e torna al menu!</button>
		</form>
		<br>
		
		
		
		<%
		String id_value = request.getParameter("id");
		if (id_value != null){
		EntityManager entityManager = SingletonJPA.openEntity();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		String jpql = ("SELECT c FROM Contatto as c WHERE id = " + id_value ) ;
		Query query = entityManager.createQuery(jpql);
		entityManager.remove(query.getResultList().get(0));
		entityManager.getTransaction().commit();
		entityManager.close();	
		%>
		<p align="center" >Contatto Eliminato: n° <% out.print(id_value);%></p>
		<%
		
		System.out.println("Cancellato!");
		} else {
		%>
		
		<%} %>
	
</body>
</html>