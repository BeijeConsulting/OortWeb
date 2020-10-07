<%@page import="java.time.LocalDate"%>
<%@page import="it.beije.oort.sb.jpa.JPDBtools"%>
<%@page import="it.beije.oort.sb.biblioteca.Editori"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuovo Editore</title>
</head>
<body background="editori.png">
<h3>Inserisci i valori</h3>
<form action="./NuovoEditore" method="post">
	Denominazione <input type="text" name="denominazione" value="" placeholder="Mondadori"/><br>
	Descrizione <input type="text" name="descrizione" value="" placeholder=""/><br>
	<input type="submit" value="INVIO"> <input type="reset" value="RESET">
</form>
<form action="./Smistatore" method="get">
<input type="submit" value="HOME" name="Menu">
</form>
</body>
</html>