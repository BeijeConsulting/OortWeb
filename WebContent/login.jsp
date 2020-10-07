<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body background="sfondo.jpg">
<%
//String test = request.getParameter("test");
//System.out.print(test);

String errore = (String)session.getAttribute("errore");
if (errore != null && errore.length() > 0) {
	out.print("<b>"+errore+"</b><br/>");
	session.removeAttribute("errore");
}
%>
		<h3>Insere le credenziali di accesso: </h3>
		<form action="./authSerlvet" method="get">
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="user@domain.it"/> &nbsp;&nbsp;&nbsp;
 			PASSWORD&nbsp;<input type="password" name="password" value=""/> &nbsp;&nbsp;&nbsp;
			<input type="submit" value="INVIO"/>
		</form>
</body>
</html>