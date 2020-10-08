package it.beije.oort.web.biblioteca.controller;

import it.beije.oort.web.biblioteca.dbutils.DatabaseManager;
import it.beije.oort.web.biblioteca.model.IBibliotecaModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/doSearch")
public class BiblioSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in doget");
        System.out.println((String) request.getSession().getAttribute("searchType")
        + (String) request.getSession().getAttribute("searchField")
        + request.getParameter("searchQuery"));

        String searchObjClass = (String) request.getSession().getAttribute("searchType");
        String searchField = (String) request.getSession().getAttribute("searchField");
        String searchQuery = request.getParameter("searchQuery");
        Class<?> classe = null;

        List<IBibliotecaModel> results = new ArrayList<>();

        try {
            classe = Class.forName("it.beije.oort.web.biblioteca.model." + searchObjClass);
            System.out.println("Class: " + classe.getSimpleName() + ". Campo: " + searchField + " . Query: " + searchQuery);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if (classe != null){
            switch (searchField){
                case "id":
                case "a-id":
                case "e-id":
                case "l-id":
                    System.out.println(searchQuery + " " + searchField);
                    IBibliotecaModel obj = DatabaseManager.select((Class<? extends IBibliotecaModel>) classe, Integer.parseInt(searchQuery));
                    results.add(obj);
                    break;
                default:
                    results = (List<IBibliotecaModel>) DatabaseManager.search(classe, searchField, searchQuery);
                    break;
            }

            request.getSession().setAttribute("results", results);
        }
        response.sendRedirect("/OortWeb_war/biblio/biblioSearch.jsp");
    }
}
