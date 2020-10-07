<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../style/main.css" rel="stylesheet">
    <link href="../style/biblioView.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e8e37b0541.js" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href="../media/biblioteca.ico" />

</head>
<body>
<jsp:useBean id="utente" class="it.beije.oort.web.biblioteca.model.Utente" scope="session" />
    <%
    if (utente.getCodice_fiscale() == null) response.sendRedirect("./biblioLogin.jsp");
%>
<div class="home">
    <a href="../index.html"><i class="fas fa-home"></i></a>
</div>
<div class="container">
    <div class="small-center-container">
        <div class="header">
            <h1><i>Biblioteca</i></h1>
        </div>
        <form action="../searchModifier">
            <div class="single-input selector">
                <label for="searchType">Tabella da Cercare:</label>
                <select id="searchType" name="searchType" onchange="this.form.submit()">
                    <option disabled value="<%=  request.getSession().getAttribute("searchType") %>" selected>
                        <%=  request.getSession().getAttribute("searchType") != null
                                ?  request.getSession().getAttribute("searchType") : "Seleziona" %></option>
                    <option value="Libro">Libro</option>
                    <option value="Autore">Autore</option>
                    <option value="Editore">Editore</option>
                    <option value="Utente">Utente</option>
                    <option value="Prestito">Prestito</option>
                </select>
            </div>
        </form>
    <%
        System.out.println(request.getParameter("searchType"));
    %>
    <%
        if (request.getSession().getAttribute("searchType") != null){
            String type = (String) request.getSession().getAttribute("searchType");
    %>
    <form action="../searchModifier">
        <div class="single-input selector">
            <label for="searchField">Campo da Cercare:</label>
            <select id="searchField" name="searchField" onchange="this.form.submit()" >
                <%
                    switch (type){
                        case "Libro":
                %>
                <option <%
                    if (request.getSession().getAttribute("searchField") != null) {
                        String name = (String) request.getSession().getAttribute("searchField");
                        if (name.equalsIgnoreCase("l-id")) out.print("selected");
                    }
                %> value="l-id">ID</option>

                <option  <%
                    if (request.getSession().getAttribute("searchField") != null) {
                        String name = (String) request.getSession().getAttribute("searchField");
                        if (name.equalsIgnoreCase("l-titolo")) out.print("selected");
                    }
                %> value="l-titolo">Titolo</option>

                <option <%
                    if (request.getSession().getAttribute("searchField") != null) {
                        String name = (String) request.getSession().getAttribute("searchField");
                        if (name.equalsIgnoreCase("l-anno")) out.print("selected");
                    }
                %> value="l-anno">Anno di Pubblicazione</option>

                <option <%
                    if (request.getSession().getAttribute("searchField") != null) {
                        String name = (String) request.getSession().getAttribute("searchField");
                        if (name.equalsIgnoreCase("l-autore")) out.print("selected");
                    }
                %> value="l-autore">Autore</option>

                <option <%
                    if (request.getSession().getAttribute("searchField") != null) {
                        String name = (String) request.getSession().getAttribute("searchField");
                        if (name.equalsIgnoreCase("l-editore")) out.print("selected");
                    }
                %> value="l-editore">Editore</option>
                <%
                        break;
                        case "Autore":
                %>
                <option <%
                    if (request.getSession().getAttribute("searchField") != null) {
                        String name = (String) request.getSession().getAttribute("searchField");
                        if (name.equalsIgnoreCase("a-id")) out.print("selected");
                    }
                %> value="a-id">ID</option>

                <option <%
                    if (request.getSession().getAttribute("searchField") != null) {
                        String name = (String) request.getSession().getAttribute("searchField");
                        if (name.equalsIgnoreCase("a-nome")) out.print("selected");
                    }
                %>  value="a-nome">Nome</option>

                <option <%
                    if (request.getSession().getAttribute("searchField") != null) {
                        String name = (String) request.getSession().getAttribute("searchField");
                        if (name.equalsIgnoreCase("a-cognome")) out.print("selected");
                    }
                %> value="a-cognome">Cognome</option>

                <option <%
                    if (request.getSession().getAttribute("searchField") != null) {
                        String name = (String) request.getSession().getAttribute("searchField");
                        if (name.equalsIgnoreCase("a-nascita")) out.print("selected");
                    }
                %> value="a-nascita">Data di Nascita</option>

                <option <%
                    if (request.getSession().getAttribute("searchField") != null) {
                        String name = (String) request.getSession().getAttribute("searchField");
                        if (name.equalsIgnoreCase("a-morte")) out.print("selected");
                    }
                %> value="a-morte">Data di Morte</option>
                <%
                    break;
                    } // togliere questa parentesi se uncommento la parte qua sotto
                %>
<%--                <%--%>
<%--                    } // fine switch--%>
<%--                %>--%>
            </select>
        </div>
    </form>
    <%
        }
        // Fine if per field selector
    %>
    <%
        System.out.println(request.getSession().getAttribute("searchField") );
        if (request.getSession().getAttribute("searchField") != null){
            String field = (String) request.getSession().getAttribute("searchField");
    %>
    <form action="../doSearch" method="post">
        <label for="searchQuery">Query:</label>
    <%
            switch (field){
                case ("a-nascita"):
                case ("a-morte"):
                case ("l-anno"):
    %>
        <input type="date" id="searchQuery">
    <%
        break;
        default:
    %>
        <input type="text" placeholder="Cosa vuoi cercare?" id="searchQuery">
    <%
        } // fine switch
    %>
    </form>
    <%
        } // fine if
    %>

</div>
</div>
</body>
</html>
