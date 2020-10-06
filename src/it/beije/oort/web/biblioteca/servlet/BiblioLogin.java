package it.beije.oort.web.biblioteca.servlet;

import it.beije.oort.web.biblioteca.controller.DatabaseManager;
import it.beije.oort.web.biblioteca.model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logUser")
public class BiblioLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utente utente = DatabaseManager.getUtenteFromCF(request.getParameter("cf").trim());
        if (utente == null){
            response.sendRedirect("/OortWeb_war/biblio/biblioLogin.jsp?error=user");
        } else {
            if (utente.getPassword().equals(request.getParameter("pass").trim())){
                request.getSession().setAttribute("utente", utente);
                request.getSession().setAttribute("logged", true);
                response.sendRedirect("/OortWeb_war/biblio/biblioIndex.jsp");
            } else {
                response.sendRedirect("/OortWeb_war/biblio/biblioLogin.jsp?error=pass");
            }
        }
    }
}
