<%@ page import="java.util.List" %>
<%@ page import="it.beije.oort.web.biblioteca.dbutils.DatabaseManager" %>
<%@ page import="it.beije.oort.web.biblioteca.model.*" %>
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
<%
    if (utente.isAdmin()) {
        // mostra cose per amministratori, AKA mostra tutto
%>

<div class="home">
    <a href="../index.html"><i class="fas fa-home"></i></a>
</div>
<div class="container">
    <div class="small-center-container">
        <div class="header">
            <h1><i>Biblioteca
                <% if (request.getSession().getAttribute("type") != null)
                    out.print("- " + request.getSession().getAttribute("type")); %>
            </i></h1>
            <h3>Leggi e Modifica le Tabelle della Biblioteca</h3>
        </div>
        <form action="../biblioViewController">
            <div class="single-input selector">
                <label for="type">Cosa vuoi visualizzare:</label>
                <select id="type" name="type" onchange="this.form.submit()">
                    <option value="" disabled selected>Seleziona cosa visualizzare</option>
                    <option value="Libro">Libri</option>
                    <option value="Autore">Autori</option>
                    <option value="Editore">Editori</option>
                    <option value="Utente">Utenti</option>
                    <option value="Prestito">Prestiti</option>
                </select>
            </div>
        </form>


        <%
            if (request.getSession().getAttribute("list") != null){
                List<? extends IBibliotecaModel> lista = (List<? extends IBibliotecaModel>)request.getSession().getAttribute("list");
                if (!lista.isEmpty()){
        %>
            <!-- qui stampo le liste -->
            <div class="contatti-list">
                <table>
                <%
                    // Inizia lo switch per stampare la lista corretta
                    switch ((String)request.getSession().getAttribute("type")){
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
                            Autore a = l.getAutore();
                            Editore e = l.getEditore();
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
                <!-- sezione dei modals -->
                <%
                    String type = (String)request.getSession().getAttribute("type");
                    if (type.equalsIgnoreCase("Libro")){
                        for (IBibliotecaModel obj : lista){
                            Libro l = (Libro) obj;
                %>
                <div id="modal-<%= l.getId()%>" class="modal">
                    <!-- Modal content -->
                    <div class="modal-content">
                        <span class="close">&times;</span>
                        <h3><%= l.getTitolo() %></h3>
                        <p><%= l.getDescrizione() %></p>
                    </div>
                </div>
                <%
                        }
                    }
                %>
        <%
            // chiude if
            }
            }
        %>
        </div>
    </div>
</div>


<%
    } else {
        // mostra solo le cose che interessano all'utente.
        // libri e quant altro, ma prestiti solo i suoi
%>

<%
    }
%>
</body>
<script>
    // Sinossi script
    function showSinossi(modalID, btnID, id){
        let modal = document.getElementById(modalID);

        let btn = document.getElementById(btnID);

        let span = document.getElementsByClassName("close")[id];

        btn.onclick = function () {
            modal.style.display = "block";
        }

        span.onclick = function () {
            modal.style.display = "none";
        }

        window.onclick = function (event) {
            if (event.target === modal) {
                modal.style.display = "none";
            }
        }
    }
</script>
</html>
