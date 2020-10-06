<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Errore!</title>
</head>
<body>
    <h1>Errore.</h1>
    <br/>
    <p><b>Codice Errore:</b> ${pageContext.errorData.statusCode}</p>
    <p><b>Request URI:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p>
    <br/>
    <img src="${pageContext.request.contextPath}/media/404.gif" style="margin-left: 25%;" alt="404">
    <jsp:scriptlet>
        exception.printStackTrace(response.getWriter())
    </jsp:scriptlet>
</body>
</html>
