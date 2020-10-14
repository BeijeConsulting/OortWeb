<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.oort.web.Utente" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test JSP Bean</title>
</head>
<body>

<jsp:useBean id="userBean" class="it.beije.oort.web.Utente" scope="session"/>
<jsp:setProperty property="nome" name="userBean" param="param_nome"/>
<jsp:setProperty property="cognome" name="userBean" param="param_cognome"/>

<%
/*
jsp:useBean scope="page"
Utente user = new Utente();
*/

/*
jsp:useBean scope="session"
Utente user = session.getAttribute("userBean");
if (user == null) {
	user = new Utente();
	user.setAttribute("userBean", user);
}
*/

/*
setProperty property="nome" name="contatto"
setProperty property="cognome" name="contatto

user.setNome = request.getParameter("param_nome");
user.setCognome = request.getParameter("param_cognome");
*/
%>

<h1>CIAO <%= (userBean.getNome() != null) ? userBean.getNome() : "" %> <%= (userBean.getCognome() != null) ? userBean.getCognome() : "" %></h1>

</body>
</html>