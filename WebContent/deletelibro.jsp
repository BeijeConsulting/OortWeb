<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminazione Record Libro</title>
</head>
<body>
<h4>Per vedere i libri presenti nel catalogo</h4>
<form action="./Smistatore" method="get">
<input type="submit" value="CATALOGO" name ="Catalogo">
</form>
<form action="./DeleteLibro" method="post">
ID LIBRO <input type="text" value="" name="id_libro" placeholder="1">
<input type="submit" value="INVIO">
</form>
<form action="./Smistatore" method="get">
<input type="submit" value="HOME" name ="Menu">
</form>
</body>
</html>