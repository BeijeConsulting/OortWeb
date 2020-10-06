package it.beije.oort.web.bassanelli.phonebook_application;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewContact
 */
@WebServlet("/phonebook/view-contact")
public class ViewContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewContact() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		String radioValue = request.getParameter("radioValue");
		String filter = request.getParameter("filter");

		List<Contact> contacts;
		
		switch (radioValue) {
		case "all":
			contacts = JavaPersistenceDBManager.getAllContacts();
			session.setAttribute("type", "list");
			session.setAttribute("contacts", contacts);
			break;

		case "id":
			Contact contact = JavaPersistenceDBManager.searchContactById(filter);
			session.setAttribute("type", "contact");
			session.setAttribute("contact", contact);
			break;

		case "name":
			contacts = JavaPersistenceDBManager.searchByFilterPhonebook(radioValue, filter);
			session.setAttribute("type", "list");
			session.setAttribute("contacts", contacts);
			break;

		case "surname":
			contacts = JavaPersistenceDBManager.searchByFilterPhonebook(radioValue, filter);
			session.setAttribute("type", "list");
			session.setAttribute("contacts", contacts);
			break;

		case "mobile":
			contacts = JavaPersistenceDBManager.searchByFilterPhonebook(radioValue, filter);
			session.setAttribute("type", "list");
			session.setAttribute("contacts", contacts);
			break;

		case "email":
			contacts = JavaPersistenceDBManager.searchByFilterPhonebook(radioValue, filter);
			session.setAttribute("type", "list");
			session.setAttribute("contacts", contacts);
			break;
		}

		response.sendRedirect("./view.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
