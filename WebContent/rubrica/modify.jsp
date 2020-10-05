<%@ page import="it.beije.oort.web.database.DBReader" %>
<%@ page import="it.beije.oort.web.rubrica.Contatto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <h1><i>Modifica</i></h1>
            <h3>Modifica il Contatto</h3>
        </div>
    </div>

    <%
        String modified = request.getParameter("modified");
        if (modified != null && modified.equalsIgnoreCase("true")){ %>
    <p>Contatto modificato!</p>
    <p>Funziona ;)</p>
    <a href="rubricaIndex.html">Torna indietro.</a>
    <%
        } else if (modified != null && modified.equalsIgnoreCase("false")) {
    %>
    <p>Contatto non modificato :(</p>
    <a href="rubricaIndex.html">Torna indietro.</a>
    <%
        }
    %>

        <%
        int id;
        Contatto c = null;
        String idParam = request.getParameter("id");
        if (idParam != null){
            try{
                id = Integer.parseInt(idParam);
                c = DBReader.searchByID(id);
            } catch (Exception e){
                e.printStackTrace();
                c = null;
            }
        }
    %>

    <% if (c!=null){ %>

    <div class = "contatti-list rubrica-form">
        <form action="../contactModifier" method="post">
            <div class="single-input">
                <label for="nome">Nome: </label>
                <input type="text" placeholder="<%= c.getNome()  %>" id="nome" name="nome">
            </div>

            <div class="single-input">
                <label for="cognome">Cognome: </label>
                <input type="text" placeholder="<%= c.getCognome()  %>" id="cognome" name="cognome">
            </div>

            <div class="single-input">
                <label for="cell">Telefono: </label>
                <input type="tel" placeholder="<%= c.getCell()  %>" id="cell" name="cell">
            </div>

            <div class="single-input">
                <label for="email">Email: </label>
                <input type="email" placeholder="<%= c.getEmail()  %>" id="email" name="email">
            </div>
            <input type="hidden" value="<%= c.getId() %>" id="id" style="display:none" name="id">
            <div class="submit">
                <input type="submit" value="Modifica">
            </div>
        </form>
    </div>

    <% } %>
    <%
    if (modified == null && c == null){
    %>
    <img src="../media/404.gif"  alt="Qui non c'è niente!" style="margin-left: 25%;">
    <% } %>
</div>
</body>
</html>