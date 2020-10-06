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

<jsp:useBean id="utenteAttivo" class="it.beije.oort.madonia.biblioteca.ebeans.Utente" scope="session" />

<%
if (utenteAttivo.getId() == 0) {
	request.getSession().setAttribute("errore", "Devi effettuare il login prima di accedere ai contenuti");
	response.sendRedirect("./login.jsp");
}

String erroreMsg = (String) request.getSession().getAttribute("errore");
if (erroreMsg != null && erroreMsg.length() > 0) {
%>
	<div class="isa_error"><%= erroreMsg %></div>
<%
request.getSession().removeAttribute("errore");
}
%>

<div class="titolo">Tuoi prestiti</div>
<div class="descrizione">I prestiti che hai effettuato nella biblioteca</div>

<%
List<Prestito> listaPrestiti = DatabaseManagerBiblioteca.trovaPrestiti(utenteAttivo);
%>
		<div class="rTable">
			<div class="rTableRow">
			<div class="rTableHead"><strong>Libro</strong></div>
			<div class="rTableHead"><strong>Data inizio</strong></div>
			<div class="rTableHead"><strong>Data fine</strong></div>
		</div>
	<%
		for(Prestito prestito : listaPrestiti) {
			String titolo = null;
			Libro libro = DatabaseManagerBiblioteca.trovaLibro(prestito.getIdLibro());
			
			if (libro != null) {
				titolo = libro.getTitolo();
			}
	%>
			<div class="rTableRow">
                <div class="rTableCell"><%= titolo %></div>
                <div class="rTableCell"><%= prestito.getDataInizio() == null ? "" : prestito.getDataInizio() %></div>
                <div class="rTableCell"><%= prestito.getDataFine() == null ? "" : prestito.getDataFine() %></div>
            </div>
	<%
		}
	%>

</div>

</body>
</html>