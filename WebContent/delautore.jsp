<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cancellaatuore</title>
</head>
<body background="sfondo.jpg">
<h1>Eliminare un autore!</h1>
<a href="conferma.jsp"><mark>HOME</mark></a> <a href="contattibiblio.jsp"><mark>CONTATTI</mark></a> <a href="help.jsp"><mark>HELP</mark></a><br><br>
		<form action="./delAutore" method="POST">
			Inserire l'ID del libro da cancellare:
			<fieldset>
			<label><p align="left">	ID: <input name="id" type="text"></label><br><br>
			</fieldset>
			<br>
			<button type ="submit"> Conferma e invia!</button> 
		</form>
		<br>
		<form action="conferma.jsp">
			<button type ="submit">Annulla e torna al menu!</button>
		</form>
		<br>

</body>
</html>