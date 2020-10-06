<%@ page import="it.beije.oort.web.model.Contatto" %>
<%@ page import="java.util.List" %>
<%@ page import="it.beije.oort.web.database.DBReader" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Rubrica - Contatti</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="../style/listView.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e8e37b0541.js" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href="../media/rubrica.ico"/>

</head>
<body>
<div class="home">
    <a href="../index.html"><i class="fas fa-home"></i></a>
</div>
<div class="container">
    <div class = "small-center-container">
        <div class="header">
            <h1><i>Contatti</i></h1>
            <h3>Elenco dei Contatti presenti in Rubrica</h3>
        </div>

        <div class = "contatti-list">
            <table>
                <tr>
                    <th>Nome</th>
                    <th>Cognome</th>
                    <th>Telefono</th>
                    <th>Email</th>
                </tr>

                <%
                    String sPage = request.getParameter("page");
                    int pagina;
                    if (sPage == null) pagina = 0;
                    else pagina = Integer.parseInt(sPage);
                    final int MAX_ENTRIES_PER_PAGE = 10;

                    List<Contatto> contattos = DBReader.getContatti();

                    for (int i = (MAX_ENTRIES_PER_PAGE * pagina);
                         i < (MAX_ENTRIES_PER_PAGE*(pagina+1)) && i < contattos.size(); i++) {
                        Contatto c = contattos.get(i);
                %>
                <!-- tabella riempita da Java -->
                <tr>
                    <td><%= c.getNome()%></td>
                    <td><%= c.getCognome()%></td>
                    <td><%= c.getCell()%></td>
                    <td><%= c.getEmail()%></td>
                    <td><a class="delete" href="../deleteContatto?id=<%= c.getId()%>"><i class="fas fa-minus-circle"></i></a></td>
                    <td><a class="modify" href="modify.jsp?id=<%= c.getId()%>"><i class="fas fa-pen"></i></a></td>
                </tr>
                <% } %>
            </table>
            <% if (pagina < (contattos.size() / MAX_ENTRIES_PER_PAGE)){   %>
                <a href="rubrica.jsp?page=<%= ++pagina %>" class = "pageLink" style="color: black">Successivo</a>
            <% } %>
        </div>
    </div>
</div>
<ul class="circles">
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
</ul>
</body>
</html>