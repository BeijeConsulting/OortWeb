package it.beije.oort.web.biblioteca.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/searchModifier")
public class BiblioSearchModifier  extends HttpServlet {
    private static String oldSearchType = null;
    private static String oldSearchField = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doget");

        if (request.getParameter("searchType") != null){
            request.getSession().setAttribute("searchType", request.getParameter("searchType"));

            System.out.println(request.getSession().getAttribute("searchType") + "questo è il searchtype");

            if (oldSearchType != null && !oldSearchType.equalsIgnoreCase(request.getParameter("searchType"))){
                System.out.println("Cambio il searchType e tolgo il searchfield");
                request.getSession().removeAttribute("searchField");
            }
            oldSearchType = request.getParameter("searchType");
        }
        if (request.getParameter("searchField") != null){
            request.getSession().setAttribute("searchField", request.getParameter("searchField"));
            oldSearchField = request.getParameter("searchField");
        }

        System.out.println("nulla di fatto");

        response.sendRedirect("/OortWeb_war/biblio/biblioSearch.jsp");
    }
}
