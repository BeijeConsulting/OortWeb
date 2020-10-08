<%@page import="it.beije.oort.madonia.biblioteca.ebeans.Autore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica autore</title>
<link rel="stylesheet" href="./css/myCss.css">
</head>
<body>
<jsp:useBean id="utenteAttivo" class="it.beije.oort.madonia.biblioteca.ebeans.Utente" scope="session" />

<%
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

if (utenteAttivo != null && utenteAttivo.isAdmin()) {
%>

<div class="titolo">Modifica autore</div>
<div class="descrizione">Prima di modificare devi selezionare un id, poi potrai modificare i valori dell'autore</div>
<div></div>
<div class="form borderForm">
	<form action="./ModificaAutoreForm" method="POST">
		<fieldset>
			<div class="campi">
				<label for="idInput">ID:</label><input id="idInput" type="text" name="id" value="<%= request.getSession().getAttribute("idAutoreSelezionato") != null ? (Integer) request.getSession().getAttribute("idAutoreSelezionato") : "" %>">
			</div>
			<div class="formButtons">
				<button name="submit" class="buttonSubmit" type="submit" value="id">Trova autore</button>
			</div>
		</fieldset>
		<% if(request.getSession().getAttribute("idAutoreSelezionato") != null && request.getSession().getAttribute("autoreSelezionato") != null) {
			Autore autore = (Autore) request.getSession().getAttribute("autoreSelezionato");
		%>
		<fieldset>
			<div class="campi">
				<input id="idInput" type="hidden" name="idAutore" value="<%= request.getSession().getAttribute("idAutoreSelezionato") %>">
				<label for="nomeInput">Nome:</label><input id="nomeInput" type="text" name="nome" value="<%= autore.getNome() == null ? "" : autore.getNome() %>"><br>
				<label for="cognomeInput">Cognome:</label><input id="cognomeInput" type="text" name="cognome" value="<%= autore.getCognome() == null ? "": autore.getCognome() %>"><br>
				<label for="dataNascitaInput">Data di nascita:</label><input id="dataNascitaInput" type="date" name="dataNascita" value="<%= autore.getDataNascita() == null ? null : autore.getDataNascita() %>"><br>
				<label for="dataMorteInput">Data di morte:</label><input id="dataMorteInput" type="date" name="dataMorte" value="<%= autore.getDataMorte() == null ? null : autore.getDataMorte() %>"><br>
				<label for="biografiaInput">Biografia:</label><input id="biografiaInput" type="text" name="biografia" value="<%= autore.getBiografia() == null ? "" : autore.getBiografia() %>">
			</div>
			<div class="formButtons">
				<button name="submit" class="buttonSubmit" type="submit" value="modifica">Modifica</button>
			</div>
		</fieldset>
		<% } %>
	</form>
</div>
<%
request.getSession().removeAttribute("idAutoreSelezionato");
request.getSession().removeAttribute("autoreSelezionato");
}
%>
</body>
</html>