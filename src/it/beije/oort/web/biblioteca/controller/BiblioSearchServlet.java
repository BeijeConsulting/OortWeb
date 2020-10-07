package it.beije.oort.web.biblioteca.controller;

import it.beije.oort.web.biblioteca.dbutils.DatabaseManager;
import it.beije.oort.web.biblioteca.model.IBibliotecaModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doSearch")
public class BiblioSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchObjClass = (String) request.getSession().getAttribute("searchType");
        String searchField = (String) request.getSession().getAttribute("searchField");
        String searchQuery = (String) request.getParameter("searchQuery");
        Class<?> classe = null;

        try {
            classe = Class.forName("it.beije.oort.web.biblioteca.model." + searchObjClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        if (classe != null){
//            IBibliotecaModel risultato = DatabaseManager.select(classe)
//        }
    }
}
