<%@page import="it.beije.oort.sb.biblioteca.Utenti"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OortBiblioteca</title>
</head>
<body background="sfondo2.jpg">

<%-- stringa con cui mostro messaggi di errore o di conferma --%>
<% 	String errore = (String)session.getAttribute("errore");
	if(errore!=null) { %>
	<h3><%=errore %></h3>
	<% session.removeAttribute("errore"); 
	} 
	String login = (String)session.getAttribute("login");
	if(login!=null&&!login.equals("false")){ %>
	<%-- controllo se ha fatto il login o meno  --%>
		<h3>Benvenuto <%=((Utenti)session.getAttribute("utente")).getNome() %> <%=((Utenti)session.getAttribute("utente")).getCognome() %></h3>
		<form action="./Smistatore" method="get">
		<input type="submit" value="PRESTITI" name="Prestiti"/>
		</form>	
		<form action="./Smistatore" method="get">
		<input type="submit" value="CATALOGO" name ="Catalogo">
		</form>
		<form action="./Smistatore" method="get">
		<input type="submit" value="LOGOUT" name ="Logout">
		</form>
		<%if(((String)session.getAttribute("admin")).equals("on")) { %>
		<h3>Menu Admin</h3>
			<form action="./Smistatore" method="get">
			<input type="submit" value="ListaUtenti" name ="CatalogoUtenti">
			</form>
			<form action="./Smistatore" method="get">
			<input type="submit" value="NewPrestito" name="NewPrestito"/>
			</form>	
			<form action="./Smistatore" method="get">
			<input type="submit" value="NewAutore" name ="NewAutore">
			</form>
			<form action="./Smistatore" method="get">
			<input type="submit" value="NewUtente" name ="NewUtente">
			</form>
			<form action="./Smistatore" method="get">
			<input type="submit" value="NewEditore" name ="NewEditore">
			</form>
			<form action="./Smistatore" method="get">
			<input type="submit" value="NewLibro" name="NewLibro"/>
			</form>	
			<form action="./Smistatore" method="get">
			<input type="submit" value="DeleteLibro" name ="DeleteLibro">
			</form>
		<%} %>
	<%} else {%>
	<h3>Devi fare il login</h3>
	<form action= "./Smistatore" method="get">
	<input type="submit" value= "LOGIN" name="Login"/>
	</form>
	<%} %>
	
	
</body>
</html>