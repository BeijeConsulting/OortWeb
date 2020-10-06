package it.beije.oort.web.rubrica;

import it.beije.oort.web.database.JPAEntityManager;
import it.beije.oort.web.model.Contatto;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteContatto")
public class DeleteContatto extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        String sid = request.getParameter("id");
        if (sid != null) id = Integer.parseInt(sid);
        else response.sendRedirect("/OortWeb_war/rubricaView");

        EntityManager em = JPAEntityManager.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Contatto.class, id));
        em.getTransaction().commit();
        response.sendRedirect("/OortWeb_war/rubricaView");
    }
}
