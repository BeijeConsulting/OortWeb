<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Prestito</title>
</head>
<body>
		<form action="./Smistatore" method="get">
		<input type="submit" value="CatalogoLibri" name ="Catalogo">
		</form>
		<form action="./Smistatore" method="get">
		<input type="submit" value="ListaUtenti" name ="CatalogoUtenti">
		</form>
<form action="./NuovoPrestito" method="post">
	ID UTENTE <input type="text" value="" name="IdUtente" placeholder="1"/><br>
	ID LIBRO <input type="text" value="" name="IdLibro" placeholder="1"/><br>
	NOTE <input type="text" value="" name="Note" placeholder="info"/><br>
	DATA INIZIO <input type="text" value="" name="Data_Inizio" placeholder="yyyy-MM-dd"/>
	DATA FINE <input type="text" value="" name="Data_Fine" placeholder="yyyy-MM-dd"/><br>
	<input type="submit" value="INVIO"/> <input type="reset" value="ANNULLA"/>
</form>
</body>
</html>