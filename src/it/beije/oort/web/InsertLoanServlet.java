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
		// TODO Auto-generated method stub
		try {
			Libro book = JPDBUtilities.exportBook(request.getParameter("title"));
			User user = (User)request.getSession().getAttribute("loggedUser");
			String message = JPDBUtilities.insertLoan(book.getId(), user.getId(), LocalDate.now(), LocalDate.now().plusMonths(1), "");
			request.getSession().setAttribute("statoPrestito", message);
			response.sendRedirect("user_biblio_homepage.jsp");
		} catch (javax.persistence.NoResultException e) {
			List<Libro> books = JPDBUtilities.exportBooks();
			request.getSession().setAttribute("libri", books);
			response.sendRedirect("nuovoPrestito.jsp");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Libro book = JPDBUtilities.exportBook(request.getParameter("libro"));
		HttpSession session = request.getSession();
		session.setAttribute("libro", book);
	}
}
