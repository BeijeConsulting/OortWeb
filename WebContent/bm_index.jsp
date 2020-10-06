<%@page import="it.beije.oort.bm.rubrica.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Web Rubrica</title>
		<link rel = "stylesheet" type = "text/css" href = "rubrica_style.css">
		<script type="text/javascript">
			function clickHandler(evt) {
				var caller = evt.target || evt.srcElement;
				var caller_id = caller.getAttribute("name");
				var div_name = "";
				switch(caller_id){
					case "search_contacts":
						div_name = "search_fields";
						break;
					case "add_contact":
						div_name = "add_fields";
						break;
					case "update_contact":
						div_name = "update_fields";
						break;
					case "delete_contact":
						div_name = "remove_fields";
						break;
				}
				var fields = document.getElementById(div_name);
				if(fields.style.display === "none"){
					fields.style.display = "block";
				}else{
					fields.style.display = "none";
				}
				evt.stopPropagation();
			}
		</script>
	</head>
	<body>
		<div id = "head">
			<h1>Welcome to Brando's Magical Rubrica</h1>
		</div>
		<div id = "search">
				<ul>
					<li>
						<button name = "search_contacts" onClick="clickHandler(event)">Search</button>
					</li>
					<li>
						<form action="./displayService" method="GET">
							<input type="submit" value = "View All">
						</form>
					</li>
					<li>
						<button name = "add_contact" onClick="clickHandler(event)">Add</button>
					</li>
					<li>
						<button name = "update_contact" onClick="clickHandler(event)">Update</button>
					</li>
					<li>
						<button name = "delete_contact" onClick="clickHandler(event)">Remove</button>
					</li>
				</ul>
			<div id = "search_fields" class="fields" style = "display: none;">
				<form action="./displayService" method="POST">
					<fieldset>
						<legend>Contact info</legend>
						<label for = "fname">First name:</label><input type = "text" name = "fname" value = ""><br>
						<label for = "lname">Last name:</label><input type = "text" name = "lname" value = ""><br>
						<label for = "phone">Phone n°:</label><input type = "tel" name = "phone" pattern = "[0-9]{3} [0-9]{3} [0-9]{4}"><br>
						<label for = "email">E-mail address:</label><input type = "email" name = "email" value = ""><br>
						<input id = "submit" type = "submit" value = "Submit">
					</fieldset>
				</form>
			</div>
			<div id = "add_fields" class="fields" style = "display: none;">
				<form action="./addService" method="POST">
					<fieldset>
						<legend>Contact info</legend>
						<label for = "fname">First name:</label><input type = "text" name = "fname" value = ""><br>
						<label for = "lname">Last name:</label><input type = "text" name = "lname" value = ""><br>
						<label for = "phone">Phone n°:</label><input type = "tel" name = "phone" pattern = "[0-9]{3} [0-9]{3} [0-9]{4}"><br>
						<label for = "email">E-mail address:</label><input type = "email" name = "email" value = ""><br>
						<input id = "submit" type = "submit" value = "Submit">
					</fieldset>
				</form>
			</div>
			<div id = "update_fields" class="fields" style = "display: none;">
				<form action="./updateService" method="POST">
					<fieldset>
						<legend>Contact info</legend>
						<label for = "fname">Id:</label><input type = "number" name = "id" value = ""><br>
						<label for = "fname">New first name:</label><input type = "text" name = "fname" value = ""><br>
						<label for = "lname">New last name:</label><input type = "text" name = "lname" value = ""><br>
						<label for = "phone">New phone n°:</label><input type = "tel" name = "phone" pattern = "[0-9]{3} [0-9]{3} [0-9]{4}"><br>
						<label for = "email">New e-mail address:</label><input type = "email" name = "email" value = ""><br>
						<input id = "submit" type = "submit" value = "Submit">
					</fieldset>
				</form>
			</div>
			<div id = "remove_fields" class="fields" style = "display: none;">
				<form action="./removeService" method="POST">
					<fieldset>
						<legend>Contact info</legend>
						<label for = "fname">Id:</label><input type = "number" name = "id" value = ""><br>
						<input id = "submit" type = "submit" value = "Submit">
					</fieldset>
				</form>
			</div>
		</div>
		
		<div id = "contacts">
			<table>
				<tr>
					<th>Id</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Phone n°</th>
					<th>E-mail</th>
				</tr>
				<% 
					List<Contatto> list = (List<Contatto>) session.getAttribute("results");
					if(list != null) {
						for(Contatto c : list) {
							%>
							<tr>
								<td><%= c.getId() %></td>
								<td><%= c.getNome() %></td>
								<td><%= c.getCognome() %></td>
								<td><%= c.getTelefono() %></td>
								<td><%= c.getEmail() %></td>
							</tr>
							<%
						}
					}
				%>
			</table>
		</div>
	</body>
</html>