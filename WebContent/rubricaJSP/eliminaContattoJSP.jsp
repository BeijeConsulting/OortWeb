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

	<h1><em>Elimina Contatto</em></h1>
	
	<form action="" method="POST">
	  <label for="id">Id del contatto da eliminare:</label>
	  <input type="text" name="id" value=""><br>
	  <input name="insert" type="submit" value="INVIO"/>
	</form>

<%
	String submit = request.getParameter("insert");

	if (submit != null && submit.equals("INVIO")) {
			JPADBtoolsRubrica.deleteContact(contatto.getId());
%>
	<p>Contatto eliminato correttamente</p>
<%
	}	
%>	
	<a href="./home.html">home</a><br>
	

</body>
</html>