package it.beije.oort.web.bassanelli.phonebook_application;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JavaPersistenceDBManager {

	public static final String SCHEMA_OORT_PHONEBOOK = "OortPhonebook";

	private static void addObject(Object object) {

		EntityManager entityManager = JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	public static List<Contact> getAllContacts() {

		List<Contact> contacts = new ArrayList<Contact>();
		EntityManager entityManager = JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
		StringBuilder builder = new StringBuilder("FROM ").append(Contact.TABLE_CONTACT);
		Query query = entityManager.createQuery(builder.toString());
		contacts = query.getResultList();
		entityManager.close();
		return contacts;

	}

	public static Contact searchContactById(String id) {

		return searchContactById(Integer.parseInt(id));

	}

	public static Contact searchContactById(int id) {

		EntityManager entityManager = JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
		Contact contact = entityManager.find(Contact.class, id);
		entityManager.close();
		return contact;

	}

	public static void addContact(Contact contact) {

		// addObject(contact);

		EntityManager entityManager = JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
		entityManager.getTransaction().begin();
		entityManager.persist(contact);
		System.out.println(contact.toString("NAME;SURNAME"));
		entityManager.getTransaction().commit();
		entityManager.close();

	}
	
	public static void editContact(String id, Contact contact) {
		editContact(Integer.parseInt(id), contact);
	}

	public static void editContact(int id, Contact contact) {
		
		EntityManager entityManager = JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
		entityManager.getTransaction().begin();
		Contact temp = entityManager.find(Contact.class, id);
		temp.setName(contact.getName());
		temp.setSurname(contact.getSurname());
		temp.setMobile(contact.getMobile());
		temp.setEmail(contact.getEmail());
		entityManager.persist(temp);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	public static void deleteContact(String id) {
		deleteContact(Integer.parseInt(id));
	}

	public static void deleteContact(int id) {
		EntityManager entityManager = JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
		entityManager.getTransaction().begin();
		Contact contact = entityManager.find(Contact.class, id);
		// System.out.println(contact.toString("NAME;SURNAME"));
		entityManager.remove(contact);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public static List<Contact> searchByFilterPhonebook(String field, String word) {

		List<Contact> list = new ArrayList<Contact>();

		switch (field.toLowerCase()) {
		default:
		case "name":
			field = Contact.FIELD_NAME;
			break;
		case "surname":
			field = Contact.FIELD_SURNAME;
			break;
		case "mobile":
			field = Contact.FIELD_MOBILE;
			break;
		case "email":
			field = Contact.FIELD_EMAIL;
			break;
		}

		EntityManager entityManager = JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
		StringBuilder builder = new StringBuilder("FROM ").append(Contact.TABLE_CONTACT).append(" WHERE ").append(field)
				.append(" LIKE :word");
		Query query = entityManager.createQuery(builder.toString());
		list = query.setParameter("word", word + "%").getResultList();
		entityManager.close();
		return list;
	}

}
