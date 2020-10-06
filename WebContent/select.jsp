<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="it.beije.oort.sala.web.beans.Contatto" %>
<%@ page import="it.beije.oort.sala.web.db.JPAToolset" %>
<%@ page import="java.util.List" %>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Select</title>
</head>
<body>
	<header style="margin-left: 2em; display: flex;">
        <div style="width: 70%;"> 
	        <h1>Search tool</h1>
	        <p>Select the field to be filtered, insert the filter in the text box and hit 'search' to start researching.</p>
        </div>
       <div style="width: 30%;"> 
               <form action="/OortWeb/index.html" method="GET" autocomplete="off" style="margin-left: 2em;">
                   <button type="submit" style="float: right;">Go back to Homepage </button>
               </form>
           </div>
    </header>
        <form method="GET" autocomplete="off" action="/OortWeb/select.jsp" style="margin-left: 2em;">
            <div>
                <select name="field" id="field">
                    <option value="nome">Nome</option>
                    <option value="cognome">Cognome</option>
                    <option value="telefono">Email</option>
                    <option value="email">Telefono</option>
                </select>
            </div>
            <div>
                <input type="search" name="value" value="" placeholder="Search box...">
            </div>
            <br>
            <button type="submit">Search</button>
        </form>
        <% if(request.getParameter("value") != null && !request.getParameter("value").equals("")) {
        	List<Object> temp = JPAToolset.selectJPA("Contatto",
        								(String)request.getParameter("field"),
        								(String)request.getParameter("value"));
        	out.print("<ul>");
        	for(Object o : temp){
        		Contatto c = (Contatto)o;
        		out.print("<li>"+c.toStringFromDatabase()+"</li>");
        	}
        	out.print("</ul>");    	
        } else if(request.getParameter("value") != null && request.getParameter("value").equals("")) {
        	out.print("<p style=\"color: red;\">Inserire un filtro (anche un solo carattere/numero va bene)</p>");
        }
        %>
    </body>
</html>