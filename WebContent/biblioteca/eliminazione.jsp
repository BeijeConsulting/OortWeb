<%@ page import="it.beije.oort.gregori.biblioteca.jpa.Utente" %>
<%@ page import="it.beije.oort.gregori.biblioteca.jpa.Libro" %>
<%@ page import="it.beije.oort.gregori.biblioteca.jpa.Prestito" %>
<%@ page import="it.beije.oort.gregori.biblioteca.jpa.Autore" %>
<%@ page import="it.beije.oort.gregori.biblioteca.jpa.Editore" %>
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
		<title>Biblioteca - Rimozione</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<a class="logo" href="home.html">Biblioteca</a>
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
				<li><a href="../Logout">Log out</a></li>
			</ul>
		</nav>

		<!-- Heading -->
			<div id="heading" >
				<h1>Visualizzazione</h1>
			</div>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
						<form method="get" action="../Rimozione">
							<div class="row gtr-uniform">
								<div class="col-12">
									<h3>Tabella</h3>
									<select name="selezione-tabella" id="selezione-tabella">
										<option value="">- Tabella -</option>
										<option value="utente">Utente</option>
										<option value="autore">Autore</option>
										<option value="editore">Editore</option>
										<option value="libro">Libro</option>
										<option value="prestito">Prestito</option>
									</select>
								</div>
								<!--Buttons-->
								<div class="col-12">
									<ul class="actions">
										<li><input type="submit" value="Invia" class="primary" /></li>
										<li><input type="reset" value="Cancella" /></li>
									</ul>
								</div>
							</div>
						</form>
						<form action="../Rimozione" method="post">
						<!-- Table -->
						<% 
						String tabella = (String)session.getAttribute("tabella");
						System.out.println("########-> " + tabella);
						if(tabella != null) {
						%>
						<%
							if(tabella.equals("utente")) {
								session.removeAttribute("tabella");
								List<Utente> utenti = (List<Utente>)session.getAttribute("utenti");
								
						%>
									<h3>Utenti</h3>
									<div class="table-wrapper">
										<table id="delete">
											<thead>
												<tr>
													<th>Elimina</th>
													<th>Nome</th>
													<th>Cognome</th>
													<th>Codice fiscale</th>
													<th>Telefono</th>
													<th>Email</th>
													<th>Indirizzo</th>
												</tr>
											</thead>
											<tbody>
						<%
								for(Utente utente : utenti) {
						%>
												<tr>
													<td>
														<input type="checkbox" id="<%= utente.getId() %>" name="checkbox">
														<label for="<%= utente.getId() %>"></label>
													</td>
													<td><%= utente.getNome() %></td>
													<td><%= utente.getCognome() %></td>
													<td><%= utente.getCodiceFiscale() %></td>
													<td><%= utente.getTelefono() %></td>
													<td><%= utente.getEmail() %></td>
													<td><%= utente.getIndirizzo() %></td>
												</tr>
						<% 
								} 
						%>
											</tbody>
										</table>
									</div>

						<% 
							} // if utente
							session.removeAttribute("utenti");
						%>
						
						<%
							if(tabella.equals("autore")) {
								session.removeAttribute("tabella");
								List<Autore> autori = (List<Autore>)session.getAttribute("autori");
								
						%>
									<h3>Autori</h3>
									<div class="table-wrapper">
										<table>
											<thead>
												<tr>
													<th>Nome</th>
													<th>Cognome</th>
													<th>Data di nascita</th>
													<th>Data di morte</th>
													<th>Biografia</th>
												</tr>
											</thead>
											<tbody>
						<%
								for(Autore autore : autori) {
						%>
												<tr>
													<td><%= autore.getNome() %></td>
													<td><%= autore.getNome() %></td>
													<td><%= autore.getDataNascita() %></td>
													<td><%= autore.getDataMorte() %></td>
													<td><%= autore.getBiografia() %></td>
												</tr>
						<% 
								} 
						%>
											</tbody>
										</table>
									</div>
						<% 
							} // if autore
							session.removeAttribute("autori");
						%>
						
						<%
						} 
						%>
						<!--Buttons-->
						<% if(tabella != null) { %>
								<div class="col-12">
									<ul class="actions">
										<li><input type="submit" value="Elimina" class="primary" /></li>
										<li><input type="reset" value="Annulla" /></li>
									</ul>
								</div>
						<% } %>
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