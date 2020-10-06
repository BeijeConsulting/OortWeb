<%--
  Created by IntelliJ IDEA.
  User: Padawan09
  Date: 06/10/2020
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza</title>
</head>
<body>
<jsp:useBean id="utente" class="it.beije.oort.web.biblioteca.model.Utente" scope="session" />
<%
    if (utente.isAdmin()) {
        // mostra cose per amministratori, AKA mostra tutto
%>

<%
    } else {
        // mostra solo le cose che interessano all'utente.
        // libri e quant altro, ma prestiti solo i suoi
%>

<%
    }
%>
</body>
</html>
