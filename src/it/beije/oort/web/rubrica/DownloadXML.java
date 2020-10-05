package it.beije.oort.web.rubrica;

import it.beije.oort.web.database.DBReader;
import it.beije.oort.web.tools.XMLWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/getXML")
public class DownloadXML extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/xml");
        response.setHeader("Content-disposition", "attachment; rubrica.xml");

        XMLWriter.writeList(DBReader.getContatti(), "\\Code\\OortWeb\\WebContent\\WEB-INF\\rubrica.xml");

        try(InputStream in = request.getServletContext().getResourceAsStream("\\Code\\OortWeb\\WebContent\\WEB-INF\\rubrica.xml");
            OutputStream out = response.getOutputStream()) {

            byte[] buffer = new byte[1028];

            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }
}
