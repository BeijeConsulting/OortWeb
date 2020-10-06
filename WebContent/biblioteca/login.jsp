<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="./css/myCss.css">
</head>
<body>
<%

String erroreMsg = (String) request.getSession().getAttribute("errore");
if (erroreMsg != null && erroreMsg.length() > 0) {
%>
	<div class="isa_error"><%= erroreMsg %></div>
<%
request.getSession().removeAttribute("errore");
}
%>
<div class="titolo">Login</div>
<div class="descrizione">Effettua il login per utilizzare le funzionalità del sito.</div>
<div class="form">
	<form action="./LoginBibliotecaServlet" method="POST">
		<fieldset>
			<div class="campi">
				<label for="emailInput">Email:</label><input id="emailInput" type="email" name="email">
				<label for="passwordInput">Password:</label><input id="passwordInput" type="password" name="password">
			</div>
			<div class="formButtons">
				<button class="buttonReset" type="reset">Resetta campi</button>
				<button name="submitContatto" class="buttonSubmit" type="submit">Cerca</button>
			</div>
		</fieldset>
	</form>
</div>
</body>
</html>