<%@ page import="it.beije.oort.web.rubrica.Contatto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="it.beije.oort.web.database.DBReader" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Rubrica - Ricerca</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="../style/main.css" rel="stylesheet">
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
            <h1><i>Ricerca</i></h1>
            <h3>Cerca un contatto</h3>
        </div>

        <div class = "contatti-list">
            <form action="search.jsp" method="post">
                <label for="column">Campo:</label>
                <select name="column" id="column">
                    <option value="id">ID</option>
                    <option value="nome">Nome</option>
                    <option value="cognome">Cognome</option>
                    <option value="cell">Cellulare</option>
                    <option value="email">Email</option>
                </select>
                <input type="search" name="query" id="query" placeholder="Cerca">
                <input type="submit" value="Cerca">
            </form>
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

            String column = request.getParameter("column");
            String query = request.getParameter("query");

            List<Contatto> contatti = new ArrayList<>();

            if (column != null && query != null){
                if (column.equalsIgnoreCase("id")){
                    int id;
                    try {
                        id = Integer.parseInt(query);
                    } catch (Exception e){
                        id = -1;
                    }
                    Contatto c = DBReader.searchByID(id);
                    if (c != null) contatti.add(c);
                } else {
                    contatti = DBReader.searchBy(column, query);
                }
            }
        %>
        <% for (int i = (MAX_ENTRIES_PER_PAGE * pagina);
                i < (MAX_ENTRIES_PER_PAGE*(pagina+1)) && i < contatti.size(); i++) {
        %>
        <!-- tabella riempita da Java -->
        <tr>
            <td><%= contatti.get(i).getNome()%></td>
            <td><%= contatti.get(i).getCognome()%></td>
            <td><%= contatti.get(i).getCell()%></td>
            <td><%= contatti.get(i).getEmail()%></td>
            <td><a class="delete" href="../deleteContatto?id=<%= contatti.get(i).getId()%>"><i class="fas fa-minus-circle"></i></a></td>
            <td><a class="modify" href="modify.jsp?id=<%= contatti.get(i).getId()%>"><i class="fas fa-pen"></i></a></td>
        </tr>
        <% } %>
            </table>

            <% if (pagina < (contatti.size() / MAX_ENTRIES_PER_PAGE)){   %>
                <a href="search.jsp?page=<%= ++pagina %>&column=<%= column%>&query=<%= query%>" class = "pageLink" style="color: black">Successivo</a>
            <% } %>
        </div>
    </div>
</div>
</body>
</html>