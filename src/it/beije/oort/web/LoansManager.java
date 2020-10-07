package it.beije.oort.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.web.db.JPDBUtilities;
import it.beije.oort.web.db.Prestito;

/**
 * Servlet implementation class LoansManager
 */
@WebServlet("/LoansManager")
public class LoansManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoansManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//NON FUNZIONA
		if (request.getParameter("rimuovi") != null && request.getParameter("rimuovi").equals("1")) {
			JPDBUtilities.deleteLoan(Integer.parseInt(request.getParameter("idloan")));
		}
		List<Prestito> loans = JPDBUtilities.exportLoans();
		request.getSession().setAttribute("loans", loans);
		response.sendRedirect("gestore_prestiti.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nota = request.getParameter("nota");
		int idPrestito = Integer.parseInt(request.getParameter("loanID"));
		JPDBUtilities.updateLoan(nota, idPrestito);
		doGet(request,response);
	}
}
