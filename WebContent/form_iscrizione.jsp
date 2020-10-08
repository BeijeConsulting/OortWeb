<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./IscrizioneServlet" method="post">
			COGNOME&nbsp;<input type="text" name="cognome" value=""/><br>
 			NOME&nbsp;<input type="text" name="nome" value=""/><br>
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="utente@dominio"/><br/>
 			PASSWORD&nbsp;<input type="password" name="password" value=""/><br>
			<input type="submit" value="INVIO"/>
		</form><br/>
</body>
</html>