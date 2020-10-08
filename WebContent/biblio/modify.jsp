<%@ page import="org.hibernate.dialect.Database" %>
<%@ page import="it.beije.oort.web.biblioteca.dbutils.DatabaseManager" %>
<%@ page import="java.util.List" %>
<%@ page import="it.beije.oort.web.biblioteca.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifica</title>
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
    if (!utente.isAdmin()) {
        response.sendRedirect("./biblioIndex.jsp");
    }
%>

<div class="home">
    <a href="../index.html"><i class="fas fa-home"></i></a>
</div>
<div class="container">
    <div class="small-center-container">
        <div class="header">
            <h1>Biblioteca</h1>
        </div>
        <%
            String type = (String) request.getSession().getAttribute("modifyMeClass");
            IBibliotecaModel obj = (IBibliotecaModel) request.getSession().getAttribute("modifyMe");
            if (type != null && !type.equalsIgnoreCase("")){
        %>
        <div class = "rubrica-form">
            <form action="../update" method="post">
                <h3>Aggiungi <%=type%></h3>
                <%
                    switch (type){
                        case "Libro":
                            Libro l = (Libro) obj;
                %>
                <div class="single-input">
                    <label for="titolo">Titolo: </label>
                    <input type="text" name="titolo" id="titolo" placeholder="<%=l.getTitolo()%>">
                </div>
                <div class="single-input">
                    <label for="desc">Descrizione: </label>
                    <textarea name="desc" id="desc" rows="4" cols="50" placeholder="<%=l.getDescrizione()%>"></textarea>
                </div>
                <div class="single-input">
                    <label for="anno">Anno di Pubblicazione: </label>
                    <input type="date" name="anno" id="anno" placeholder="<%=l.getAnno_pubblicazione()%>">
                </div>

                <div class="single-input">
                    <label for="autore">Autore: </label>
                    <select id="autore" name="autore">
                        <%
                            if (l.getId_autore() != null && l.getId_autore() > 0){
                        %>
                        <option selected value="<%=l.getAutore().getId()%>"><%=l.getAutore().getNome() + " " + l.getAutore().getCognome()%></option>
                        <%
                            }
                        %>
                        <%
                            List<Autore> autori =
                                    (List<Autore>) DatabaseManager.findAll(Autore.class);
                            for (Autore a : autori){
                        %>
                        <option value="<%=a.getId()%>"><%=a.getNome() + " " + a.getCognome()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>

                <div class="single-input">
                    <label for="editore">Editore: </label>
                    <select id="editore" name="editore">
                        <%
                            if (l.getId_editore() != null && l.getId_editore() > 0){
                        %>
                        <option selected value="<%=l.getEditore().getId()%>"><%=l.getEditore().getNome()%></option>
                        <%
                            }
                        %>
                        <%
                            List<Editore> editori =
                                    (List<Editore>) DatabaseManager.findAll(Editore.class);
                            for (Editore e : editori){
                        %>

                        <option value="<%=e.getId()%>"><%=e.getNome()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <%
                        break;
                    case "Editore":
                %>
                <div class="single-input">
                    <label for="nome">Nome: </label>
                    <input type="text" name="nome" id="nome">
                </div>
                <div class="single-input">
                    <label for="descEditore">Descrizione: </label>
                    <input type="text" name="descEditore" id="descEditore">
                </div>
                <%
                        break;
                    case "Autore":
                %>
                <div class="single-input">
                    <label for="nomeAutore">Nome: </label>
                    <input type="text" name="nomeAutore" id="nomeAutore">
                </div>
                <div class="single-input">
                    <label for="cognomeAutore">Descrizione: </label>
                    <input type="text" name="cognomeAutore" id="cognomeAutore">
                </div>

                <div class="single-input">
                    <label for="autDataNasc">Anno di Nascita: </label>
                    <input type="date" name="autDataNasc" id="autDataNasc">
                </div>
                <div class="single-input">
                    <label for="autDataMorte">Anno di Morte: </label>
                    <input type="date" name="autDataMorte" id="autDataMorte">
                </div>
                <div class="single-input">
                    <label for="bio">Biografia </label>
                    <input type="text" name="bio" id="bio">
                </div>
                <%
                        break;
                    case "Prestito":
                %>
                <div class="single-input">
                    <label for="initPrestito">Inizio Prestito: </label>
                    <input type="date" name="initPrestito" id="initPrestito" required>
                </div>
                <div class="single-input">
                    <label for="finePrestito">Fine Prestito: </label>
                    <input type="date" name="finePrestito" id="finePrestito">
                </div>

                <div class="single-input">
                    <label for="prestitoUtente">Utente: </label>
                    <select id="prestitoUtente" name="prestitoUtente">
                        <%
                            List<Utente> utenti =
                                    (List<Utente>) DatabaseManager.findAll(Utente.class);
                            for (Utente e : utenti){
                        %>
                        <option value="<%=e.getCodice_fiscale()%>"><%=e.getNome() + " "
                                + e.getCognome() + " (" + e.getCodice_fiscale() + ")"%></option>
                        <%
                            }
                        %>
                    </select>
                </div>

                <div class="single-input">
                    <label for="prestitoLibro">Libro: </label>
                    <select id="prestitoLibro" name="prestitoLibro">
                        <%
                            List<Libro> libri =
                                    (List<Libro>) DatabaseManager.findAll(Libro.class);
                            for (Libro libroCarapace : libri){
                        %>
                        <option value="<%=libroCarapace.getId()%>"><%=libroCarapace.getTitolo()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>

                <div class="single-input">
                    <label for="note">Note </label>
                    <textarea name="note" id="note"></textarea>
                </div>
                <%
                        break;
                    case "Utente":
                %>
                <div class="single-input">
                    <label for="uNome">Nome: </label>
                    <input type="text" name="uNome" id="uNome">
                </div>
                <div class="single-input">
                    <label for="uCognome">Cognome: </label>
                    <input type="text" name="uCognome" id="uCognome">
                </div>
                <div class="single-input">
                    <label for="cf">Codice Fiscale: </label>
                    <input type="text" name="cf" id="cf" required>
                </div>
                <div class="single-input">
                    <label for="pass">Password: </label>
                    <input type="password" name="pass" id="pass" required>
                </div>
                <div class="single-input">
                    <label for="email">Email: </label>
                    <input type="text" name="email" id="email">
                </div>
                <div class="single-input">
                    <label for="cell">Cellulare: </label>
                    <input type="text" name="cell" id="cell">
                </div>
                <div class="single-input">
                    <label for="indirizzo">Indirizzo: </label>
                    <input type="text" name="indirizzo" id="indirizzo">
                </div>
                <div class="single-input">
                    <label for="isAdmin">Admin? </label>
                    <input type="checkbox" name="isAdmin" id="isAdmin">
                </div>
                <%
                            break;
                    }
                %>
                <input type="submit" value="Modifica">
            </form>
        </div>
        <%
            }
        %>

    </div>
</div>

</body>
</html>
