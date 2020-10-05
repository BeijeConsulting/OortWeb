package it.beije.oort.madonia.rubrica.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.madonia.db.DatabaseManagerRubrica;
import it.beije.oort.madonia.rubrica.ebeans.Contatto;

/**
 * Servlet implementation class InserimentoContattoServlet
 */
@WebServlet("/rubrica/inserisciContatto") // OortWeb/rubrica/inserisciContatto
public class InserimentoContattoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserimentoContattoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contatto contatto = new Contatto();
		contatto.setNome(request.getParameter("nome"));
		contatto.setCognome(request.getParameter("cognome"));
		contatto.setTelefono(request.getParameter("telefono"));
		contatto.setEmail(request.getParameter("email"));
		
		try {
			DatabaseManagerRubrica.inserisciContatto(contatto);
			response.sendRedirect("./rubricaMenuInserisciContatto.html#success");
		} catch (Exception e) {
			response.getWriter().append("Contatto non inserito");
		}
	}

}
