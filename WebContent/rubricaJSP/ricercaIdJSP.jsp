<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Oort Rubrica</title>
</head>

<body>
	<h1><em>Ricerca Contatto</em></h1>
	
	<form action="./RicercaId" method="POST">
	  <label for="id">Id del contatto da ricercare:</label>
	  <input type="text" name="id" value=""><br>
	  <input type="submit" value="INVIO"/>
	</form>
</body>	
</html>