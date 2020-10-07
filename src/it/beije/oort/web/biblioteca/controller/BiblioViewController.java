package it.beije.oort.web.biblioteca.controller;

import it.beije.oort.web.biblioteca.dbutils.DatabaseManager;
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<? extends IBibliotecaModel> lista = null;

        if (request.getParameter("type") != null && !request.getParameter("type").equalsIgnoreCase("")){
            request.getSession().setAttribute("type", request.getParameter("type"));
        }

        String type = (String) request.getSession().getAttribute("type");

        if (type != null
                && !type.equalsIgnoreCase("")) {
            switch (type) {
                case "Libro":
                    System.out.println("in switch case Libro");
                    lista = DatabaseManager.findAll(Libro.class);
                   // request.getSession().setAttribute("type", "Libro");
                    System.out.println("ottenuta lista");
                    break;
                case "Autore":
                    lista = DatabaseManager.findAll(Autore.class);
                    //request.getSession().setAttribute("type", "Autore");
                    break;
                case "Editore":
                    lista = DatabaseManager.findAll(Editore.class);
                    //request.getSession().setAttribute("type", "Editore");
                    break;
                case "Utente":
                    lista = DatabaseManager.findAll(Utente.class);
                   // request.getSession().setAttribute("type", "Utente");
                    break;
                case "Prestito":
                    System.out.println("in switch");
                    lista = DatabaseManager.findAll(Prestito.class);
                    //request.getSession().setAttribute("type", "Prestito");
                    break;
            }
            request.getSession().setAttribute("list", lista);
            request.getSession().setAttribute("type", type);
        }
        response.sendRedirect("/OortWeb_war/biblio/biblioView.jsp");
    }
}
