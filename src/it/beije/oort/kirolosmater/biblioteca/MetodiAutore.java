package it.beije.oort.kirolosmater.biblioteca;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static it.beije.oort.kirolosmater.biblioteca.LibraryManager.libraryPersistenceUnit;
import java.util.Scanner;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;

import it.beije.oort.kirolosmater.biblioteca.model.Autore;
import it.beije.oort.kirolosmater.biblioteca.model.JPAEntityManagerSingleton;
import it.beije.oort.rubrica.Contatto;
import it.beije.oort.rubrica.HybSessionFactory;

public class MetodiAutore {
	
	static EntityManager entityManager = JPAEntityManagerSingleton.getEntityManager(libraryPersistenceUnit);
	public static void menuAutore () {
		Scanner inputFromUser = new Scanner(System.in);
		System.out.println("inserisci 1 | Per visualizzare un autore in base al suo id");
		System.out.println("inserisci 2 | Per visualizzare più autori in base ad un parametro differente");
		System.out.println("inserisci 3 | Per modificare i parametri di un autore");
		System.out.println("inserisci 4 | Per inserire un nuovo autore");
		System.out.println("inserisci 5 | Per rimuovere un autore");
		System.out.println("inserisci 6 | Per esportare una lista di autori");
		String lineFromInput = inputFromUser.nextLine();
		int numberFromInput = Integer.parseInt(lineFromInput);
		switch (numberFromInput) {
		case 1: visualizzaAutoreById();	
			break;
			
		case 2: readRecordByStringFromInput();		
			break;
		case 4: inserimentoAutore();
			break;

		default: System.out.println("Hai inserito un valore non valido");
			break;
		}
		
	}
	
	public static Autore visualizzaAutoreById () {
		String showRecordById = "Per visualizzare un autore inserisci il suo id: ";
		System.out.println(showRecordById);
		Scanner inputFromUser = new Scanner(System.in);
		String lineFromInput = inputFromUser.next();
		int id = Integer.parseInt(lineFromInput);
		System.out.println("hai inserito questo id: " + id);
		System.out.println("questo è il record: ");
		Autore autore = readRecordFromDb(id);
		System.out.println("id : " + autore.getId());			
		System.out.println("cognome : " + autore.getCognome());
		System.out.println("nome : " + autore.getNome());
		System.out.println("data_nascita : " + autore.getData_nascita());
		System.out.println("data_morte : " + autore.getData_morte());
		System.out.println("biografia : " + autore.getBiografia());
		return autore;
	}
	
	public static Autore readRecordFromDb(int id) { 		
		Autore autore = entityManager.find(Autore.class, id);
		return autore;
	}
	
	
	public static List<Autore> readRecordByStringFromInput () {
		Scanner inputFromUser = new Scanner(System.in);
		System.out.println("Inserisci il parametro da analizzare: ");
		String parameter = inputFromUser.nextLine();
		String stringRequest = "Inserisci la stringa iniziale: ";
		System.out.println(stringRequest);
		String lineFromInput = inputFromUser.nextLine();
		String jpql = "SELECT c FROM Autore as c WHERE " + parameter + " LIKE '" + lineFromInput + "%'";
		Query query = (Query) entityManager.createQuery(jpql);
		List<Autore> autori = query.getResultList();
//		for (Autore autore : autori) {
//			System.out.println("id : " + autore.getId());			
//			System.out.println("cognome : " + autore.getCognome());
//			System.out.println("nome : " + autore.getNome());
//			System.out.println("data_nascita : " + autore.getData_nascita());
//			System.out.println("data_morte : " + autore.getData_morte());
//			System.out.println("biografia : " + autore.getBiografia());
//		}
		return autori;
	}
	
	public static List<Autore> readRecordByStringFromInput (String parametro, String stringaIniziale) {
		String parameter = parametro;
		String lineFromInput = stringaIniziale;
		String jpql = "SELECT c FROM Autore as c WHERE " + parameter + " LIKE '" + lineFromInput + "%'";
		Query query = (Query) entityManager.createQuery(jpql);
		List<Autore> autori = query.getResultList();
//		for (Autore autore : autori) {
//			System.out.println("id : " + autore.getId());			
//			System.out.println("cognome : " + autore.getCognome());
//			System.out.println("nome : " + autore.getNome());
//			System.out.println("data_nascita : " + autore.getData_nascita());
//			System.out.println("data_morte : " + autore.getData_morte());
//			System.out.println("biografia : " + autore.getBiografia());
//		}
		return autori;
	}
	
