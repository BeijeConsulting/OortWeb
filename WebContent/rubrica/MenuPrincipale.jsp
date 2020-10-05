<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Rubrica - Menù Principale</title>
	<link rel="stylesheet" href="./css/myCss.css">
</head>
<body>
	<div class="titolo">Menù Principale</div>
	<div class="descrizione">
		Benvenuto alla gestione del DB della rubrica, scegli l'operazione da eseguire.
	</div>
	<div class="form">
		<div class="formButtons">
			<button class="buttonNavigation" onclick="location.href='./RicercaContatti.jsp'" type="button">Visualizzazione contatti</button>
			<button class="buttonNavigation" type="button">Modifica e cancellazione contatti</button>
			<button class="buttonNavigation" onclick="location.href='./InserisciContatto.jsp'" type="button">Inserimento contatti</button>
			<button class="buttonNavigation" type="button">Export dati</button>
		</div>
	</div>
</body>
</html>