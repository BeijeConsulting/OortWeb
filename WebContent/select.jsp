<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
        <input type>
            <div>
                <select name="field" id="field">
                    <option value="nome">Nome</option>
                    <option value="cognome">Cognome</option>
                    <option value="telefono">Email</option>
                    <option value="email">Telefono</option>
                </select>
            </div>
            <div>
                <input type="search" name="value" placeholder="Search box...">
            </div>
            <br>
            <button type="submit">Search</button>
        </form>
        
    </body>
</html>