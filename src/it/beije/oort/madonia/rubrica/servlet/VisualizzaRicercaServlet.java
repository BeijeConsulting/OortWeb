package it.beije.oort.madonia.rubrica.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.madonia.db.DatabaseManagerRubrica;
import it.beije.oort.madonia.rubrica.ebeans.Contatto;

/**
 * Servlet implementation class VisualizzaRicercaServlet
 */
@WebServlet("/rubrica/visualizzaRicerca")
public class VisualizzaRicercaServlet extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaRicercaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		stampaTabellaScomodo(request, response);
	}

	private void stampaTabellaScomodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Contatto> contatti = DatabaseManagerRubrica.ottieniListaContatti(
				request.getParameter("nome"),
				request.getParameter("cognome"),
				request.getParameter("telefono"),
				request.getParameter("email")
				);
		
		PrintWriter pw = response.getWriter();
		
		pw.append("<!DOCTYPE html>\r\n")
			.append("<html lang=\"it\">")
			.append("<head><link rel=\"stylesheet\" href=\"./css/myCss.css\"></head><body>");
		
		pw.append("<div class=\"rTable\">\r\n")
			.append("<div class=\"rTableRow\">\r\n")
			.append("<div class=\"rTableHead\"><strong>Cognome</strong></div>\r\n")
			.append("<div class=\"rTableHead\"><strong>Nome</strong></div>\r\n")
			.append("<div class=\"rTableHead\"><strong>Telefono</strong></div>\r\n")
			.append("<div class=\"rTableHead\"><strong>Email</strong></div>\r\n")
			.append("</div>");
		
		for(Contatto contatto : contatti) {
			pw.append("<div class=\"rTableRow\">\r\n")
				.append("<div class=\"rTableCell\">").append(contatto.getCognome()).append("</div>\r\n")
				.append("<div class=\"rTableCell\">").append(contatto.getNome()).append("</div>\r\n")
				.append("<div class=\"rTableCell\">").append(contatto.getTelefono()).append("</div>\r\n")
				.append("<div class=\"rTableCell\">").append(contatto.getEmail()).append("</div>\r\n")
				.append("</div>\r\n");
		}
		pw.append("</div>\r\n").append("</body>").append("</html>");
	}

}
