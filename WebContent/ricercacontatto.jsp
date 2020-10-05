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
	<form action="./ricercacontatto.jsp" method="get">
			ID&nbsp;<input type="text" name="id" value="" placeholder="1"/><br/>
			NOME&nbsp;<input type="text" name="nome" value="" placeholder="Mario"/><br/>
			COGNOME&nbsp;<input type="text" name="cognome" value="" placeholder="rossi"/><br/>
			TELEFONO&nbsp;<input type="text" name="telefono" value="" placeholder="rossi"/><br/>
			EMAIL&nbsp;<input type="text" name="email" value="" placeholder="mariorossi@gmail.com"/><br/>
			<input type="submit" value="INVIO"/> <button type="reset">reset</button>
		</form>
	<% String id =(String)request.getParameter("id");
	if(id!=null){
		String[] listCampi = new String[8];
		List<Contatto> listContatti = new ArrayList<Contatto>();
		if(id!=""){ 
				listContatti = JPDBtools.listC("id",(String)request.getParameter("id"));
		} else{ listCampi[0]=("nome"); listCampi[1]=((String)request.getParameter("nome"));
				listCampi[2]=("cognome"); listCampi[3]=((String)request.getParameter("cognome"));
				listCampi[4]=("telefono"); listCampi[5]=((String)request.getParameter("telefono"));
				listCampi[6]=("email"); listCampi[7]=((String)request.getParameter("email"));
		}
		listContatti=JPDBtools.listC(listCampi);
				for(Contatto c : listContatti) { %>
			<p> <b>Id</b> : <%= c.getId()%>  &nbsp;<b>Nome</b> : <%=c.getNome()%> &nbsp;<b>Cognome</b> : <%=c.getCognome()%> 
			 &nbsp;<b>Email</b> : <%=c.getEmail()%>  &nbsp;<b>Telefono</b> <%=c.getTelefono()%> </p>
		<% }} %>
</body>
</html>