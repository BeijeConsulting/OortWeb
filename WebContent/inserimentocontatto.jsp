<%@page import= "it.beije.oort.rubrica.Contatto"%>
<%@page import= "it.beije.oort.sb.jpa.JPDBtools"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Contatto</title>
<style>
		</style>
	</head>
	<body>
		<h3>Inserisci i dati</h3>
		<form action="" method="POST">
			COGNOME&nbsp;<input type="text" name="cognome" value="" placeholder="Bianchi"/><br/>
 			NOME&nbsp;<input type="text" name="nome" value="" placeholder="Marco"/><br>
 			TELEFONO&nbsp;<input type="text" name="telefono" value="" placeholder="3211233219"/><br/>
 			EMAIL&nbsp;<input type="text" name="email" value="" placeholder="mariorossi@gmail.com"/><br>
			<input type="submit" value="INVIO"/> <button type="reset">Annulla</button>
			
			<%	if(request.getParameter("nome")!=null) {
				Contatto c = new Contatto();
				c.setNome(request.getParameter("nome"));
				c.setCognome(request.getParameter("cognome"));
				c.setTelefono(request.getParameter("telefono"));
				c.setEmail(request.getParameter("email"));	
				JPDBtools.insert(c, "OortRubrica");
				%> <p>Contatto inserito in fondo alla rubrica</p>
				<%} %>
		
		</form>
	</body>
</html>
