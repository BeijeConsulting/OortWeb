package it.beije.oort.web.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DownloadFileServlet", urlPatterns = {"/DownloadFileServlet"})
public class DownloadFileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String filePath = request.getParameter("file");
            File file = new File(filePath);
            FileInputStream inputStream = new FileInputStream(file);
            ServletContext context = getServletContext();
            String mimeType = context.getMimeType(filePath);
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            response.setContentType(mimeType);
            response.setContentLength((int) file.length());
            // forziamo il download del file
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
            response.setHeader(headerKey, headerValue);
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            //gestiamo eventuali errori come file non esistente
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
