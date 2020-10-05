package it.beije.oort.web.rubrica;

import it.beije.oort.web.database.DBReader;
import it.beije.oort.web.database.DBWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contactModifier")
public class ContactModifier extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        Contatto c = null;
        String idParam = request.getParameter("id");
        System.out.println(idParam);
        if (idParam != null){
            id = Integer.parseInt(idParam);
            c = DBReader.searchByID(id);
            System.out.println(c.toString());
        }

        if (c != null) {
            if (!request.getParameter("nome").equalsIgnoreCase("")) c.setNome(request.getParameter("nome"));
            if (!request.getParameter("cognome").equalsIgnoreCase("")) c.setCognome(request.getParameter("cognome"));
            if (!request.getParameter("cell").equalsIgnoreCase("")) c.setCell(request.getParameter("cell"));
            if (!request.getParameter("email").equalsIgnoreCase("")) c.setEmail(request.getParameter("email"));
            DBWriter.writeContatto(c);
            response.sendRedirect("/OortWeb_war/rubrica/modify.jsp?modified=true");
        }
        else {
            response.sendRedirect("/OortWeb_war/rubrica/modify.jsp?modified=false");
        }
    }
}
