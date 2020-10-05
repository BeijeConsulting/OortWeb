<%@page import="it.beije.oort.madonia.db.DatabaseManagerRubrica"%>
<%@page import="it.beije.oort.madonia.rubrica.ebeans.Contatto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Rubrica - Ricerca contatti</title>
	<link rel="stylesheet" href="./css/myCss.css">
</head>
<body>
<%
String nome = request.getParameter("nome");
String cognome = request.getParameter("cognome");
String telefono = request.getParameter("telefono");
String email = request.getParameter("email");
%>
	<div class="titolo">Ricerca contatti</div>
	<div class="descrizione">Riempire i campi per filtrare su questi dati.</div>
	<div class="form borderForm">
		<form id="ricercaContatti" name="ricercaContatti" method="POST">
			<div class="campi">
				<label>Cognome:</label><input type="text" name="cognome">
				<label>Nome:</label><input type="text" name="nome">
				<label>Telefono:</label><input type="text" name="telefono">
				<label>Email:</label><input type="text" name="email">
			</div>
			<div class="formButtons">
				<button class="buttonReset" type="reset">Resetta campi</button>
				<button name="submitContatto" class="buttonSubmit" type="submit">Cerca</button>
			</div>
		</form>
	</div>
	<div class="alignRight">
		<button class="buttonNavigation" onclick="location.href='./MenuPrincipale.jsp'" type="button">Torna indietro</button>
	</div>
	
	<%
	if (nome != null && cognome != null && telefono != null && email != null) {
		List<Contatto> contatti = DatabaseManagerRubrica.ottieniListaContatti(nome + "%", cognome + "%", telefono + "%", email + "%");
	%>
		<div class="rTable">
                <div class="rTableRow">
                <div class="rTableHead"><strong>Cognome</strong></div>
                <div class="rTableHead"><strong>Nome</strong></div>
                <div class="rTableHead"><strong>Telefono</strong></div>
                <div class="rTableHead"><strong>Email</strong></div>
                </div>
	<%
		for(Contatto contatto : contatti) {
	%>
			<div class="rTableRow">
                <div class="rTableCell"><%= contatto.getCognome() %></div>
                <div class="rTableCell"><%= contatto.getNome() %></div>
                <div class="rTableCell"><%= contatto.getTelefono() %></div>
                <div class="rTableCell"><%= contatto.getEmail() %></div>
            </div>
	<%
		}
	%>

        </div>
	<%
	}
	%>
	
</body>
</html>