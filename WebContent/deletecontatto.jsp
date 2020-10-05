<%@page import= "it.beije.oort.rubrica.Contatto"%>
<%@page import= "it.beije.oort.sb.jpa.JPDBtools"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Contatto</title>
</head>
<body>
	<% 	for(Contatto c : JPDBtools.listContatto("", "")) { %>
		<p> <b>Id</b> : <%= c.getId()%>  &nbsp;<b>Nome</b> : <%=c.getNome()%> &nbsp;<b>Cognome</b> : <%=c.getCognome()%> 
		 &nbsp;<b>Email</b> : <%=c.getEmail()%>  &nbsp;<b>Telefono</b> <%=c.getTelefono()%> </p>
	<% } %>
	<form action='./rubricaServlet' method='get'>
	DIGITA L'INDICE DEL CONTATTO DA CANCELLARE&nbsp;<input type='text' name='indice' value='' placeholder='1'/><br/>
	<input type='submit' value='INVIO'/> <button type='reset'>Annulla</button></form>
</body>
</html>