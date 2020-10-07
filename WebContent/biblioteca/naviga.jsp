<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Naviga</title>
</head>
<body>
		<h4>Selezionare il tipo di ricerca che si vuole effettuare:</h4>
		<form action="../NavigaSv" method = "get">
			<input type="radio" id="catalogo" name="naviga" value="catalogo">
			<label for="catalogo">Visualizza catalogo libri</label><br>
			
			<input type="radio" id="campi" name="naviga" value="campi">
			<label for="campi">Ricerca libri per titolo, autore o editore</label><br>

			<input type="radio" id="id" name="naviga" value="id">
			<label for="id">Ricerca libro tramite id</label><br>
			
			<input type="submit" value="Invio"><br>
		</form> 
		<br>
		<p> ritorna all' homepage:  </p>
		<form action="http://localhost:8080/OortWeb/biblioteca/homepage.jsp" >
			<input type="submit" value="homepage">
		</form> 
	</body>
</html>