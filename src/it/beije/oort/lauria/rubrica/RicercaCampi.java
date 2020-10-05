package it.beije.oort.lauria.rubrica;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RicercaCampi
 */
@WebServlet("/RicercaCampi")
public class RicercaCampi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaCampi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder builder = new StringBuilder("<h2>Risultati della ricerca</h2><br>");
		builder.append("<a href="+"./home.html" + ">home</a><br>");
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		List<Contatto> contatti = JPADBtoolsRubrica.selectContacts(nome, cognome, telefono, email);
		builder.append("<h3>").append("Contatti trovati: ").append(contatti.size()).append("</h3>");
		for (Contatto contatto : contatti) {
		builder.append("<p>id : ").append(contatto.getId())
		.append("<br/>Nome : ").append(contatto.getNome())
		.append("<br/>Cognome : ").append(contatto.getCognome())
		.append("<br/>Telefono : ").append(contatto.getTelefono())
		.append("<br/>Email : ").append(contatto.getEmail())
		.append("</p><br>");
		}

		response.getWriter().append(builder);
	}

}
