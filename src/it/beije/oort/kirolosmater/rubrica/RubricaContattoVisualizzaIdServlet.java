package it.beije.oort.kirolosmater.rubrica;

import java.io.IOException;

import it.beije.oort.kirolosmater.biblioteca.JPAEntityManagerSingleton;
import it.beije.oort.rubrica.*;
import static it.beije.oort.kirolosmater.rubrica.RubricaJpa.*;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RubricaServletVisualizzaId
 */
@WebServlet("/rubrica/view/RubricaContattoVisualizzaIdServlet")
public class RubricaContattoVisualizzaIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	EntityManager em = JPAEntityManagerSingleton.getEntityManager("OortRubrica");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RubricaContattoVisualizzaIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		
		
//		HibernateDbManager hdbm = new HibernateDbManager();
//		Contatto contatto = hdbm.readRecordFromDb(Integer.parseInt(request.getParameter("id")));
//		System.out.println(contatto);
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		
//		Contatto contatto = readRecordFromDb(id);
		response.getWriter().append("hai selezionato questo ID: " + id);
//		String nome = contatto.getNome();
//		String cognome = contatto.getCognome();
//		System.out.println(nome);
//		System.out.println(cognome);
//		HttpSession session = request.getSession();
//		session.setAttribute("nome", nome);
//		session.setAttribute("cognome", cognome);
//		response.sendRedirect("VisualizzaContattoId.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
