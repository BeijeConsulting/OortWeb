<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca per ID</title>
</head>
<body>
    <!-- <p>Per visualizzare un contatto inserisci il suo id</p> -->
    <!-- <form action="./RubricaContattoVisualizzaIdServlet" method="POST" target="_blank">
        ID&nbsp;<input type="text" name="id" value="" placeholder="id"/><br/>
        <input type="submit" value="INVIO"/>
    </form> -->
    <% 
    String nome = (String)session.getAttribute("nome");
    String cognome = (String)session.getAttribute("cognome"); 
    String telefono = (String)session.getAttribute("telefono");
    String email = (String)session.getAttribute("email");
    %>
    <p>Hai selezionato questo contatto:   </p>
    <p>nome: <%=nome %> </p>
    <p>cognome: <%=cognome%> </p>
    <p>telefono: <%=telefono %> </p>
    <p>email: <%=email %> </p>
</body>
</html>