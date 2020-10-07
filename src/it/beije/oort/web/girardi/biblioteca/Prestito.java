package it.beije.oort.web.girardi.biblioteca;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prestito")
public class Prestito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "libro")
	private String libro;
	
	@Column(name = "utente")
	private String utente;
	
	@Column(name = "data_inizio")
	private LocalDate data_inizio;
	
	@Column(name = "data_fine")
	private LocalDate data_fine;
	
	@Column(name = "note")
	private String note;

	public Prestito() {}

	public Prestito(String libro, String utente, LocalDate data_inizio, LocalDate data_fine, String note) {
		this.libro = libro;
		this.utente = utente;
		this.data_inizio = data_inizio;
		this.data_fine = data_fine;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public LocalDate getData_inizio() {
		return data_inizio;
	}

	public void setData_inizio(LocalDate data_inizio) {
		this.data_inizio = data_inizio;
	}

	public LocalDate getData_fine() {
		return data_fine;
	}

	public void setData_fine(LocalDate data_fine) {
		this.data_fine = data_fine;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("prestito [");
		builder.append("id : ").append(this.id)	
			.append(" - libro : ").append(this.libro)	
			.append(" - utente : ").append(this.utente)
			.append(" - data_inizio : ").append(this.data_inizio)
			.append(" - data_fine : ").append(this.data_fine)
			.append(" - note : ").append(this.note).append("]");
		return builder.toString();
	}
}
