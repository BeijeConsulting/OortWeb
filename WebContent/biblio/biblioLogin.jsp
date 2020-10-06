<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Biblioteca - Aggiungi</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="../style/main.css" rel="stylesheet">
    <link href="../style/biblioAdd.css" rel="stylesheet">
    <link href="../style/biblioView.css" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e8e37b0541.js" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href="../media/biblioteca.ico"/>

</head>
<body>
<div class="home">
    <a href="../index.html"><i class="fas fa-home"></i></a>
</div>
<div class="container">
    <div class = "small-center-container">
        <div class="header">
            <h1><i>Biblioteca - Login</i></h1>
        </div>

        <div class = "rubrica-form">
            <form action="../logUser" method="post">
                <div class="single-input">
                    <label for="cf">Codice Fiscale: </label>
                    <input type="text" name="cf" id="cf" required>
                </div>

                <div class="single-input">
                    <label for="pass">Password: </label>
                    <input type="password" name="pass" id="pass">
                </div>

                <div class="submit">
                    <input type="submit" value="Login">
                </div>
            </form>
        </div>
    </div>
</div>

<ul class="circles">
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
</ul>
</body>
</html>