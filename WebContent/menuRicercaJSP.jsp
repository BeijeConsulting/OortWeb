<%@page import="it.beije.oort.lauria.rubrica.Contatto"%>
<%@page import="it.beije.oort.lauria.rubrica.JPADBtoolsRubrica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Oort Rubrica</title>
</head>
<body>
	<jsp:useBean id="contatto" class="it.beije.oort.lauria.rubrica.Contatto" scope="page" />
	<jsp:setProperty property="id" name="contatto"/>
	<jsp:setProperty property="nome" name="contatto"/>
	<jsp:setProperty property="cognome" name="contatto"/>
	<jsp:setProperty property="telefono" name="contatto"/>
	<jsp:setProperty property="email" name="contatto"/>
	
	<form action="" method="get">
	  <input type="radio" name="scelta" value="s1">
	  <label for="s1">Ricerca tramite id</label><br>
	  <input type="radio" name="scelta" value="s2">
	  <label for="s2">Ricerca tramite nome, cognome, telefono, email</label><br>
	  <input name="search" type="submit" value="INVIO">
	</form>
	

<%
	String submit = request.getParameter("search");
	String scelta = request.getParameter("scelta");
	if (submit != null && submit.equals("INVIO")) {
		if (scelta.equals("s1")) {
%>
			<form action="" method="POST">
			  <label for="id">Id del contatto da ricercare:</label>
			  <input type="text" name="id" value=""><br>
			  <input name="ricercaId" type="submit" value="INVIO"/>
			</form>
<%
			String submit1 = request.getParameter("ricercaId");
			Contatto c = JPADBtoolsRubrica.entityManager.find(Contatto.class, contatto.getId());
%>
	<p>Contatto trovato</p>
		<p>Nome: <%= c.getNome() %></p>
		<p>Cognome: <%= c.getCognome() %></p>
		<p>Telefono: <%= c.getTelefono() %></p>
		<p>Email: <%= c.getEmail() %></p>
	
<%
	}
	}
%>	

</body>
</html>