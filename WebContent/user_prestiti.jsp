<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.beije.oort.web.db.*"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PRESTITI UTENTE</title>
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
	<table>
          <tr>
            <th>Libro</th>
            <th>Data inizio prestito</th>
            <th>Data restituzione</th>
          </tr>
          <% List<Prestito> userLoans = (List<Prestito>)session.getAttribute("userLoans");
          	List<Libro> books = (List<Libro>) session.getAttribute("libri");
          	for (int i = 0; i < userLoans.size(); i++) { %>
          		<tr><td><% out.print(books.get(i).getTitolo()); %></td> 
          			<td><% out.print(userLoans.get(i).getData_inizio()); %></td>
          			<td><% out.print(userLoans.get(i).getData_fine()); %></td>
          		</tr>
          	<% } %>
        </table>
</body>
</html>