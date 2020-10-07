package it.beije.oort.web.bassanelli.library_application;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class JavaPersistenceDBManager {

	public static final String SCHEMA_OORT_LIBRARY = "OortLibrary";

	public static User loginUser(String email, String password) {

		EntityManager entityManager = JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_LIBRARY);
		StringBuilder builder = new StringBuilder("FROM ").append(User.TABLE_USER).append(" WHERE ")
				.append(User.FIELD_EMAIL).append(" = :email").append(" AND ").append(User.FIELD_PASSWORD)
				.append(" = :password");
		Query query = entityManager.createQuery(builder.toString());
		query.setParameter("email", email);
		query.setParameter("password", password);
		User user;
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			user = null;
		} finally {
			entityManager.close();
		}
		return user;
	}

	public static void editUser(String id, User user) {
		editUser(Integer.parseInt(id), user);
	}

	public static void editUser(int id, User user) {
		EntityManager entityManager = JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_LIBRARY);
		entityManager.getTransaction().begin();
		User temp = entityManager.find(User.class, id);
		temp.setName(user.getName());
		temp.setSurname(user.getSurname());
		temp.setMobile(user.getMobile());
		temp.setAddress(user.getAddress());
		temp.setPassword(user.getPassword());
		entityManager.persist(temp);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public static List<Book> getAllBooks() {

		List<Book> books = new ArrayList<Book>();
		EntityManager entityManager = JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_LIBRARY);
		StringBuilder builder = new StringBuilder("FROM ").append(Book.TABLE_BOOK);
		Query query = entityManager.createQuery(builder.toString());
		books = query.getResultList();
		entityManager.close();
		return books;

	}
	
	public static Book searchBookById(String id) {

		return searchBookById(Integer.parseInt(id));

	}

	public static Book searchBookById(int id) {

		EntityManager entityManager = JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_LIBRARY);
		Book book = entityManager.find(Book.class, id);
		entityManager.close();
		return book;

	}
	
	public static List<Book> searchByFilterBook(String field, String word) {

		List<Book> list = new ArrayList<Book>();

		switch (field.toLowerCase()) {
		default:
		case "title":
			field = Book.FIELD_TITLE;
			break;
		case "description":
			field = Book.FIELD_DESCRIPTION;
			break;
		case "year":
			field = Book.FIELD_YEAR;
			break;
		case "email":
		}

		EntityManager entityManager = JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_LIBRARY);
		StringBuilder builder = new StringBuilder("FROM ").append(User.TABLE_USER).append(" WHERE ").append(field)
				.append(" LIKE :word");
		Query query = entityManager.createQuery(builder.toString());
		query.setParameter("word", word + "%");
		list = query.getResultList();
		entityManager.close();
		return list;
	}

	/*
	 * private static void addObject(Object object) {
	 * 
	 * EntityManager entityManager =
	 * JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
	 * entityManager.getTransaction().begin(); entityManager.persist(object);
	 * entityManager.getTransaction().commit(); entityManager.close();
	 * 
	 * }
	 * 
	 * public static List<Contact> getAllContacts() {
	 * 
	 * List<Contact> contacts = new ArrayList<Contact>(); EntityManager
	 * entityManager =
	 * JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
	 * StringBuilder builder = new
	 * StringBuilder("FROM ").append(Contact.TABLE_CONTACT); Query query =
	 * entityManager.createQuery(builder.toString()); contacts =
	 * query.getResultList(); entityManager.close(); return contacts;
	 * 
	 * }
	 * 
	 * public static Contact searchContactById(String id) {
	 * 
	 * return searchContactById(Integer.parseInt(id));
	 * 
	 * }
	 * 
	 * public static Contact searchContactById(int id) {
	 * 
	 * EntityManager entityManager =
	 * JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
	 * Contact contact = entityManager.find(Contact.class, id);
	 * entityManager.close(); return contact;
	 * 
	 * }
	 * 
	 * public static void addContact(Contact contact) {
	 * 
	 * // addObject(contact);
	 * 
	 * EntityManager entityManager =
	 * JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
	 * entityManager.getTransaction().begin(); entityManager.persist(contact);
	 * System.out.println(contact.toString("NAME;SURNAME"));
	 * entityManager.getTransaction().commit(); entityManager.close();
	 * 
	 * }
	 * 
	 * public static void editContact(String id, Contact contact) {
	 * editContact(Integer.parseInt(id), contact); }
	 * 
	 * public static void editContact(int id, Contact contact) {
	 * 
	 * EntityManager entityManager =
	 * JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
	 * entityManager.getTransaction().begin(); Contact temp =
	 * entityManager.find(Contact.class, id); temp.setName(contact.getName());
	 * temp.setSurname(contact.getSurname()); temp.setMobile(contact.getMobile());
	 * temp.setEmail(contact.getEmail()); entityManager.persist(temp);
	 * entityManager.getTransaction().commit(); entityManager.close();
	 * 
	 * }
	 * 
	 * public static void deleteContact(String id) {
	 * deleteContact(Integer.parseInt(id)); }
	 * 
	 * public static void deleteContact(int id) { EntityManager entityManager =
	 * JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
	 * entityManager.getTransaction().begin(); Contact contact =
	 * entityManager.find(Contact.class, id); //
	 * System.out.println(contact.toString("NAME;SURNAME"));
	 * entityManager.remove(contact); entityManager.getTransaction().commit();
	 * entityManager.close(); }
	 * 
	 * public static List<Contact> searchByFilterPhonebook(String field, String
	 * word) {
	 * 
	 * List<Contact> list = new ArrayList<Contact>();
	 * 
	 * switch (field.toLowerCase()) { default: case "name": field =
	 * Contact.FIELD_NAME; break; case "surname": field = Contact.FIELD_SURNAME;
	 * break; case "mobile": field = Contact.FIELD_MOBILE; break; case "email":
	 * field = Contact.FIELD_EMAIL; break; }
	 * 
	 * EntityManager entityManager =
	 * JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
	 * StringBuilder builder = new
	 * StringBuilder("FROM ").append(Contact.TABLE_CONTACT).append(" WHERE ").append
	 * (field) .append(" LIKE :word"); Query query =
	 * entityManager.createQuery(builder.toString()); list =
	 * query.setParameter("word", word + "%").getResultList();
	 * entityManager.close(); return list; }
	 */
}
