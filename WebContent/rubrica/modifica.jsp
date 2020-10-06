<%@ page import="it.beije.oort.gregori.rubrica.db.ReaderDb" %>
<%@ page import="it.beije.oort.rubrica.Contatto" %>
<%@ page import="java.util.List" %>
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
		<title>Rubrica - Modifica contatti</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<a class="logo" href="home.html">Rubrica</a>
				<nav>
					<a href="#menu">Menu</a>
				</nav>
			</header>

		<!-- Nav -->
		<nav id="menu">
			<ul class="links">
				<li><a href="home.html">Home</a></li>
				<li><a href="inserimento.html">Inserimento</a></li>
				<li><a href="visualizzazione.html">Visualizzazione</a></li>
				<li><a href="modifica.html">Modifica</a></li>
				<li><a href="rimozione.html">Rimozione</a></li>
				<li><a href="ricerca.html">Ricerca</a></li>
				<li><a href="esportazione.html">Esportazione</a></li>
			</ul>
		</nav>

		<!-- Heading -->
			<div id="heading" >
				<h1>Modifica</h1>
			</div>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
						<!-- Form -->						
						<h3>Selezionare un contatto</h3>
						<form method="post" action="./Modifica">
							<div class="row gtr-uniform">
								<div class="col-12">
									<select name="selezione-contatto" id="selezione-contatto">
										<option value="">- Contatto -</option>
										<% 
										List<Contatto> contatti = ReaderDb.readContatti(); 
										for(Contatto contatto : contatti) {
										%>
										<option value="<%= contatto.getId() %>"><%= contatto %></option>
										<% } %>
									</select>
								</div>
								<!--div class="col-6 col-12-xsmall"-->
								<div class="col-12">
									<h3>Modifica il contatto</h3>
									<input type="text" name="nome" id="nome" value="" placeholder="Nome" />
								</div>
								<!-- Break -->
								<!--div class="col-6 col-12-xsmall"-->
								<div class="col-12">
									<input type="text" name="cognome" id="cognome" value="" placeholder="Cognome" />
								</div>
								<!-- Break -->
								<div class="col-12">
									<input type="email" name="email" id="email" value="" placeholder="Email" />
								</div>
								<!-- Break -->
								<!-- Break -->
								<div class="col-12">
									<input type="text" name="telefono" id="telefono" value="" placeholder="Telefono" />
								</div>
								<!-- Break -->
								<div class="col-12">
									<ul class="actions">
										<li><input type="submit" value="Invia" class="primary" /></li>
										<li><input type="reset" value="Cancella" /></li>
									</ul>
								</div>
							</div>
						</form>
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