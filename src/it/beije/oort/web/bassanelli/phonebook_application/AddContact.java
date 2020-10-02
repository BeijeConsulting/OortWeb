package it.beije.oort.web.bassanelli.phonebook_application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddContact
 */
@WebServlet("/add-contact")
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContact() {
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
		
		Contact contact = new Contact();
		
		contact.setName(request.getParameter("name"));
		contact.setSurname(request.getParameter("surname"));
		contact.setMobile(request.getParameter("mobile"));
		contact.setEmail(request.getParameter("email"));
		
		// System.out.println(contact.toString("NAME;SURNAME;MOBILE;EMAIL"));
		
		JavaPersistenceDBManager.addContact(contact);
		
		response.getWriter().append("Done");
	}

}
