package it.beije.oort.web.rubrica;

import it.beije.oort.web.database.DBReader;
import it.beije.oort.web.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/log")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        User user = DBReader.getUser(email);
        if (user != null && user.getPassword().equalsIgnoreCase(pass)){
            request.getSession().setAttribute("user", user);
            response.sendRedirect("./login.jsp?login=true");
        } else {
            response.sendRedirect("./login.jsp?login=false");
        }
    }
}
