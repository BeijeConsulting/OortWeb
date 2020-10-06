<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import= "it.beije.oort.rubrica.Contatto"%>
<%@page import= "it.beije.oort.sb.jpa.JPDBtools"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca Contatto</title>
</head>
<body>
	<form action="./ricercacontatto.jsp" method="post">
			ID&nbsp;<input type="text" name="id" value="" placeholder="1"/><br/>
			NOME&nbsp;<input type="text" name="nome" value="" placeholder="Mario"/><br/>
			COGNOME&nbsp;<input type="text" name="cognome" value="" placeholder="rossi"/><br/>
			TELEFONO&nbsp;<input type="text" name="telefono" value="" placeholder="1234567890"/><br/>
			EMAIL&nbsp;<input type="text" name="email" value="" placeholder="mariorossi@gmail.com"/><br/>
			<input type="submit" value="INVIO"/> <button type="reset">reset</button>
		</form>
	<% String id =(String)request.getParameter("id");
	if(id!=null){
		String[] listCampi = new String[8];
		List<String> listValori = new ArrayList<String>();
		List<Contatto> listContatti = new ArrayList<Contatto>();
		if(id!=""){ 
				listValori.add("id");
				listValori.add((String)request.getParameter("id"));
				listContatti = JPDBtools.listC(listValori);
		} else{ 
				JPDBtools.addTrim(listValori, "nome", (String)request.getParameter("nome"));
				JPDBtools.addTrim(listValori, "cognome", (String)request.getParameter("cognome"));
				JPDBtools.addTrim(listValori, "email", (String)request.getParameter("email"));
				JPDBtools.addTrim(listValori, "telefono", (String)request.getParameter("telefono"));

		}
		listContatti=JPDBtools.listC(listValori);
				for(Contatto c : listContatti) { %>
			<p> <b>Id</b> : <%= c.getId()%>  &nbsp;<b>Nome</b> : <%=c.getNome()%> &nbsp;<b>Cognome</b> : <%=c.getCognome()%> 
			 &nbsp;<b>Email</b> : <%=c.getEmail()%>  &nbsp;<b>Telefono</b> <%=c.getTelefono()%> </p>
		<% }} %>
</body>
</html>