<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<%
//String test = request.getParameter("test");
//System.out.print(test);

String errore = (String)session.getAttribute("errore");
if (errore != null && errore.length() > 0) {
	out.print("<b>"+errore+"</b><br/>");
	session.removeAttribute("errore");
}
%>
		<h3>Inserisci le tue credenziali</h3>
		<form action="./verifica.jsp" method="post">
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="user@domain.it"/><br/>
 			PASSWORD&nbsp;<input type="password" name="password" value=""/><br>
			<input type="submit" value="INVIO"/>
		</form>
		<h4>Se vuoi visualizzare il catalogo</h4>		
		<form action="./catalogo.jsp" method="post">
		<input type="submit" value="CATALOGO">
		</form>
		
</body>
</html>