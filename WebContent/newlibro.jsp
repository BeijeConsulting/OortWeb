<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuovo Libro</title>
</head>
<body>
<h3>Inserisci i valori del nuovo libro</h3>
<h4>Utilizza i link ipertestuali qua sotto per inserire gli id autore o editore corrispondente</h4>
<a href="autori.jsp">Autori</a>
<a href="editori.jsp">Editori</a>
<%--è incasinato con gli spazi perchè volevo grezzamente metterli sullo stesso piano.
	Esteticamente non è il massimo, l'avrei risolto cercando online un metodo per incolonnare le cose--%>
	<form action="./NuovoLibro" method="post">
	TITOLO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" value="" name="titolo" placeholder="La Divina Commedia"/><br>
	ID AUTORE&nbsp;&nbsp;<input type="text" value="" name="id_autore" placeholder="1"> <br>
	ID EDITORE&nbsp;&nbsp;<input type="text" value="" name="id_editore" placeholder="1"><br>
	ANNO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" value="" name="anno" placeholder="yyyy"><br>
	<input type="submit" value="INVIO"> <input type="reset" value="ANNULLA">
	</form>
	<form action="./Smistatore" method="get">
	<input type="submit" value="HOME" name="Menu">
	</form>
</body>
</html>