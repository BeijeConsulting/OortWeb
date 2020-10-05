package it.beije.oort.lauria.rubrica;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RicercaId
 */
@WebServlet("/RicercaId")
public class RicercaId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaId() {
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
//		StringBuilder builder = new StringBuilder("<h2>Dati registrati con successo</h2><br>");
//		
//		String id = request.getParameter("id");
//		Contatto contatto = JPADBtoolsRubrica.entityManager.find(Contatto.class, Integer.parseInt(id));
//		
//		builder.append("NOME : ").append(contatto.getNome()).append("<br/>COGNOME : ").append(contatto.getCognome()).append("<br/>TELEFONO : ")
//		.append(contatto.getTelefono()).append("<br/>EMAIL : ").append(contatto.getEmail());
//		
//		builder.append("<br><a href="+"./home.html" + ">home</a><br>");
//
//		response.getWriter().append(builder);

		StringBuilder builder = new StringBuilder("<h2>Dati registrati con successo</h2><br>");
		
		String id = request.getParameter("id");
		Contatto contatto = JPADBtoolsRubrica.entityManager.find(Contatto.class, Integer.parseInt(id));
		
		builder.append("NOME : ").append(contatto.getNome()).append("<br/>COGNOME : ").append(contatto.getCognome()).append("<br/>TELEFONO : ")
		.append(contatto.getTelefono()).append("<br/>EMAIL : ").append(contatto.getEmail());
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		response.sendRedirect("ricercaIdJSP.jsp");


	}

}
