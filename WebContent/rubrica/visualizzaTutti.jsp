<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import= "it.beije.oort.web.girardi.rubrica.MethodServlet" %>
<%@ page import= "java.util.List" %>
<%@ page import= "it.beije.oort.web.girardi.rubrica.Contatto" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Visualizza tutti i contatti in rubrica</title>
	</head>
	<body>
		<a href="http://localhost:8080/OortWeb/rubrica/menu.html">Ritorna al menu iniziale</a>
		<br><br>
		<%
		List<Contatto> listContatti = MethodServlet.listContatti(); 
		StringBuilder strb = new StringBuilder("totale contatti: ");
		strb.append(listContatti.size());
		for (Contatto contatto : listContatti) 
			strb.append("<br>").append(contatto);
		out.print(strb);
		%>
	</body>
</html>