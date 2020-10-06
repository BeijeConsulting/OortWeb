<%@ page import="it.beije.oort.web.biblioteca.model.Prestito" %>
<%@ page import="it.beije.oort.web.biblioteca.controller.DatabaseManager" %>
<%@ page import="java.util.List" %>
<%@ page import="it.beije.oort.web.biblioteca.model.Libro" %>
<%@ page import="it.beije.oort.web.biblioteca.model.Autore" %><%--
  Created by IntelliJ IDEA.
  User: Padawan09
  Date: 06/10/2020
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>I tuoi prestiti</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="../style/main.css" rel="stylesheet">
    <link href="../style/biblioView.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e8e37b0541.js" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href="../media/biblioteca.ico" />

</head>

<jsp:useBean id="utente" class="it.beije.oort.web.biblioteca.model.Utente" scope="session"/>

<body>
<div class="home">
    <a href="../index.html"><i class="fas fa-home"></i></a>
</div>
<div class="container">
    <div class="small-center-container">
        <div class="header">
            <h1><i><jsp:getProperty name="utente" property="nome"/> - I tuoi prestiti</i></h1>
        </div>
        <div class="contatti-list">
            <table>
                <tr>
                    <th>Libro</th>
                    <th>Autore</th>
                    <th>Data Inizio Prestito</th>
                    <th>Data Fine Prestito</th>
                    <th>Note</th>
                </tr>
                <!-- tabella riempita da Java -->
                <%
                    List<Prestito> prestiti = DatabaseManager.getPrestitiFromUser(utente.getCodice_fiscale());
                    System.out.println(prestiti);
                    if (prestiti != null && !prestiti.isEmpty()){
                        for (Prestito p : prestiti){
                            System.out.println(p);
                            Libro libro = (Libro)DatabaseManager.select(Libro.class, p.getIdLibro());
                            Autore autore = (Autore) DatabaseManager.select(Autore.class, libro.getId_autore());
                %>
                <tr>
                    <td><%= libro.getTitolo() %></td>
                    <td><%= autore.getNome() + " " + autore.getCognome() %></td>
                    <td><%= p.getDataInizio() %></td>
                    <td><%= p.getDataFine() == null ? "" : p.getDataFine()%></td>
                    <td><%= p.getNote() == null ? "" : p.getNote() %></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
        </div>
    </div>
</div>
</body>

</html>