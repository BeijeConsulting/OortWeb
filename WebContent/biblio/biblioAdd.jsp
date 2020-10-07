<%@ page import="org.hibernate.dialect.Database" %>
<%@ page import="it.beije.oort.web.biblioteca.dbutils.DatabaseManager" %>
<%@ page import="it.beije.oort.web.biblioteca.model.Autore" %>
<%@ page import="java.util.List" %>
<%@ page import="it.beije.oort.web.biblioteca.model.Editore" %>
<%@ page import="it.beije.oort.web.biblioteca.model.Utente" %>
<%@ page import="it.beije.oort.web.biblioteca.model.Libro" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiungi</title>
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
        <form action="./biblioAdd.jsp">
            <div class="single-input selector">
                <label for="addType" style="text-align: center">Cosa vuoi Aggiungere?</label>
                <select id="addType" name="addType" onchange="this.form.submit()">
                    <option value="" disabled selected>Seleziona cosa vuoi aggiungere</option>
                    <option value="Libro">Libro</option>
                    <option value="Autore">Autore</option>
                    <option value="Editore">Editore</option>
                    <option value="Utente">Utente</option>
                    <option value="Prestito">Prestito</option>
                </select>
            </div>
        </form>

        <%
            String type = request.getParameter("addType");
            if (type != null && !type.equalsIgnoreCase("")){
                request.getSession().setAttribute("addType", type);
        %>
        <div class = "rubrica-form">
            <form action="../biblioAdd" method="post">
                <h3>Aggiungi <%=type%></h3>
                <%
                    switch (type){
                        case "Libro":
                %>
                <div class="single-input">
                    <label for="titolo">Titolo: </label>
                    <input type="text" name="titolo" id="titolo">
                </div>
                <div class="single-input">
                    <label for="desc">Descrizione: </label>
                    <textarea name="desc" id="desc" rows="4" cols="50"></textarea>
                </div>
                <div class="single-input">
                    <label for="anno">Anno di Pubblicazione: </label>
                    <input type="date" name="anno" id="anno">
                </div>

                <div class="single-input">
                    <label for="autore">Autore: </label>
                    <select id="autore" name="autore">
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
                            for (Libro l : libri){
                        %>
                        <option value="<%=l.getId()%>"><%=l.getTitolo()%></option>
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
                <%
                        break;
                    }
                %>
            <input type="submit" value="Aggiungi">
            </form>
        </div>
        <%
            }
        %>

    </div>
</div>

</body>
</html>
