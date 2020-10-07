package it.beije.oort.web.bassanelli.library_application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/library/edit-user")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
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
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		User user = (User)request.getSession().getAttribute("user");
		
		String id = request.getParameter("id");
		
		// user.setId(id);
		user.setName(request.getParameter("name"));
		user.setSurname(request.getParameter("surname"));
		user.setMobile(request.getParameter("mobile"));
		user.setAddress(request.getParameter("address"));
		user.setPassword(request.getParameter("password"));
		
		JavaPersistenceDBManager.editUser(user.getId(), user);
		
		// request.getSession().setAttribute("user", user);
		
		response.sendRedirect("./profile.jsp");
		
	}

}
