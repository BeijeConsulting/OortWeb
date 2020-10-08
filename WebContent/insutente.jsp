<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="sfondo.jpg">
	<h1>Inserire nuovo utente!</h1>
	<a href="conferma.jsp"><mark>HOME</mark></a> <a href="contattibiblio.jsp"><mark>CONTATTI</mark></a> <a href="help.jsp"><mark>HELP</mark></a><br><br>
		<form action="./insUtente" method="post">
	<fieldset>
			<legend><h3>Dati utente: </h3></legend><br>
			<label>Nome: <input name="nome" type="text">
			Cognome: <input name="cognome" type="text">
			Codice Fiscale : <input name="codice_fiscale" type="text"></label><br><br><br>
			<label>Indirizzo: <input name="indirizzo" type="text">
			Telefono: <input name="telefono" type="text"></label><br><br><br>
			<label>Email: <input name="email" type="text">
			Password: <input name="password" type="text"></label>
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