package it.beije.oort.web.biblioteca.controller;

import it.beije.oort.web.biblioteca.dbutils.DatabaseManager;
import it.beije.oort.web.biblioteca.model.IBibliotecaModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/destroy")
public class BiblioDestroyerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nomeClasse = request.getParameter("classe");

        // se è un utente da cancellare devo seguire una procedura differente
        if (nomeClasse.equalsIgnoreCase("utente")){
            DatabaseManager.deleteUtente(request.getParameter("id"));
            response.sendRedirect("./biblioViewController");
        }
        Class<?> classe = null;
        int id;
        try {
            classe = Class.forName("it.beije.oort.web.biblioteca.model." + nomeClasse);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e){
            e.printStackTrace();
            id = -1;
        }
        DatabaseManager.delete((Class<? extends IBibliotecaModel>) classe, id);
        response.sendRedirect("./biblioViewController");
    }
}
