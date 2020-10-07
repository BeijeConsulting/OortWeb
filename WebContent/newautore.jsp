<%@page import="java.time.LocalDate"%>
<%@page import="it.beije.oort.sb.jpa.JPDBtools"%>
<%@page import="it.beije.oort.sb.biblioteca.Autori"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuovo Autore</title>
</head>
<body background="RitrattodiDante.jpg">
<h3>Inserisci i valori</h3>
<form action="./NuovoAutore" method="post">
	Nome <input type="text" name="nome" value="" placeholder="Dante"/><br>
	Cognome <input type="text" name="cognome" value="" placeholder="Alighieri"/><br>
	Data Nascita <input type="text" name="data_nascita" value="" placeholder="yyyy-MM-dd"/><br>
	Data Morte  <input type="text" name="data_morte" value="" placeholder="yyyy-MM-dd"/><br>
	Biografia <input type="text" name="biografia" value="" placeholder=""/><br>
	<input type="submit" value="INVIO"> <input type="reset" value="RESET">
</form>
<form action="./Smistatore" method="get">
<input type="submit" value="HOME" name="Menu">
</form>
</body>
</html>