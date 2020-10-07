package it.beije.oort.web.rubrica;

import it.beije.oort.web.database.DBWriter;
import it.beije.oort.web.model.Contatto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addContatto")
public class AddContatto extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Contatto c = new Contatto();
        c.setNome(request.getParameter("nome"));
        c.setCognome(request.getParameter("cognome"));
        c.setCell(request.getParameter("telefono"));
        c.setEmail(request.getParameter("email"));

        DBWriter.writeContatto(c);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Contatto Aggiunto";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//it\">\n";

        out.println(docType +
                        "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body bgcolor = \"#f0f0f0\">\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<ul>\n" +
                        "  <li><b>Nome</b>: "
                        + request.getParameter("nome") + "\n" +
                        "  <li><b>Cognome</b>: "
                        + request.getParameter("cognome") + "\n" +
                        "  <li><b>Telefono</b>: "
                        + request.getParameter("telefono") + "\n" +
                        "  <li><b>Email</b>: "
                        + request.getParameter("email") + "\n" +
                        "</ul>\n" +
                        "</body>" +
                "</html>"
        );
    }
}
