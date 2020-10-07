<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>InsertLibro</title>
</head>
<body background="sfondo.jpg">
	<h1>Inserire nuovo libro!</h1>
		<form action="./inslibro" method="post">
	<fieldset>
			<legend><h3>Dati libro: </h3></legend><br>
			<p align ="left"><label>Titolo: <input name="titolo" type="text"> 
			Descrizione: <input name="descrizione" type="text">
			Autore(Num): <input name="autore" type="text">
			Editore(Num): <input name="editore" type="text">
			Anno: <input name="anno" type="text"></label></p>
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