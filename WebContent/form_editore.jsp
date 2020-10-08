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
	<form action = "./InsertPublisherServlet" method = "POST">
        <table>
          <tr>
            <td>Denominazione <input type = "text" name = "denominazione" value = ""/></td>
          </tr>
          <tr>
            <td>Descrizione <input type = "text" name = "descrizione" value = ""/></td>
          </tr>
          <tr>
            <td><input type = "submit" value = "INVIO"/></td>
          </tr>
        </table>
        </form>
</body>
</html>