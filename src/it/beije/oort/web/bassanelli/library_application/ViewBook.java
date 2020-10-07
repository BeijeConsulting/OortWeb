package it.beije.oort.web.bassanelli.library_application;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewBook
 */
@WebServlet("/library/book/view-book")
public class ViewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewBook() {
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

		List<Book> books;

		switch (radioValue) {
		case "all":
			books = JavaPersistenceDBManager.getAllBooks();
			session.setAttribute("type", "multiple");
			session.setAttribute("books", books);
			break;
		case "id":
			Book book = JavaPersistenceDBManager.searchBookById(filter);
			session.setAttribute("type", "single");
			session.setAttribute("book", book);
			break;
		case "title":
			books = JavaPersistenceDBManager.searchByFilterBook(radioValue, filter);
			session.setAttribute("type", "multiple");
			session.setAttribute("books", books);
			break;
		case "description":
			books = JavaPersistenceDBManager.searchByFilterBook(radioValue, filter);
			session.setAttribute("type", "multiple");
			session.setAttribute("books", books);
			break;
		case "year":
			books = JavaPersistenceDBManager.searchByFilterBook(radioValue, filter);
			session.setAttribute("type", "multiple");
			session.setAttribute("books", books);
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
