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
		<title>Biblioteca - Home</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="is-preload">
	
		<jsp:useBean id="utente" class="it.beije.oort.gregori.biblioteca.jpa.Utente" scope="session"/>
		<jsp:setProperty property="email" name="utente" param="username"/>
		<jsp:setProperty property="password" name="utente" param="pass"/>

		<!-- Header -->
			<header id="header">
				<a class="logo" href="index.html">Biblioteca</a>
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
				<h1>Home</h1>
			</div>

		<!-- Main -->
			<!-- Highlights -->
			<section class="wrapper">
				<div class="inner">
					<header class="special">
						<h2>Azioni disponibili</h2>
						<p>Selezionare un'azione da svolgere sulla biblioteca.</p>
					</header>
					<div class="highlights">
						<section>
							<div class="content">
								<header>
									<a href="inserimento.html" class="icon fa-vcard-o"><span class="label">Icon</span></a>
									<h3>Inserisci</h3>
								</header>
								<p>Inserimento dati all'interno della biblioteca.</p>
							</div>
						</section>
						<section>
							<div class="content">
								<header>
									<a href="visualizzazione.html" class="icon fa-table"><span class="label">Icon</span></a>
									<h3>Visualizza</h3>
								</header>
								<p>Visualizzazione dati all'interno della biblioteca.</p>
							</div>
						</section>
						<section>
							<div class="content">
								<header>
									<a href="modifica.html" class="icon fa-edit"><span class="label">Icon</span></a>
									<h3>Modifica</h3>
								</header>
								<p>Modifica dati all'interno della biblioteca.</p>
							</div>
						</section>
						<section>
							<div class="content">
								<header>
									<a href="rimozione.html" class="icon fa-trash"><span class="label">Icon</span></a>
									<h3>Rimuovi</h3>
								</header>
								<p>Rimozione dati all'interno della biblioteca.</p>
							</div>
						</section>
						<section>
							<div class="content">
								<header>
									<a href="ricerca.html" class="icon fa-search"><span class="label">Icon</span></a>
									<h3>Ricerca</h3>
								</header>
								<p>Ricerca dati all'interno della biblioteca.</p>
							</div>
						</section>
						<section>
							<div class="content">
								<header>
									<a href="esportazione.html" class="icon fa-files-o"><span class="label">Icon</span></a>
									<h3>Esporta</h3>
								</header>
								<p>Esportazione della biblioteca.</p>
							</div>
						</section>
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