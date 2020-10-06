package it.beije.oort.web.bassanelli.phonebook_application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchById
 */
@WebServlet("/phonebook/search-by-id")
public class SearchById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		
		Contact contact = JavaPersistenceDBManager.searchContactById(id);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("searchContact", contact);
		
		switch (type) {
		case "edit":
			response.sendRedirect("./edit.jsp");
			break;
		case "delete":
			response.sendRedirect("./delete.jsp");
			break;
		default:
			response.sendRedirect("./index.jsp");
			break;
		}
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
