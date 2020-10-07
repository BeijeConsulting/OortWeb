<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="sfondo.jpg">
	<h1>Inserire nuovo editore!</h1>
		<form action="./inseditore" method="post">
	<fieldset>
			<legend><h3>Dati editore: </h3></legend><br>
			<p align ="left"><label>Nome: <input name="denominazione" type="text"> 
			Descrizione: <input name="descrizione" type="text">
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