package it.beije.oort.lauria.biblioteca.jsp;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.lauria.biblioteca.Autore;
import it.beije.oort.lauria.biblioteca.Editore;
import it.beije.oort.lauria.biblioteca.JEntityManagerFactory;
import it.beije.oort.lauria.biblioteca.JPADBtools;
import it.beije.oort.lauria.biblioteca.Libro;

/**
 * Servlet implementation class VisualizzaLibri
 */
@WebServlet("/VisualizzaLibri")
public class VisualizzaLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaLibri() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		EntityManager entityManager = JEntityManagerFactory.openEntityManager("OortBiblioteca");
//		String jpql = "SELECT l FROM Libro as l WHERE id > 0";
//		Query query = entityManager.createQuery(jpql);
//		List<Libro> libri = query.getResultList();
//		
//		for (Libro libro : libri) {			
//			Autore a = JPADBtools.entityManager.find(Autore.class, libro.getId_autore());
//			Editore e = JPADBtools.entityManager.find(Editore.class, libro.getId_editore()); 
//			request.getSession().setAttribute("nomeAutore", " ("+ a.getNome() +" "+a.getCognome() +")");
//			request.getSession().setAttribute("nomeEditore", libri);
//		}

		
		
		
		List<Libro> libri = JPADBtools.selectLibri();
		request.getSession().setAttribute("catalogoLibri", libri);
		List<Autore> autori = JPADBtools.selectAutori();
		request.getSession().setAttribute("catalogoAutori", autori);
		List<Editore> editori = JPADBtools.selectEditori();
		request.getSession().setAttribute("catalogoEditori", editori);
		response.sendRedirect("visualizzaLibri.jsp");
	}

}
