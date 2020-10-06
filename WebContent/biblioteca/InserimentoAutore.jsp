<%@page import="it.beije.oort.madonia.biblioteca.ebeans.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento autore</title>
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

String erroreMsg = (String) request.getSession().getAttribute("errore");
String successMsg = (String) request.getSession().getAttribute("success");
if (erroreMsg != null && erroreMsg.length() > 0) {
%>
	<div class="isa_error"><%= erroreMsg %></div>
<%
request.getSession().removeAttribute("errore");
}

if (successMsg != null && successMsg.length() > 0) {
%>
	<div class="isa_success"><%= successMsg %></div>
<%
request.getSession().removeAttribute("success");
}
%>

<div class="titolo">Inserimento autore</div>
<div class="descrizione">Metti i dati per poter inserire l'autore</div>
<div class="form borderForm">
	<form action="./InserimentoAutoreServlet" method="POST">
		<fieldset>
			<div class="campi">
				<label for="nomeInputInserimento">Nome:</label><input id="nomeInputInserimento" type="text" name="nome"><br>
				<label for="cognomeInputInserimento">Cognome:</label><input id="cognomeInputInserimento" type="text" name="cognome"><br>
				<label for="dataNascitaInputInserimento">Data di nascita:</label><input id="dataNascitaInputInserimento" type="date" name="dataNascita"><br>
				<label for="dataMorteInputInserimento">Data di morte:</label><input id="dataMorteInputInserimento" type="date" name="dataMorte"><br>
				<label for="biografiaInputInserimento">Biografia:</label><input id="biografiaInputInserimento" type="text" name="biografia">
			</div>
			<div class="formButtons">
				<button class="buttonReset" type="reset">Resetta campi</button>
				<button name="submitInserimento" class="buttonSubmit" type="submit">Inserisci</button>
			</div>
		</fieldset>
	</form>
</div>
</body>
</html>