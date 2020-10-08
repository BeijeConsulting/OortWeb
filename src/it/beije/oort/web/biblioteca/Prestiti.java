package it.beije.oort.web.biblioteca;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prestiti")
public class Prestiti {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "id_libro")
	private int libro;

	@Column(name = "id_utente")
	private int utente;

	@Column(name = "data_inizio")
	private String dataInizio;

	@Column(name = "data_fine")
	private String dataFine;

	@Column(name = "note")
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLibro() {
		return libro;
	}

	public void setLibro(int libro) {
		this.libro = libro;
	}

	public int getUtente() {
		return utente;
	}

	public void setUtente(int utente) {
		this.utente = utente;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder(" [");
		builder.append("ID: ").append(this.id)
			.append(" - ID Libro: ").append(this.libro)
			.append(" - ID Utente: ").append(this.utente)
			.append(" -Data inizio: ").append(this.dataInizio)
			.append(" - Data fine: ").append(this.dataFine)
			.append(" - Note: ").append(this.note).append("]");

		return builder.toString();
	}

}