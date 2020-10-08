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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("results");
        if (request.getParameter("searchType") != null){
            request.getSession().setAttribute("searchType", request.getParameter("searchType"));

            if (oldSearchType != null && !oldSearchType.equalsIgnoreCase(request.getParameter("searchType"))){
                request.getSession().removeAttribute("searchField");
            }
            oldSearchType = request.getParameter("searchType");
        }
        if (request.getParameter("searchField") != null){
            request.getSession().setAttribute("searchField", request.getParameter("searchField"));
            String oldSearchField = request.getParameter("searchField");
        }

        response.sendRedirect("/OortWeb_war/biblio/biblioSearch.jsp");
    }
}
