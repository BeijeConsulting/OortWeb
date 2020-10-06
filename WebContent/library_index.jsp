<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.oort.bm.library.*" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Web Library</title>
		<link rel = "stylesheet" type = "text/css" href = "library_style.css">
	</head>
	<body>
		<% %>
		<div id = "head">
			<h1>Welcome to Brando's Magical Library</h1>
		</div>
		<div id = "navbar">
			<ul>
				<li>
					<form action="./dispatch" method="get">
						<input type="hidden" name="res" value="books">
						<input type="submit" value="Books"/>
					</form>
				</li>
				<li>
					<form action="./dispatch" method="get">
						<input type="hidden" name="res" value="authors">
						<input type="submit" value="Authors"/>
					</form>
				</li>
				<li>
					<form action="./dispatch" method="get">
						<input type="hidden" name="res" value="publish">
						<input type="submit" value="Publishers"/>
					</form>
				</li>
				<li>
					<form action="./dispatch" method="get">
						<input type="hidden" name="res" value="loans">
						<input type="submit" value="Loans"/>
					</form>
				</li>
				<li class = "rightli">
					<form action="./dispatch" method="get">
						<input type="hidden" name="res" value="login">
						<input type="submit" value="Login"/>
					</form>
				</li>
			</ul>
		</div>
		<div id = "content">
			<% String status = (String) session.getAttribute("status");
			if(status != null){
				switch(status){
					case "books":%>
						<%@ include file="books.jsp" %>
						<% break; 
					case "authors":%>
						<%@ include file="authors.jsp" %>
						<% break;
					case "publish":%>
						<%@ include file="publishers.jsp" %>
						<% break;
					case "loans":%>
						<%@ include file="loans.jsp" %>
						<% break;
					case "login":%>
						<%@ include file="login.jsp" %>
						<% break;
					default:
				}
			}%>
		</div>
	</body>
</html>