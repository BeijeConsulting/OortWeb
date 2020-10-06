<%--
  Created by IntelliJ IDEA.
  User: Padawan09
  Date: 06/10/2020
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiungi</title>
</head>
<body>
<jsp:useBean id="utente" class="it.beije.oort.web.biblioteca.model.Utente" scope="session" />
<%
    if (!utente.isAdmin()) {
        response.sendRedirect("./biblioIndex.jsp");
    }
%>
</body>
</html>
