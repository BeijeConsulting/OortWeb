package it.beije.oort.web.rubrica;

import it.beije.oort.web.database.DBReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/rubricaView")
public class RubricaView extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sPage = request.getParameter("page");
        int page;
        if (sPage == null) page = 0;
        else page = Integer.parseInt(sPage);
        final int MAX_ENTRIES_PER_PAGE = 10;
        String title = "Lista Contatti";
       String head = "<!DOCTYPE html>\n" +
               "<html lang=\"it\">\n" +
               "<head>\n" +
               "    <meta charset=\"UTF-8\">\n" +
               "    <title>" + title + "</title>\n" +
               "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
               "\n" +
               "    <link href=\"style\\listView.css\" rel=\"stylesheet\">\n" +
               "    <link href=\"https://fonts.googleapis.com/css2?family=Roboto&display=swap\" rel=\"stylesheet\">\n" +
               "    <script src=\"https://kit.fontawesome.com/e8e37b0541.js\" crossorigin=\"anonymous\"></script>\n" +
               "    <link rel=\"icon\" type=\"image/png\" href=\"media/rubrica.ico\"/>\n" +
               "    \n" +
               "</head>";
       String top = "<body>\n" +
               "    <div class=\"home\">\n" +
               "        <a href=\"../index.html\"><i class=\"fas fa-home\"></i></a>\n" +
               "    </div>\n" +
               "    <div class=\"container\">\n" +
               "        <div class = \"small-center-container\">\n" +
               "            <div class=\"header\">\n" +
               "                <h1><i>Contatti</i></h1>\n" +
               "                <h3>Elenco dei Contatti presenti in Rubrica</h3>\n" +
               "            </div>\n" +
               "\n" +
               "            <div class = \"contatti-list\">\n" +
               "                <table>\n" +
               "                    <tr>\n" +
               "                        <th>Nome</th>\n" +
               "                        <th>Cognome</th>\n" +
               "                        <th>Telefono</th>\n" +
               "                        <th>Email</th>\n" +
               "                    </tr>";
       String bottom = "</table>\n" +
               "            </div>\n" +
               "        </div>\n" +
               "<a href=\"./rubricaView?page=" + ++page + "\" class = \"pageLink\">Successivo</a>" +
               "    </div>\n" +
               "</body>\n" +
               "</html>";

       List<Contatto> contattos = DBReader.getContatti();
       StringBuilder tableContent = new StringBuilder();

        for (int i = (MAX_ENTRIES_PER_PAGE * page);
             i < (MAX_ENTRIES_PER_PAGE*(page+1)) && i < contattos.size(); i++) {
            Contatto c = contattos.get(i);
            tableContent.append("<tr>")
                    .append("<td>").append(c.getNome()).append("</td>")
                    .append("<td>").append(c.getCognome()).append("</td>")
                    .append("<td>").append(c.getCell()).append("</td>")
                    .append("<td>").append(c.getEmail()).append("</td>")
                    .append("<td><a class=\"delete\" href=\"./deleteContatto?id="+c.getId()+" \"><i class=\"fas fa-minus-circle\"></i></a></td>")
                    .append("</tr>");
        }

            PrintWriter out = response.getWriter();
       out.println(head+top+tableContent+bottom);
    }
}
