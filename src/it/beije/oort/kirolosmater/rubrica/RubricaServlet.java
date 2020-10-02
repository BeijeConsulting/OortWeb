package it.beije.oort.kirolosmater.rubrica;

import java.io.IOException;
//import it.beije.oort.rubrica.*;
//import it.beije.oort.kirolosmater.rubrica.*;
//import static it.beije.oort.kirolosmater.rubrica.HibernateDbManager.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RubricaServlet
 */
@WebServlet("/rubrica/view/RubricaServlet")
public class RubricaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RubricaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		Contatto contatto = readRecordFromDb(Integer.parseInt(request.getParameter("id")));
		response.getWriter().append("hai selezionato questo ID: " + request.getParameter("id"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
