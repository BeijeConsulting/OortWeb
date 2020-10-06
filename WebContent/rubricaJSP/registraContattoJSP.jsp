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
<jsp:setProperty property="nome" name="contatto"/>
<jsp:setProperty property="cognome" name="contatto"/>
<jsp:setProperty property="telefono" name="contatto"/>
<jsp:setProperty property="email" name="contatto"/>


	<h1><em>Registrazione Contatto</em></h1>
	
	<form action="" method="POST">
	  <label for="nome">Nome:</label>
	  <input type="text" name="nome" value=""><br>
	  <label for="cognome">Cognome:</label>
	  <input type="text" name="cognome" value=""><br>
	  <label for="telefono">Telefono:</label>
	  <input type="text" name="telefono" value=""><br>
	  <label for="email">Email:</label>
	  <input type="text" name="email" value=""><br>
	  <input name="insert" type="submit" value="INVIO"/>
	</form>

<%
	String submit = request.getParameter("insert");
	JPADBtoolsRubrica.insertContact(contatto.getNome(), contatto.getCognome(), contatto.getTelefono(), contatto.getEmail());
	if (submit != null && submit.equals("INVIO")) {
%>
	<p>Contatto inserito correttamente</p>
		<p>Nome: <%= contatto.getNome() %></p>
		<p>Cognome: <%= contatto.getCognome() %></p>
		<p>Telefono: <%= contatto.getTelefono() %></p>
		<p>Email: <%= contatto.getEmail() %></p>
<%
	}	
%>	
	<a href="./home.html">home</a><br>
</body>	
</html>