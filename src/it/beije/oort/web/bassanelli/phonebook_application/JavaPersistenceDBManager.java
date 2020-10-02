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

	public static Contact searchContactById(int id) {

		EntityManager entityManager = JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
		Contact contact = entityManager.find(Contact.class, id);
		entityManager.close();
		return contact;

	}

	public static void addContact(Contact contact) {

		//addObject(contact);
		
		EntityManager entityManager = JavaPersistenceSessionManager.getEntityManager(SCHEMA_OORT_PHONEBOOK);
		entityManager.getTransaction().begin();
		entityManager.persist(contact);
		System.out.println(contact.toString("NAME;SURNAME"));
		entityManager.close();

	}
}
