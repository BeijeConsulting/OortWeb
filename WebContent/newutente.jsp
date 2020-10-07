<%@page import="java.time.LocalDate"%>
<%@page import="it.beije.oort.sb.jpa.JPDBtools"%>
<%@page import="it.beije.oort.sb.biblioteca.Utenti"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuovo Utente</title>
</head>
<body>
<h3>Inserisci i valori</h3>
<form action="./NuovoUtente" method="post">
	Nome <input type="text" name="nome" value="" placeholder="Mario"/><br>
	Cognome <input type="text" name="cognome" value="" placeholder="Rossi"/><br>
	Nome <input type="text" name="nome" value="" placeholder="Mario"/><br>
	Cognome <input type="text" name="cognome" value="" placeholder="Rossi"/><br>
	Nome <input type="text" name="nome" value="" placeholder="Mario"/><br>
	Cognome <input type="text" name="cognome" value="" placeholder="Rossi"/><br>
	<input type="submit" value="INVIO"> <input type="reset" value="RESET">
</form>
<form action="./Smistatore" method="get">
<input type="submit" value="HOME" name="Menu">
</form>
</body>
</html>