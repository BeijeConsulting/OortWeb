<%@page import="java.util.List"%>
<%@page import="it.beije.oort.web.db.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTRA NUOVO LIBRO</title>
<style>
        table {
          font-family: arial, sans-serif;
          border-collapse: collapse;
          width: 100%;
        }
        
        td, th {
          border: 1px solid #dddddd;
          text-align: left;
          padding: 8px;
        }
        
        tr:nth-child(even) {
          background-color: #dddddd;
        }
        </style>
</head>
<body>
	<form action = "./InsertBook" method = "POST">
        <table>
          <tr>
            <td>Titolo <input type = "text" name = "titolo" value = ""/></td>
          </tr>
          <tr>
            <td>Id Autore <input type = "text" name = "id_autore" value = ""/>
            Se l'autore non è presente nella lista <a href = "./InsertAuthorServlet">clicca qui</a></td>
          </tr>
          <tr>
            <td>Id Editore<input type = "text" name = "id_editore" value = ""/>
            Se l'editore non è presente nella lista <a href = "./InsertPublisherServlet">clicca qui</a></td>
          </tr>
          <tr>
            <td>Descrizione <input type = "text" name = "descrizione" value = "" placeholder = "facoltativo"/></td>
          </tr>
          <tr>
            <td>Anno <input type = "text" name = "anno" value = ""/></td>
          </tr>
          <tr>
            <td><input type = "submit" value = "INVIO"/></td>
          </tr>
        </table>
        </form>
     <a href = "./InsertBook?mostra=1">MOSTRA TABELLA AUTORI ED EDITORI</a>
     <% boolean mostra = (boolean)session.getAttribute("mostra");
     	if (mostra) { %>
     	<table>
          <tr>
            <th>Id Autore</th>
            <th>Autore</th>
          </tr>
          <% List<Autore> authors = (List<Autore>)session.getAttribute("autori"); %>
          <% for (int i = 0; i < authors.size(); i++) { %>
          <tr>
          	<td><% out.print(authors.get(i).getId()); %></td> 
          	<td><% out.print(authors.get(i).getNome() + " " + authors.get(i).getCognome()); %></td>
          </tr>
          	<% } %>
        </table><br/>
        <table>
          <tr>
            <th>Id Editore</th>
            <th>Editore</th>
          </tr>
          <% List<Editore> publishers = (List<Editore>)session.getAttribute("editori"); %>
          <% for (int i = 0; i < publishers.size(); i++) { %>
          <tr>
          	<td><% out.print(publishers.get(i).getId()); %></td> 
          	<td><% out.print(publishers.get(i).getDenominazione()); %></td>
          </tr>
          	<% } %>
        </table><br/>
      <% } %>
</body>
</html>