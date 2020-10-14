<%@ page import="it.beije.oort.gregori.biblioteca.Utente" %>
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
		<title>Biblioteca - Inserimento biblioteca</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<a class="logo" href="../GestioneLink?page=home">Biblioteca</a>
				<nav>
					<a href="#menu">Menu</a>
				</nav>
			</header>

		<!-- Nav -->
			<nav id="menu">
				<ul class="links">
					<li><a href="../GestioneLink?page=home">Home</a></li>
					<li><a href="../GestioneLink?page=inserimento">Inserimento</a></li>
					<li><a href="../GestioneLink?page=visualizzazione">Visualizzazione</a></li>
					<li><a href="../GestioneLink?page=modifica">Modifica</a></li>
					<li><a href="../GestioneLink?page=rimozione">Rimozione</a></li>
					<li><a href="../GestioneLink?page=ricerca">Ricerca</a></li>
					<li><a href="../GestioneLink?page=esportazione">Esportazione</a></li>
					<li><a href="../Logout">Log out</a></li>
				</ul>
			</nav>

		<!-- Heading -->
			<div id="heading" >
				<h1>Inserimento - Utente</h1>
			</div>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
						<form method="post" action="../InserimentoController?page=utente">
							<div class="row gtr-uniform">
								<!--Utente-->
								<div class="col-12">
									<h3>Utente</h3>
									<input type="text" name="name" id="name" value="" placeholder="Nome" />
								</div>
								<!-- Break -->
								<!--div class="col-6 col-12-xsmall"-->
								<div class="col-12">
									<input type="text" name="surname" id="surname" value="" placeholder="Cognome" />
								</div>
								<!-- Break -->
								<div class="col-12">
									<input type="text" name="codice-fiscale" id="codice-fiscale" value="" placeholder="Codice fiscale" />
								</div>
								<!-- Break -->
								<div class="col-12">
									<input type="text" name="indirizzo" id="indirizzo" value="" placeholder="Indirizzo" />
								</div>
								<!-- Break -->
								<div class="col-12">
									<input type="email" name="email" id="email" value="" placeholder="Email" />
								</div>
								<div class="col-12">
									<input type="password" name="password" id="password" value="" placeholder="Password" />
								</div>
								<!-- Break -->
								<div class="col-12">
									<input type="text" name="phone" id="phone" value="" placeholder="Telefono" />
								</div>
								<!-- Break -->
									
								<!--Buttons-->
								<div class="col-12">
									<ul class="actions">
										<li><input type="submit" value="Invia" class="primary" /></li>
										<li><input type="reset" value="Cancella" /></li>
									</ul>
								</div>
							</div>
						</form>
						<%
						String pagina = (String)session.getAttribute("page");
						if(pagina != null && pagina.equals("utente")) {
							Utente utente = (Utente)session.getAttribute("utente");
						%>
						<h3>Utente inserito correttamente</h3>
						<div class="table-wrapper">
							<table>
								<thead>
									<tr>
									<th>Nome</th>
									<th>Cognome</th>
									<th>Codice fiscale</th>
									<th>Telefono</th>
									<th>Email</th>
									<th>Indirizzo</th>
									</tr>
								</thead>
								<tbody>											
									<tr>
									<td><%= utente.getNome() %></td>
									<td><%= utente.getCognome() %></td>
									<td><%= utente.getCodiceFiscale() %></td>
									<td><%= utente.getTelefono() %></td>
									<td><%= utente.getEmail() %></td>
									<td><%= utente.getIndirizzo() %></td>
								</tbody>
							</table>
						</div>
						<%	
						}
						%>
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