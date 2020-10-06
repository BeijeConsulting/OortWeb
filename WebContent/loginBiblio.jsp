<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Oort Biblioteca</title>
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

	<h2>Effettuare il login.</h2>
	
		<h3>Inserisci le tue credenziali</h3>
		<form action="./Autenticazione" method="post">
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="user@domain.it"/><br/>
 			PASSWORD&nbsp;<input type="password" name="password" value=""/><br>
			<input type="submit" value="INVIO"/>
		</form>
</body>
</body>
</html>