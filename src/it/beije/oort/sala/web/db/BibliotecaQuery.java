package it.beije.oort.sala.web.db;

import java.util.ArrayList;
import java.util.List;
import it.beije.oort.sala.biblioteca.beans.*;

public class BibliotecaQuery {

	public static List<PrestitoTransport> getPrestiti(Integer i) {
		List<Object> temp = JPAToolset.selectJPA("Prestito","id_utente", i);
		List<PrestitoTransport> list = new ArrayList<>();
		for(Object o : temp) {
			Prestito p = (Prestito)o;
			Libro l = (Libro)JPAToolset.selectJPA("Libro","id_libro", p.getId_libro()).get(0);
			Utente u = (Utente)JPAToolset.selectJPA("Utente","id_utente", p.getId_utente()).get(0);
			list.add(new PrestitoTransport(p, u, l));
		}
		return list;
	}
}
