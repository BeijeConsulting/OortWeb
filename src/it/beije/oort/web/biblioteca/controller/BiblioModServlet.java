package it.beije.oort.web.biblioteca.controller;

import it.beije.oort.web.biblioteca.dbutils.DatabaseManager;
import it.beije.oort.web.biblioteca.model.IBibliotecaModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modify")
public class BiblioModServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("modifyMe");
        String nomeClasse = request.getParameter("classe");
        Class<? extends IBibliotecaModel> classe = null;
        int id;
        try {
            classe = (Class<? extends IBibliotecaModel>) Class.forName("it.beije.oort.web.biblioteca.model." + nomeClasse);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e){
            e.printStackTrace();
            id = -1;
        }

        // adesso ho id e classe pronti per modificarli
        IBibliotecaModel obj = DatabaseManager.select(classe, id);
        request.getSession().setAttribute("modifyMe", obj);
        request.getSession().setAttribute("modifyMeClass", nomeClasse);
        request.getSession().setAttribute("modifyMeID", id);
        response.sendRedirect("/OortWeb_war/biblio/modify.jsp");
    }
}
