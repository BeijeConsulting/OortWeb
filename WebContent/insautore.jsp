<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>InsertAutore</title>
</head>
<body background="sfondo.jpg">
	<h1>Inserire nuovo autore!</h1>
		<form action="./insautore" method="post">
	<fieldset>
			<legend><h3>Dati autore: </h3></legend><br>
			<p align ="left"><label>
			Nome: <input name="nome" type="text"> 
			Cognome: <input name="cognome" type="text">
			Data Nascita(Num): <input name="data_n" type="text">
			Data Morte(Num): <input name="data_m" type="text">
			Biografia: <input name="bio" type="text"></label></p>
	</fieldset>
			<br>
			<button type ="submit"> Conferma e invia!</button> 
			</form>
			<br>
		<form action="conferma.jsp">	
			<button type ="submit"> Annulla e torna al menu'!</button>
		</form>
</body>
</html>