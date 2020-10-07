<%@page import="java.util.List"%>
<%@page import="it.beije.oort.web.db.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NUOVO PRESTITO</title>
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
	<form action = "./insertLoan" method = "post">
	CERCA&nbsp;<input type="text" name="libro" value="" placeholder="inserisci titolo"/>
	<input type="submit" value="INVIO"/><br/>
	</form>
	<% try { %>
	<% if (session.getAttribute("libro") == null || session.getAttribute("libro").equals("")) { %>
	<table>
          <tr>
            <th>Titolo</th>
            <th>Descrizione</th>
            <th>Anno</th>
          </tr>
          <% List<Libro> books = (List<Libro>)session.getAttribute("libri");
          	for (int i = 0; i < books.size(); i++) { %>
          		<tr><td><a href = "./insertLoan?title=<%=books.get(i).getTitolo() %>"><% out.print(books.get(i).getTitolo()); %></a></td> 
          			<td><% out.print(books.get(i).getDescrizione()); %></td>
          			<td><% out.print(books.get(i).getAnno()); %></td>
          		</tr>
          	<% } %>
        </table>
      <% } else { %>
      <table>
          <tr>
            <th>Titolo</th>
            <th>Descrizione</th>
            <th>Anno</th>
          </tr>
          <% Libro book = (Libro)session.getAttribute("libro"); %>
          		<tr> <td><a href = "./InsertLoanServlet?title=<%= book.getTitolo() %>"><% out.print(book.getTitolo()); %></a></td> 
          			<td><% out.print(book.getDescrizione()); %></td>
          			<td><% out.print(book.getAnno()); %></td>
          		</tr>
          	<% } %>
        </table>
      <% } catch (javax.persistence.NoResultException e) {%>
      	Il libro da te cercato non è nel nostro catalogo.
      <% } %>
</body>
</html>