<%@page import="it.beije.oort.madonia.db.DatabaseManagerRubrica"%>
<%@page import="it.beije.oort.madonia.rubrica.ebeans.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rubrica - Inserimento contatti</title>
<link rel="stylesheet" href="./css/myCss.css">
</head>
<body>

<jsp:useBean id="contatto" class="it.beije.oort.madonia.rubrica.ebeans.Contatto" scope="page" />
<jsp:setProperty property="nome" name="contatto"/>
<jsp:setProperty property="cognome" name="contatto"/>
<jsp:setProperty property="telefono" name="contatto"/>
<jsp:setProperty property="email" name="contatto"/>


<div class="titolo">Inserimento contatto</div>
<div class="descrizione">Inserire i campi del contatto da inserire.</div>
<div class="form borderForm">
	<form id="ricercaContatto" name="ricercaContatto" method="POST">
		<div class="campi">
			<label>Cognome:</label><input type="text" name="cognome">
			<label>Nome:</label><input type="text" name="nome">
			<label>Telefono:</label><input type="text" name="telefono">
			<label>Email:</label><input type="text" name="email">
		</div>
		<div class="formButtons">
			<button class="buttonReset" type="reset">Resetta campi</button>
			<button name="submitContatto" class="buttonSubmit" type="submit" value="true">Inserisci</button>
		</div>
	</form>
	<%
	String submit = request.getParameter("submitContatto");
	if (submit != null && submit.equals("true")) {

	try {
		DatabaseManagerRubrica.inserisciContatto(contatto);
	%>
		<div>Contatto inserito correttamente!</div>
		<div><label>Cognome: </label><%= contatto.getCognome() %></div>
		<div><label>Nome: </label><%= contatto.getNome() %></div>
		<div><label>Telefono: </label><%= contatto.getTelefono() %></div>
		<div><label>Email: </label><%= contatto.getEmail() %></div>
	<%
	} catch (Exception e) {
	%>
		<div>Il contatto non è stato inserito.</div>
	<%
	}
	}
	%>
	
</div>
<div class="form">
	<div class="alignRight">
		<button class="buttonNavigation" onclick="location.href='./MenuPrincipale.jsp'" type="button">Torna indietro</button>
	</div>
</div>
</body>
</html>