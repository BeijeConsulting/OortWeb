<%--
  Created by IntelliJ IDEA.
  User: Padawan09
  Date: 06/10/2020
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>



    <div class="home">
        <a href="./index.html"><i class="fas fa-home"></i></a>
    </div>
    <div class="container">
        <div class = "small-center-container">
            <div class="header">
                <h1><i>Login</i></h1>
            </div>
            <%
                String login = request.getParameter("login");
                if (login == null){
            %>

            <div class = "rubrica-form">
                <form action="./login" method="post">
                    <div class="single-input">
                        <label for="email">Email: </label>
                        <input type="text" name="email" id="email" required>
                    </div>

                    <div class="single-input">
                        <label for="password">Password: </label>
                        <input type="password" name="password" id="password">
                    </div>
                    <div class="submit">
                        <input type="submit" value="Login">
                    </div>
                </form>
            </div>

            <%
                } else if (login != null && login.equalsIgnoreCase("false")){
            %>
            <p>Login fallito.</p>
            <%
            } else if (login != null && login.equalsIgnoreCase("true")){
            %>
            <p>Loggato con successo.</p>
            <jsp:useBean id="user" class="it.beije.oort.web.model.User" scope="session"/>
            <jsp:getProperty name="user" property="email"/>
            <jsp:getProperty name="user" property="id"/>
            <%
            }
            %>
        </div>
    </div>

</body>
</html>
