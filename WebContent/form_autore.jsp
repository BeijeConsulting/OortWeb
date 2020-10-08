<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSERISCI AUTORE</title>
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
	<form action = "./InsertAuthorServlet" method = "POST">
        <table>
          <tr>
            <td>Nome <input type = "text" name = "nome" value = ""/></td>
          </tr>
          <tr>
            <td>Cognome <input type = "text" name = "cognome" value = ""/></td>
          </tr>
          <tr>
            <td>Data di nascita <input type = "text" name = "data_nascita" value = ""/></td>
          </tr>
          <tr>
            <td>Data di morte <input type = "text" name = "data_morte" value = ""/></td>
          </tr>
           <tr>
            <td>Biografia <input type = "text" name = "biografia" value = ""/></td>
          </tr>
          <tr>
            <td><input type = "submit" value = "INVIO"/></td>
          </tr>
        </table>
        </form>
</body>
</html>