	public static Autore inserimentoAutore () {
		//SCANNER
		Scanner myObj = new Scanner(System.in);
		System.out.println("Inserisci nome");
		String nome = myObj.nextLine();
		System.out.println("Inserisci cognome");
		String cognome = myObj.nextLine();
		System.out.println("Inserisci data di nascita in questo formato YYYY-MM-DD");
		String data_nascita =  myObj.nextLine();
		System.out.println("Inserisci data di morte in questo formato YYYY-MM-DD");
		String data_morte =  myObj.nextLine();
		System.out.println("Inserisci biografia");
		String biografia = myObj.nextLine();
		//INSERT
		Autore autore = new Autore();
		autore.setNome(nome);
		autore.setCognome(cognome);
		autore.setData_nascita(dateFromString(data_nascita));
		autore.setData_morte(dateFromString(data_morte));
		autore.setBiografia(biografia);
		entityManager.getTransaction().begin();
		entityManager.persist(autore);
		entityManager.getTransaction().commit();
		entityManager.close();
		return autore;
	}
	
	public static Autore inserimentoAutore (String nome, String cognome, String data_nascita, String data_morte, String biografia) {
		//INSERT
		Autore autore = new Autore();
		autore.setNome(nome);
		autore.setCognome(cognome);
		autore.setData_nascita(dateFromString(data_nascita));
		autore.setData_morte(dateFromString(data_morte));
		autore.setBiografia(biografia);
		entityManager.getTransaction().begin();
		entityManager.persist(autore);
		entityManager.getTransaction().commit();
		entityManager.close();
		return autore;
	}
	
	public static Autore modificaAutore (int id, String parametro, String valore) {
		Autore autore = readRecordFromDb(id);
		switch (parametro.toLowerCase()) {
		case "nome": autore.setNome(valore);			
			break;
		case "cognome": autore.setCognome(valore);	
			break;	
		case "data_nascita": autore.setData_nascita(dateFromString(valore));			
			break;
		case "data_morte": autore.setData_morte(dateFromString(valore));		
			break;
		case "biografia": autore.setBiografia(valore);		
			break;
		default:
			System.out.println("Hai inserito un parametro non presente");
			break;
		}
		entityManager.getTransaction().begin();
		entityManager.persist(autore);
		entityManager.getTransaction().commit();
		entityManager.close();
		return autore;
	}
	
	public static Autore rimuoviAutore (int id) {
		Autore autore = readRecordFromDb(id);
		String jpql = "DELETE FROM Autore WHERE id = '" + id + "'";
		
		entityManager.getTransaction().begin();
		Query query = (Query) entityManager.createQuery(jpql);
		query.executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
		return autore;
	}
	
	public static List<Autore> readRecords (int first, int last) {
		List<Autore> autori = new ArrayList<Autore>();
		for(int i = first; i < last; i++) {
			autori.add(readRecordFromDb(i));
		}
		return autori;
	}
	
	public static void exportListToCsv (List<Autore> list, String path) {
		File fileCsv = new File(path);
		try {
			FileWriter writer = new FileWriter(fileCsv);
			writer.write("NOME;COGNOME;DATA_NASCITA;DATA_MORTE;BIOGRAFIA\n");
			for (Autore autore : list ) {
				writer.write(autoreToCsv(autore));
			}
			System.out.println("Done records: " + LocalTime.now());
			writer.flush();
			writer.close();
			System.out.println("Done file: " + LocalTime.now());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String autoreToCsv (Autore autore) {
		StringBuilder builder = new StringBuilder();
		builder.append(autore.getNome()).append(";")
			.append(autore.getCognome()).append(";")
			.append(autore.getData_nascita()).append(";")
			.append(autore.getData_morte()).append(";")
			.append(autore.getBiografia()).append("\n");
		
		return builder.toString();
	}
	
	public static LocalDate dateFromString (String str) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(str, f);
		return date;
	}
}
