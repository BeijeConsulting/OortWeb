<%@page import="it.beije.oort.web.servlet.Contatto"%>
<%@page import="it.beije.oort.web.servlet.SingletonJPA"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@ page import ="javax.persistence.EntityManager" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento rubrica jsp</title>
</head>
<body>
	<h1>Inserire nuovo contatto!</h1>
		<form action="" method="POST">
	<fieldset>
			<legend><h3>Dati contatto: </h3></legend><br>
			<label>Nome: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="nome" type="text"></label><br><br>
			<label>Cognome: <input name="cognome" type="text"></label><br><br>
			<label>Telefono:  &nbsp;<input name="telefono" type="text"></label><br><br>
			<label>Email: &nbsp;&nbsp;&nbsp;&nbsp; <input name="email" type="text"></label><br>
	</fieldset>
			<br>
			<button type ="submit"> Conferma e invia!</button> 
		<form action="menu.jsp">	
			<button type ="submit"> Annulla e torna al menu'!</button>
		</form>
<%		
	

        StringBuilder builder = new StringBuilder("<h3>Dati ricevuti correttamente e aggiunti al DB!</h3> <br>");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		EntityManager entityManager = SingletonJPA.openEntity();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Contatto contatto = new Contatto();

		contatto.setNome(nome);
		contatto.setCognome(cognome);
		contatto.setTelefono(telefono);
		contatto.setEmail(email);
		entityManager.persist(contatto);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("Contatto inserito correttamente!");
		
			
		builder.append("<br/>NOME : ").append(nome).append("<br/>COGNOME : ").append(cognome)
		.append("<br/>TELEFONO : ").append(telefono).append("<br/>EMAIL : ").append(email);

		if(nome != null || cognome != null || telefono != null || email != null)
			response.getWriter().append(builder).append("<br>");
		else {
			%>
			<h2>Inserire almeno un parametro!</h2>
		<%
		} %>		  
		 
</body>
</html>