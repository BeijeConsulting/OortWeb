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
<h4>Se l'utente è admin digita 1, 0 altrimenti</h4>

<form action="./NuovoUtente" method="post">
	Nome <input type="text" name="nome" value="" placeholder="Mario"/><br>
	Cognome <input type="text" name="cognome" value="" placeholder="Rossi"/><br>
	Telefono <input type="text" name="telefono" value="" placeholder="1234567890"/><br>
	Indirizzo <input type="text" name="indirizzo" value="" placeholder="Via Rossi"/><br>
	Codice Fiscale <input type="text" name="codice_fisc" value="" placeholder="Rossi"/><br>
	Admin <input type="text" name="admin" value="0" placeholder="0/1"/><br>
	Email <input type="email" name="email" value="" placeholder="mariorossi@gmail.com"/><br>
	Password <input type="password" name="password" value="" placeholder=""/><br>
	<input type="submit" value="INVIO"> <input type="reset" value="RESET">
</form>
<form action="./Smistatore" method="get">
<input type="submit" value="HOME" name="Menu">
</form>
</body>
</html>