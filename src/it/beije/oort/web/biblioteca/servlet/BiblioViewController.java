package it.beije.oort.web.biblioteca.servlet;

import it.beije.oort.web.biblioteca.controller.DatabaseManager;
import it.beije.oort.web.biblioteca.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/biblioViewController")
public class BiblioViewController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("list");
        List<? extends IBibliotecaModel> lista = null;
        if (request.getParameter("list") != null
                && !request.getParameter("list").equalsIgnoreCase("")) {
            switch (request.getParameter("list")) {
                case "libri":
                    lista = DatabaseManager.findAll(Libro.class);
                    request.getSession().setAttribute("type", "Libro");
                    break;
                case "autori":
                    lista = DatabaseManager.findAll(Autore.class);
                    request.getSession().setAttribute("type", "Autore");
                    break;
                case "editori":
                    lista = DatabaseManager.findAll(Editore.class);
                    request.getSession().setAttribute("type", "Editore");
                    break;
                case "utenti":
                    lista = DatabaseManager.findAll(Utente.class);
                    request.getSession().setAttribute("type", "Utente");
                    break;
                case "prestiti":
                    lista = DatabaseManager.findAll(Prestito.class);
                    request.getSession().setAttribute("type", "Prestito");
                    break;
            }
            request.getSession().setAttribute("list", lista);
        }
        response.sendRedirect("/OortWeb_war/biblio/biblioView.jsp");
    }
}
