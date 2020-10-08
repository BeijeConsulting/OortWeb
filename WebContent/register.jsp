<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="./registerService" method="post">
			<label for="reg_name">First Name:</label><input type="text" name="reg_name"><br>
			<label for="reg_surname">Last Name:</label><input type="text" name="reg_surname"><br>
			<label for="reg_fc">Fiscal Code:</label><input type="text" name="reg_fc"><br>
			<label for="reg_addr">Address:</label><input type="text" name="reg_addr"><br>
			<label for="reg_phone">Phone n°:</label><input type="text" name="reg_phone"><br>
			<label for="reg_email">E-mail:</label><input type="email" name="reg_email"><br>
			<label for="reg_pswd">Password:</label><input type="password" name="reg_pswd"><br>
			<label for="reg_pswd_conf">Confirm Password:</label><input type="password" name="reg_pswd_conf"><br>
			<input type="submit" value="Send Request">
		</form>
	</body>
</html>