package it.beije.oort.lauria.biblioteca.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.lauria.biblioteca.JPADBtools;
import it.beije.oort.lauria.biblioteca.Prestito;
import it.beije.oort.lauria.biblioteca.Utente;

/**
 * Servlet implementation class VisualizzaPrestitiUtente
 */
@WebServlet("/VisualizzaPrestitiUtente")
public class VisualizzaPrestitiUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaPrestitiUtente() {
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
		Utente userBean = (Utente)request.getSession().getAttribute("userBean");
		List<Prestito> prestitiUtente = JPADBtools.selectPrestitiUtente(userBean.getId());
		request.getSession().setAttribute("catalogoPrestitiUtente", prestitiUtente);
		response.sendRedirect("visualizzaPrestitiUtente.jsp");
	}

}
