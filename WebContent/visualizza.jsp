<%@page import="java.util.List"%>
<%@page import="it.beije.oort.web.db.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contatti Rubrica</title>
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
            <th>Nome</th>
            <th>Cognome</th>
            <th>Telefono</th>
            <th>Email</th>
          </tr>
          <% List<Contatto> contacts = JPDBUtilities.exportRecords(); 
          	for (int i = 0; i < contacts.size(); i++) { %>
          		<tr> <td><% out.print(contacts.get(i).getNome()); %></td> 
          			<td><% out.print(contacts.get(i).getCognome()); %></td>
          			<td><% out.print(contacts.get(i).getTelefono()); %></td>
          			<td><% out.print(contacts.get(i).getEmail()); %></td>
          		</tr>
          	<% } %>
        </table>
</body>
</html>