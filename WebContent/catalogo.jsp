<%@page import="java.time.LocalDate"%>
<%@page import="it.beije.oort.sb.jpa.JPDBtools"%>
<%@page import="it.beije.oort.sb.biblioteca.Autori"%>
<%@page import="it.beije.oort.sb.biblioteca.Libri"%>
<%@page import="it.beije.oort.sb.biblioteca.Editori"%>
<%@page import="it.beije.oort.sb.biblioteca.Prestiti"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo Biblioteca Oort</title>
</head>
<body background ="libro.jpg">
		
		<% 	if(session.getAttribute("richiestaCatalogo").equals("off")){
			List<Libri> catalogo = (List<Libri>)session.getAttribute("catalogo");		
			%>
			<h2>Questi sono  i libri presenti in catalogo con quelle caratteristiche</h2>			
		<%	 for(Libri l : catalogo){ 
			Autori autore = JPDBtools.ricercaAutore(l.getAutore());
			Editori editore = JPDBtools.ricercaEditore(l.getEditore());
			String disponibilita = "Non disponibile";
			%>
			<p><b>ID</b> <%=l.getId() %> <b>Titolo</b> <%=l.getTitolo() %> <b>Autore</b> <%=autore.getNome() %> <%= autore.getCognome()%>
			<b>Editore</b>	<%=editore.getDenominazione() %> <b>Anno</b> <%=l.getAnno() %>
			<%for(Prestiti p : JPDBtools.ricercaPrestitiId("libro", l.getId())){
				if(p.getData_fine()!=null &&p.getData_fine().isBefore(java.time.LocalDate.now()))
					disponibilita = "Disponibile";
				else disponibilita = "Non disponibile"; }%> 
				<b>Disponibilità</b> <%=disponibilita %></p>			
			<%} } %>
			<h3>Inserisci gli id per i quali vuoi cercare i libri</h3>
			<h4>Inserisci 0 per omettere il campo corrispondente nella ricerca</h4>	
			<a href="autori.jsp">Autori</a>
			<a href="editori.jsp">Editori</a>
			<form action="./Catalogo" method="post">
			ID AUTORE&nbsp;<input type ="text" name = "Autore" value ="0" placeholder="1">
			ID EDITORE&nbsp;<input type ="text" name = "Editore"  value ="0" placeholder="1">		
			<br><input type="submit" value="INVIO">
			</form>
			
			<form action="./Smistatore" method="get">
			<input type="submit" value="HOME" name="Menu">
			</form>
			<%--if(session.getAttribute("admin").equals("on")){ --%>
			<form action="./Smistatore" method="get">
			<input type="submit" value="NewPrestito" name="NewPrestito">
			</form>
			<%--=} --%>
</body>
</html>