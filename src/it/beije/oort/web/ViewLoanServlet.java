package it.beije.oort.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.web.db.JPDBUtilities;
import it.beije.oort.web.db.Libro;
import it.beije.oort.web.db.Prestito;
import it.beije.oort.web.db.User;

/**
 * Servlet implementation class ViewLoanServlet
 */
@WebServlet("/viewLoan")
public class ViewLoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewLoanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("loggedUser");
		List<Prestito> userLoans = JPDBUtilities.exportLoans(user.getId());
		List<Libro> books = JPDBUtilities.exportBooks(user.getId());
		HttpSession session = request.getSession();
		session.setAttribute("userLoans", userLoans);
		session.setAttribute("libri", books);
		response.sendRedirect("user_prestiti.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
