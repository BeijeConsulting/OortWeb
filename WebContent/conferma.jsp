<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalTime"%>
<%@page import="it.beije.oort.web.biblioteca.Utenti"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="sfondo.jpg">

<% String errore = (String)session.getAttribute("errore");
	if (errore != null && errore.length() > 0) {
	out.print("<b>"+errore+"</b><br/>");
	session.removeAttribute("errore");
}
%>


<%-- jsp:useBean id="userBean" class="it.beije.oort.web.Utente" scope="session"/--%>


<%
Utenti userBean = (Utenti)session.getAttribute("userBean");

if (userBean == null) {
%>
<b>DEVI PRIMA EFFETTUARE L'AUTENTICAZIONE, clicca <a href ="login.jsp"><mark>QUI</mark></a></b>

<%
} else {
%>
<%-- UTENTE: <jsp:getProperty property="nome" name="userBean"/> <jsp:getProperty property="cognome" name="userBean"/> --%>
<h1>Benvenuto,  <mark> <%= (userBean.getNome() != null) ? userBean.getNome() : "" %> <%= (userBean.getCognome() != null) ? userBean.getCognome() : "" %></mark> <h3><p align="right"><a href  ="login.jsp">ESCI</a></p></h3></h1>
<% LocalDateTime time = LocalDateTime.now();
%>
<p align="right"><mark><% out.print(time);%></mark></p>
<h3><p align="left"> Operazione che puoi effettuare:   <img src="https://www.gifanimate.com/data/media/53/libro-immagine-animata-0050.gif" border="0" alt="libro-immagine-animata-0050" /></h3>
<h4><p align ="left">1) Visualizzare <a href="./libri">LIBRI</a> - <a href="./autori">AUTORI</a> -  <a href="./editori">EDITORI</a></h4>
<h4><p align ="left">2) Inserire un nuovo: <a href="./redirectl">LIBRO</a> - <a href="./redirecta">AUTORE</a> - <a href="./redirecte">EDITORE</a></h4>
<h4><p align ="left">3) Eliminare un: <a href="./nodeL">LIBRO</a> - <a href="./nodeA">AUTORE</a> - <a href="./nodeE">EDITORE</a></h4>
<p align="right"><img src="http://i.stack.imgur.com/SBv4T.gif" alt="this slowpoke moves"  width=250/>

<%
}
%>
</body>
</html>