<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Admin Dashboard</title>
	<link rel="stylesheet" href="./css/myCss.css">
</head>
<body>
<jsp:useBean id="utenteAttivo" class="it.beije.oort.madonia.biblioteca.ebeans.Utente" scope="session" />
<%
if (utenteAttivo.getId() == 0) {
	request.getSession().setAttribute("errore", "Devi effettuare il login prima di accedere ai contenuti");
	response.sendRedirect("./login.jsp");
} else if (! utenteAttivo.isAdmin()) {
	request.getSession().setAttribute("errore", "Non hai i permessi per accedere alla pagina, sei stato reindirizzato su questa pagina.");
	response.sendRedirect("./Prestiti.jsp");
}
%>
	<div class="titolo">Admin Dashboard</div>
	<div class="descrizione">
		Benvenuto alla gestione del DB della biblioteca, scegli l'operazione da eseguire.
	</div>
	<div class="form">
		<div class="formButtons">
			<button class="buttonNavigation" onclick="location.href='./InserimentoAutore.jsp'" type="button">Inserimento Autore</button>
		<!-- 	<button class="buttonNavigation" type="button">Modifica e cancellazione contatti</button>
			<button class="buttonNavigation" onclick="location.href='./InserisciContatto.jsp'" type="button">Inserimento contatti</button>
			<button class="buttonNavigation" type="button">Export dati</button> -->
		</div>
	</div>
</body>
</html>