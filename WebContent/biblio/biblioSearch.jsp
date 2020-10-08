<%@ page import="it.beije.oort.web.biblioteca.model.*" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ricerca</title>
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
                        if (name.equalsIgnoreCase("")) out.print("selected");
                    }
                    if (request.getSession().getAttribute("searchField") == null) out.print("selected");
                %> disabled>Seleziona</option>
                <option <%
                    if (request.getSession().getAttribute("searchField") != null) {
                        String name = (String) request.getSession().getAttribute("searchField");
                        if (name.equalsIgnoreCase("id")) out.print("selected");
                    }
                %> value="id">ID</option>

                <option  <%
                    if (request.getSession().getAttribute("searchField") != null) {
                        String name = (String) request.getSession().getAttribute("searchField");
                        if (name.equalsIgnoreCase("titolo")) out.print("selected");
                    }
                %> value="titolo">Titolo</option>

                <option <%
                    if (request.getSession().getAttribute("searchField") != null) {
                        String name = (String) request.getSession().getAttribute("searchField");
                        if (name.equalsIgnoreCase("anno_pubblicazione")) out.print("selected");
                    }
                %> value="anno_pubblicazione">Anno di Pubblicazione</option>

                <option <%
                    if (request.getSession().getAttribute("searchField") != null) {
                        String name = (String) request.getSession().getAttribute("searchField");
                        if (name.equalsIgnoreCase("id_autore")) out.print("selected");
                    }
                %> value="id_autore">ID Autore</option>

                <option <%
                    if (request.getSession().getAttribute("searchField") != null) {
                        String name = (String) request.getSession().getAttribute("searchField");
                        if (name.equalsIgnoreCase("id-editore")) out.print("selected");
                    }
                %> value="id_editore">ID Editore</option>
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
        <input type="date" id="searchQuery" name="searchQuery">
    <%
        break;
        default:
    %>
        <input type="text" placeholder="Cosa vuoi cercare?" id="searchQuery" name="searchQuery">
    <%
        } // fine switch
    %>
        <input type="submit" value="Cerca">
    </form>
    <%
        } // fine if
    %>

        <!-- test lista risultati -->
        <%
            if (request.getSession().getAttribute("results") != null){
                List<IBibliotecaModel> lista = (List<IBibliotecaModel>)request.getSession().getAttribute("results");
        %>
        <!-- qui stampo le liste -->
        <div class="contatti-list">
            <table>
                <%
                    // Inizia lo switch per stampare la lista corretta
                    switch ((String)request.getSession().getAttribute("searchType")){
                        // LIBRO
                        case "Libro":
                %>
                <tr>
                    <th>Titolo</th>
                    <th>Autore</th>
                    <th>Anno di Pubblicazione</th>
                    <th>Editore</th>
                    <th>Sinossi</th>
                </tr>
                <%
                    for (IBibliotecaModel obj : lista){
                        Libro l = (Libro) obj;
                        if (l.getId_autore() != null) {
                            Autore a = l.getAutore();
                        }
                        if (l.getId_editore()d() != null){
                            Editore e = l.getEditore();
                        }
                %>
                <tr>
                    <td><%= l.getTitolo()%></td>
                    <td><%
                        if (a != null){
                            out.print(
                                    (a.getNome() != null ? a.getNome() : "") + " " +
                                            (a.getCognome() != null ?  a.getCognome() : ""));
                        }
                    %></td>
                    <td><%
                        out.print(
                                l.getAnno_pubblicazione() != null ? l.getAnno_pubblicazione() : ""
                        );
                    %></td>
                    <td><%
                        if (e != null){
                            out.print(
                                    e.getNome()
                            );
                        }
                    %></td>
                    <td><%= l.getDescrizione() != null ? l.getDescrizione() : ""%></td>
                    <td>
                        <a id="open-modal-<%= l.getId()%>"
                           onclick="showSinossi('modal-<%= l.getId()%>', 'open-modal-<%= l.getId()%>', <%= l.getId()%>)">
                            <i class="far fa-file-alt"></i>
                        </a>
                    </td>
                    <td><a href="../destroy?classe=<%=l.getClass().getSimpleName()%>&id=<%=l.getId()%>"><i class="fas fa-minus-circle"></i></a></td>
                </tr>
                <%
                    }
                %>
                <%
                        break;
                    case "Autore":
                %>
                <tr>
                    <th>Nome</th>
                    <th>Cognome</th>
                    <th>Data di Nascita</th>
                    <th>Data di Morte</th>
                    <th>Biografia</th>
                </tr>
                <%
                    for (IBibliotecaModel obj : lista){
                        Autore a = (Autore) obj;
                %>
                <tr>
                    <td><%= a.getNome() != null ? a.getNome() : "" %></td>
                    <td><%= a.getCognome() != null ? a.getCognome() : "" %></td>
                    <td><%= a.getData_nascita() != null ? a.getData_nascita() : "" %></td>
                    <td><%= a.getData_morte() != null ? a.getData_morte() : ""%></td>
                    <td><%= a.getBiografia() != null ? a.getBiografia()  : ""%></td>
                    <td><a href="../destroy?classe=<%=a.getClass().getSimpleName()%>&id=<%=a.getId()%>"><i class="fas fa-minus-circle"></i></a></td>
                </tr>
                <%
                    }
                %>
                <%
                        break;
                    case "Editore":
                %>
                <tr>
                    <th>Nome</th>
                    <th>Descrizione</th>
                </tr>
                <%
                    for (IBibliotecaModel obj : lista){
                        Editore e = (Editore) obj;
                %>
                <tr>
                    <td><%= e.getNome() != null ? e.getNome() : "" %></td>
                    <td><%= e.getDescrizione() != null ? e.getDescrizione() : "" %></td>
                    <td><a href="../destroy?classe=<%=e.getClass().getSimpleName()%>&id=<%=e.getId()%>"><i class="fas fa-minus-circle"></i></a></td>
                </tr>
                <%
                    }
                %>
                <%
                        break;
                    case "Utente":
                %>
                <tr>
                    <th>Nome</th>
                    <th>Cognome</th>
                    <th>Email</th>
                    <th>Cellulare</th>
                    <th>Indirizzo</th>
                    <th>Codice Fiscale</th>
                </tr>
                <%
                    for (IBibliotecaModel obj : lista){
                        Utente a = (Utente) obj;
                %>
                <tr>
                    <td><%= a.getNome() != null ? a.getNome() : "" %></td>
                    <td><%= a.getCognome() != null ? a.getCognome() : "" %></td>
                    <td><%= a.getEmail() != null ? a.getEmail() : "" %></td>
                    <td><%= a.getCellulare() != null ? a.getCellulare() : ""%></td>
                    <td><%= a.getIndirizzo() != null ? a.getIndirizzo() : ""%></td>
                    <td><%= a.getCodice_fiscale() != null ? a.getCodice_fiscale()  : ""%></td>
                    <td><a href="../destroy?classe=<%=a.getClass().getSimpleName()%>&id=<%=a.getCodice_fiscale()%>"><i class="fas fa-minus-circle"></i></a></td>
                </tr>
                <%
                    }
                %>
                <%
                        break;
                    case "Prestito":
                %>
                <tr>
                    <th>Libro</th>
                    <th>Utente</th>
                    <th>Data Inizio Prestito</th>
                    <th>Data Fine Prestito</th>
                    <th>Note</th>
                </tr>
                <%
                    for (IBibliotecaModel obj : lista){
                        Prestito a = (Prestito) obj;
                %>
                <tr>
                    <td><%= a.getLibro().getTitolo() != null ? a.getLibro().getTitolo()  : "" %></td>
                    <td><%= a.getUtente().getCodice_fiscale() != null ? a.getUtente().getCodice_fiscale()  : "" %></td>
                    <td><%= a.getDataInizio() != null ? a.getDataInizio() : "" %></td>
                    <td><%= a.getDataFine() != null ? a.getDataFine() : ""%></td>
                    <td><%= a.getNote() != null ? a.getNote()  : ""%></td>
                    <td><a href="../destroy?classe=<%=a.getClass().getSimpleName()%>&id=<%=a.getId()%>"><i class="fas fa-minus-circle"></i></a></td>
                </tr>
                <%
                    }
                %>
                <%
                            // chiude switch
                    }
                %>

            </table>

            <%
                    // chiude if
                }
            %>


</div>
</div>
</body>
</html>
