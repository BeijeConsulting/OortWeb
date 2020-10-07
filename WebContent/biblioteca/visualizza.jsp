<%@page import="it.beije.oort.gregori.biblioteca.jpa.Prestito"%>
<%@page import="it.beije.oort.gregori.biblioteca.jpa.Libro"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<!--
	Industrious by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Biblioteca - Visualizzazione prestiti</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<a class="logo" href="#">Biblioteca</a>
				<a class="logo" href="../Logout">Log out</a>
			</header>

		<!-- Heading -->
			<div id="heading" >
				<h1>Prestiti</h1>
			</div>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
						<h3>Prestiti in corso</h3>
						<div class="table-wrapper">
							<table>
								<thead>
									<tr>
									<th>Id utente</th>
									<th>Data inizio</th>
									<th>Data fine</th>
									<th>Note</th>
									<th>Id libro</th>
									</tr>
								</thead>
								<tbody>
									<% 
									List<Prestito> prestiti = (List<Prestito>)session.getAttribute("prestiti");
									List<Libro> libri = (List<Libro>)session.getAttribute("libri");
									for(Prestito prestito : prestiti) {
									%>
									
									<tr>
									<td><%= prestito.getUtente() %></td>
									<td><%= prestito.getDataInizio() %></td>
									<td><%= prestito.getDataFine() %></td>
									<td><%= prestito.getNote() %></td>
									<td>
										<%
										for(Libro libro : libri) {
											if(prestito.getLibro() == libro.getId()) {
												out.print(libro.getTitolo());
											}
										}
										%>
									</td>
									
									<% } %>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</section>

		<!-- Footer -->
			<footer id="footer">
				<div class="inner">
					<div class="copyright">
						&copy; Luca Gregori.
					</div>
				</div>
			</footer>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>