<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1>Menu' Rubrica:</h1>
		<form action="inserimento.jsp" method="POST" >
			<button type="submit"> Inserisci contatto!</button>
		</form>	
		<br><br>	
		<form action="delete.jsp" method="POST">
			<button type ="submit"> Elimina contatto!</button> 
		</form>
		<br><br>
		<form action="show.jsp" method="POST">
			<button type="submit">Visualizza contatti!</button>
		</form>

</body>
</html>