<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="sfondo.jpg">
	<h1>Inserire nuovo prestito!</h1>
	<a href="conferma.jsp"><mark>HOME</mark></a> <a href="contattibiblio.jsp"><mark>CONTATTI</mark></a> <a href="help.jsp"><mark>HELP</mark></a><br><br>
		<form action="./insPrestito" method="post">
	<fieldset>
			<legend><h3>Dati prestito: </h3></legend><br>
			<p align ="left"><label>ID LIBRO: <input name="id_libro" type="text">
			ID UTENTE: <input name="id_utente" type="text">
			Data inzio : <input name="data_inizio" type="text">
			Data fine: <input name="data_fine" type="text">
			Note: <input name="note" type="text"></label></p>
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