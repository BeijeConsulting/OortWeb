package it.beije.oort.madonia.biblioteca.ebeans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prestiti")
public class Prestito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "libro")
	private int idLibro;
	
	@Column(name = "utente")
	private int idUtente;
	
	@Column(name = "data_inizio")
	private Date dataInizio;
	
	@Column(name = "data_fine")
	private Date dataFine;
	
	@Column(name = "note")
	private String note;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder().append("Utente [");

		sb.append("id libro: ");
		if(idLibro == 0) {
			sb.append(idLibro);
		} else {
			sb.append("\"").append(idLibro).append("\"");
		}

		sb.append(" - ").append("id utente: ");
		if(idUtente == 0) {
			sb.append(idUtente);
		} else {
			sb.append("\"").append(idUtente).append("\"");
		}

		sb.append(" - ").append("data_inizio: ");
		if(dataInizio == null) {
			sb.append(dataInizio);
		} else {
			sb.append("\"").append(dataInizio).append("\"");
		}

		sb.append(" - ").append("data_fine: ");
		if(dataFine == null) {
			sb.append(dataFine);
		} else {
			sb.append("\"").append(dataFine).append("\"");
		}

		sb.append(" - ").append("note: ");
		if(note == null) {
			sb.append(note);
		} else {
			sb.append("\"").append(note).append("\"");
		}

		sb.append("]");

		return sb.toString();
	}
}