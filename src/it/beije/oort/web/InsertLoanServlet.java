package it.beije.oort.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.web.db.JPDBUtilities;
import it.beije.oort.web.db.Libro;
import it.beije.oort.web.db.User;

/**
 * Servlet implementation class InsertLoanServlet
 */
@WebServlet("/insertLoan")
public class InsertLoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean admin;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertLoanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *
	 */
    //quando chiamo una servlet tramite link sto facendo una doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User utente = (User) request.getSession().getAttribute("loggedUser");
		System.out.println(request.getParameter("admin"));
		try {
			Libro book = JPDBUtilities.exportBook(request.getParameter("title"));
			User user = (User)request.getSession().getAttribute("loggedUser");
			String message = JPDBUtilities.insertLoan(book.getId(), user.getId(), LocalDate.now(), LocalDate.now().plusMonths(1), "");
			request.getSession().setAttribute("statoPrestito", message);
			if (utente.isAdmin()) {
				response.sendRedirect("admin_biblio_homepage.jsp");
			} else {
				response.sendRedirect("user_biblio_homepage.jsp");
			}
		} catch (javax.persistence.NoResultException e) {
			List<Libro> books = JPDBUtilities.exportBooks();
			request.getSession().setAttribute("libri", books);
			request.getSession().setAttribute("admin", admin);
			response.sendRedirect("nuovoPrestito.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Libro book = JPDBUtilities.exportBook(request.getParameter("libro"));
			HttpSession session = request.getSession();
			session.setAttribute("libro", book);
			response.sendRedirect("nuovoPrestito.jsp");
		} catch (javax.persistence.NoResultException e) {
			response.sendRedirect("nuovoPrestito.jsp");
		}
	}
}
