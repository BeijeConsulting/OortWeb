package it.beije.oort.sala.biblioteca;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.sala.biblioteca.beans.Prestito;
import it.beije.oort.sala.web.db.BibliotecaQuery;
import it.beije.oort.sala.web.db.JPAToolset;

/**
 * Servlet implementation class Prestiti
 */
@WebServlet("/Prestiti")
public class Prestiti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prestiti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("prestiti")!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("prestiti",
					BibliotecaQuery.getPrestiti(new Integer(request.getParameter("prestiti"))));
		}
		response.sendRedirect("/OortWeb/sala/biblioteca/user.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("op")!=null) {
			if(request.getParameter("op").equals("insert")) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
				LocalDate fine = null;
				if(!request.getParameter("data_fine").equals(""))
					fine = LocalDate.parse(request.getParameter("data_fine"), formatter);
				JPAToolset.insertJPA(new Prestito(null, 
						new Integer(request.getParameter("id_utente")),
						new Integer(request.getParameter("id_libro")),
						LocalDate.parse(request.getParameter("data_inizio"), formatter),
						fine,
						request.getParameter("note")));
			} else if(request.getParameter("op").equals("delete")) {
				JPAToolset.deleteJPA("Prestito", new Integer(request.getParameter("id_prestito")));
			} else if(request.getParameter("op").equals("update")) {
				if(request.getParameter("field").equals("id_utente") ||
						request.getParameter("field").equals("id_libro")) {
					JPAToolset.updateJPA("Prestito",
							request.getParameter("field"),
							new Integer(request.getParameter("value")),
							new Integer(request.getParameter("id_prestito")));
				} else if(request.getParameter("field").equals("data_inizio") ||
						request.getParameter("field").equals("data_fine")) {
					JPAToolset.updateJPA("Prestito",
							request.getParameter("field"),
							LocalDate.parse(request.getParameter("value")),
							new Integer(request.getParameter("id_prestito")));
				}else if(request.getParameter("field").equals("note")) {
					JPAToolset.updateJPA("Prestito",
							request.getParameter("field"),
							request.getParameter("value"), 
							new Integer(request.getParameter("id_prestito")));
				}
			}
		}
		response.sendRedirect("/OortWeb/sala/biblioteca/sub-admin/prestiti.html");
	}

}
