<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="it.beije.oort.madonia.biblioteca.ebeans.Libro"%>
<%@page import="it.beije.oort.madonia.biblioteca.ebeans.Prestito"%>
<%@page import="java.util.List"%>
<%@page import="it.beije.oort.madonia.db.DatabaseManagerBiblioteca"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prestiti</title>
<link rel="stylesheet" href="./css/myCss.css">
</head>
<body>

	<jsp:useBean id="utenteAttivo"
		class="it.beije.oort.madonia.biblioteca.ebeans.Utente" scope="session" />
	<%
	String erroreMsg = (String) request.getSession().getAttribute("errore");
	if (erroreMsg != null && erroreMsg.length() > 0) {
	%>
	<div class="isa_error"><%=erroreMsg%></div>
	<%
		request.getSession().removeAttribute("errore");
	}
	%>

	<%
		if (utenteAttivo != null && utenteAttivo.getId() > 0) {
	%>

	<div class="titolo">Tuoi prestiti</div>
	<div class="descrizione">I prestiti che hai effettuato nella
		biblioteca</div>
	<div class="rTable">
		<div class="rTableRow">
			<div class="rTableHead">
				<strong>Libro</strong>
			</div>
			<div class="rTableHead">
				<strong>Data inizio</strong>
			</div>
			<div class="rTableHead">
				<strong>Data fine</strong>
			</div>
		</div>
		<%
		
		List<Prestito> listaPrestiti = (List<Prestito>) request.getSession().getAttribute("listaPrestiti");
		Map<Integer, String> mappaTitoli = (Map<Integer, String>) request.getSession().getAttribute("mappaTitoli");

		if (listaPrestiti != null && mappaTitoli != null) {

			for (Prestito prestito : listaPrestiti) {
				String titolo = null;
				titolo = mappaTitoli.get(prestito.getIdLibro());
		%>
		<div class="rTableRow">
			<div class="rTableCell"><%=titolo == null ? "" : titolo%></div>
			<div class="rTableCell"><%=prestito.getDataInizio() == null ? "" : prestito.getDataInizio()%></div>
			<div class="rTableCell"><%=prestito.getDataFine() == null ? "" : prestito.getDataFine()%></div>
		</div>
		<%
			}
		}
		request.getSession().removeAttribute("listaPrestiti");
		request.getSession().removeAttribute("mappaTitoli");
		}
		%>

	</div>

</body>
</html>