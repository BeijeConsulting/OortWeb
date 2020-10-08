package it.beije.oort.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.sb.jpa.JPDBtools;

/**
 * Servlet implementation class DeleteLibro
 */
@WebServlet("/DeleteLibro")
public class DeleteLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLibro() {
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
			try {
				int indice = Integer.parseInt(request.getParameter("id_libro"));
				JPDBtools.delete("Libri", indice, "OortBiblioteca");
				request.getSession().setAttribute("errore", "Libro Cancellato Correttamente");
				response.sendRedirect("menubiblioteca.jsp");
			} catch(Exception e) { //Cosi prendo sia eccezioni di numberformat che eventualmente della jpa
				request.getSession().setAttribute("errore", "Id Libro Errato");
				response.sendRedirect("menubiblioteca.jsp");
			}
	}

}
