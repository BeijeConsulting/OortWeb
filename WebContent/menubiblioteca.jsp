<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 	String login = (String)session.getAttribute("login");
	if(login!=null&&!login.equals("false")){ %>
		<h3>Questo è il menu</h3>
		<form action="./visualizzaprestiti.jsp" method="post">
			<input type="submit" value="PRESTITI"/>
		</form>	
		<form action="./catalogo.jsp" method="post">
		<input type="submit" value="CATALOGO">
		</form>
	<%} else response.sendRedirect("login.jsp");%>
	
	
</body>
</html>