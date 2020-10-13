package it.beije.oort.web.girardi.biblioteca;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "titolo")
	private String titolo;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "id_autore")
	private Integer id_autore;
	
	@Column(name = "id_editore")
	private Integer id_editore;
	
	@Column(name = "anno")
	private LocalDate anno;
	
	
	public Libro() {}
	
	public Libro(String titolo, String descrizione, Integer id_autore, 
					Integer id_editore, LocalDate anno) {
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.id_autore = id_autore;
		this.id_editore = id_editore;
		this.anno = anno;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	public Integer getIdAutore() {
		return id_autore;
	}
	public void setIdAutore(Integer id_autore) {
		this.id_autore = id_autore;
	}
	
	
	public Integer getIdEditore() {
		return id_editore;
	}
	public void setIdEditore(Integer id_editore) {
		this.id_editore = id_editore;
	}
	
	
	public LocalDate getAnno() {
		return anno;
	}
	public void setAnno(LocalDate anno) {
		this.anno = anno;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("prestito [");
		builder.append("id : ").append(this.id)	
			.append(" - titolo : ").append(this.titolo)	
			.append(" - descrizione : ").append(this.descrizione)
			.append(" - id_autore : ").append(this.id_autore)
			.append(" - id_editore : ").append(this.id_editore)
			.append(" - anno : ").append(this.anno).append("]");
		return builder.toString();
	}
}
