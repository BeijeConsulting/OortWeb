<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String errore = (String)session.getAttribute("errore");
	if (errore != null && errore.length() > 0) {
	out.print("<b>"+errore+"</b><br/>");
	session.removeAttribute("errore");
}%>
	<h3>INSERISCI LE TUE CREDENZIALI</h3>
	<form action="./authservlet" method="post">
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="utente@dominio"/><br/>
 			PASSWORD&nbsp;<input type="password" name="password" value=""/><br>
			<input type="submit" value="INVIO"/>
		</form>
</body>
</html>