<%@page import="it.beije.oort.sb.jpa.JPDBtools"%>
<%@page import="it.beije.oort.sb.biblioteca.Autori"%>
<%@page import="it.beije.oort.sb.biblioteca.Libri"%>
<%@page import="it.beije.oort.sb.biblioteca.Editori"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo Biblioteca Oort</title>
</head>
<body>
		
		<% 	String aut = request.getParameter("Autore");
			String edit = request.getParameter("Editore");
			List<Libri> catalogo;
			if (aut==null && edit==null || (aut.equals(edit) && aut.equals(""))){ %>
		<h2>Questi sono tutti i libri presenti in catalogo</h2>
		<% catalogo = JPDBtools.catalogoLibri();
			} else { 
			catalogo = JPDBtools.catalogoLibriPersonalizzato(Integer.parseInt(aut), Integer.parseInt(edit));	
			%>
			<h2>Questi sono  i libri presenti in catalogo con quelle caratteristiche</h2>
			
		<%} for(Libri l : catalogo){ 
			Autori autore = JPDBtools.ricercaAutore(l.getAutore());
			Editori editore = JPDBtools.ricercaEditore(l.getEditore()); %>
			<p><b>ID</b> <%=l.getId() %> <b>Titolo</b> <%=l.getTitolo() %> <b>Autore</b> <%=autore.getNome() %> <%= autore.getCognome()%>
			<b>Editore</b>	<%=editore.getDenominazione() %> <b>Anno</b> <%=l.getAnno() %> </p>
			<%} %>
			<h4>Per una ricerca personalizzata</h4>	
			<form action="" method="post">
			IDAUTORE&nbsp;<input type ="text" name = "Autore" value ="0" placeholder="1">
			IDEDITORE&nbsp;<input type ="text" name = "Editore"  value ="0" placeholder="1">		
			<input type="submit" value="INVIO">
			</form>
			<form action="./menubiblioteca.jsp" method="post">
			<input type="submit" value="HOME">
			</form>
			
</body>
</html>