package it.beije.oort.web.biblioteca;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "editori")
public class Editori {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "denominazione")
	private String denominazione;

	@Column(name = "descrizione")
	private String descrizione;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		builder.append("ID: ").append(this.id)
			.append(" - NOME: ").append(this.denominazione)
			.append(" - DESCRIZIONE: ").append(this.descrizione).append("]");

		return builder.toString();
	}

}
