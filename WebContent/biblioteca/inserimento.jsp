<%@ page import="it.beije.oort.gregori.biblioteca.jpa.Utente" %>
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
				</ul>
			</nav>

		<!-- Heading -->
			<div id="heading" >
				<h1>Inserimento</h1>
			</div>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
						<!-- Form -->
						<%
						String tabella = (String)session.getAttribute("tabella");
			
						if(tabella == null) {
						%>
						<form method="get" action="../Inserimento">
						<%	
						}						
						else {
						%>
						<form method="post" action="../Inserimento">
						<%	
						}
						%>
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
								<% if(tabella != null) { %>
									<% if(tabella.equals("utente")) { 
										session.setAttribute("tabella", "utente"); %>
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
									<% } %>
	
									<% if(tabella.equals("autore")) { %>
										<!--Autore-->
										<div class="col-12">
											<h3>Autore</h3>
											<input type="text" name="name" id="name" value="" placeholder="Nome" />
										</div>
										<!-- Break -->
										<!--div class="col-6 col-12-xsmall"-->
										<div class="col-12">
											<input type="text" name="surname" id="surname" value="" placeholder="Cognome" />
										</div>
										<!-- Break -->
										<div class="col-12">
											<input type="text" name="data-nascita" id="data-nascita" value="" placeholder="Data nascita" />
										</div>
										<!-- Break -->
										<div class="col-12">
											<input type="text" name="data-morte" id="data-morte" value="" placeholder="Data morte" />
										</div>
										<!-- Break -->
										<div class="col-12">
											<textarea name="biografia" id="biografia" placeholder="Biografia" rows="4"></textarea>
										</div>
										<!-- Break -->
									<% } %>
	
									<% if(tabella.equals("editore")) { %>
										<!--Editore-->
										<div class="col-12">
											<h3>Editore</h3>
											<input type="text" name="denominazione" id="denominazione" value="" placeholder="Denominazione" />
										</div>
										<!-- Break -->
										<div class="col-12">
											<textarea name="descrizione" id="descrizione" placeholder="Descrizione" rows="4"></textarea>
										</div>
										<!-- Break -->
									<% } %>
	
									<% if(tabella.equals("libro")) { %>
										<!--Libro-->
										<div class="col-12">
											<h3>Libro</h3>
											<input type="text" name="titolo" id="titolo" value="" placeholder="Titolo" />
										</div>
										<!-- Break -->
										<div class="col-12">
											<textarea name="descrizione" id="descrizione" placeholder="Descrizione" rows="4"></textarea>
										</div>
										<!-- Break -->
										<div class="col-12">
											<textarea name="note" id="note" placeholder="Note" rows="4"></textarea>
										</div>
										<!-- Break -->
										<div class="col-12">
											<select name="selezione-autore" id="selezione-autore">
												<option value="">- Autore -</option>
												<option value="autore1">Autore 1</option>
												<option value="autore2">Autore 2</option>
												<option value="autore3">Autore 3</option>
												<option value="autore4">Autore 4</option>
												<option value="autore5">Autore 5</option>
											</select>
										</div>
										<!-- Break -->
										<div class="col-12">
											<select name="selezione-editore" id="selezione-editore">
												<option value="">- Editore -</option>
												<option value="editore1">Editore 1</option>
												<option value="editore2">Editore 2</option>
												<option value="editore3">Editore 3</option>
												<option value="editore4">Editore 4</option>
												<option value="editore5">Editore 5</option>
											</select>
										</div>
										<!-- Break -->
									<% } %>
	
									<% if(tabella.equals("prestito")) { %>	
										<!--Prestito-->
										<div class="col-12">
											<h3>Prestito</h3>
											<select name="selezione-libro" id="selezione-libro">
												<option value="">- Libro -</option>
												<option value="libro1">Libro 1</option>
												<option value="libro2">Libro 2</option>
												<option value="libro3">Libro 3</option>
												<option value="libro4">Libro 4</option>
												<option value="libro5">Libro 5</option>
											</select>
										</div>
										<!-- Break -->
										<div class="col-12">
											<select name="selezione-utente" id="selezione-utente">
												<option value="">- Utente -</option>
												<option value="utente1">Utente 1</option>
												<option value="utente2">Utente 2</option>
												<option value="utente3">Utente 3</option>
												<option value="utente4">Utente 4</option>
												<option value="utente5">Utente 5</option>
											</select>
										</div>
										<!-- Break -->
										<div class="col-12">
											<input type="text" name="data-inizio" id="data-inizio" value="" placeholder="Data inizio" />
										</div>
										<!-- Break -->
										<div class="col-12">
											<input type="text" name="data-fine" id="data-fine" value="" placeholder="Data fine" />
										</div>
										<!-- Break -->
										<div class="col-12">
											<textarea name="note" id="note" placeholder="Note" rows="4"></textarea>
										</div>
										<!-- Break -->
									<% } %>
								<% } %>
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
						String checkInserimento = (String)session.getAttribute("checkInserimento");
						Utente utente = (Utente)session.getAttribute("utente");
						if(checkInserimento != null && checkInserimento.equals("true")) {
							if(tabella.equals("utente")) {
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