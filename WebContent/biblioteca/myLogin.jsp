<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!-- http://localhost:8080/OortWeb/biblioteca/myLogin.jsp -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<jsp:useBean id="userBean" class="it.beije.oort.web.girardi.biblioteca.Utente" scope="session"/>
		<jsp:setProperty property="nome" name="userBean" param="param_nome"/>
		<jsp:setProperty property="cognome" name="userBean" param="param_cognome"/>
		<%
		//la property è un campo di Utente
		
		/* scope="sesion" fa questo:
		jsp:useBean scope="session"
		Utente user = session.getAttribute("userBean");
		if (user == null) {
			user = new Utente();
			user.setAttribute("userBean", user);
		}
		*/
		%>

		<h3><em>"Una biblioteca è un luogo dove si impara ciò che gli insegnanti hanno 
		paura di insegnare." <br> Alan M. Dershowitz</em></h3><br>
		<br>
		<%		
		String errore = (String)session.getAttribute("errore");
		if (errore != null && errore.length() > 0) {
			out.print("<b>"+errore+"</b><br/>");
			session.removeAttribute("errore");
		}
		%>
		<h4>Prego effetuare il login:</h4>
		<form action="../autenticazione" method="post">
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="g@d.it"/><br/>
 			PASSWORD&nbsp;<input type="password" name="password" value=""/><br>
			<input type="submit" value="INVIO"/>
		</form>
</body>
</html>