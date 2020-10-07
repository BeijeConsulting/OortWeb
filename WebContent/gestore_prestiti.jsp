<%@page import="java.util.List"%>
<%@page import="it.beije.oort.web.db.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GESTISCI PRESTITI</title>
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
<form action = "./LoansManager" method = "post">
	PRESTITO N.&nbsp;<input type="number" name="loanID" value="" placeholder="numero prestito"/>
	NOTE&nbsp;<input type="text" name="nota" value="" placeholder="inserisci nota"/>
	<input type="submit" value="INVIO"/><br/>
	</form>
	<table>
          <tr>
          	<th>Prestito N.</th>
            <th>Titolo</th>
            <th>Data inizio prestito</th>
            <th>Data restituzione</th>
            <th>Note</th>
            <th>User Id</th>
            <th></th>
          </tr>
          <% List<Prestito> loans = (List<Prestito>)session.getAttribute("loans");
          	List<String> titles = (List<String>)session.getAttribute("titles");
          	for (int i = 0; i < loans.size(); i++) { %>
          		<tr>
          			<td><% out.print(loans.get(i).getId()); %></td>
          			<td><% out.print(loans.get(i).getId_libro()); %></td> 
          			<td><% out.print(loans.get(i).getData_inizio()); %></td>
          			<td><% out.print(loans.get(i).getData_fine()); %></td>
          			<td><% out.print(loans.get(i).getNote()); %></td>
          			<td><% out.print(loans.get(i).getId_utente()); %></td>
          			<td><a href = "./LoansManager?rimuovi=1&idloan=<%= loans.get(i).getId() %>">Rimuovi</a></td>
          		</tr>
          	<% } %>
        </table>
</body>
</html>