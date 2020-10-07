package it.beije.oort.web.girardi.biblioteca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utente")
public class Utente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "codice_fiscale")
	private String codice_fiscale;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "indirizzo")
	private String indirizzo;

	private String password;
	
	private boolean admin;
	
	
	public Utente() {}

	public Utente(String nome, String cognome, String codice_fiscale, String telefono, 
			String email, String indirizzo, String password, boolean admin) {
		this.nome = nome;
		this.cognome = cognome;
		this.codice_fiscale = codice_fiscale;
		this.telefono = telefono;
		this.email = email;
		this.indirizzo = indirizzo;
		this.password = password;
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("contatto [");
		builder.append("id : ").append(this.id)	
			.append(" - nome : ").append(this.nome)	
			.append(" - cognome : ").append(this.cognome)
			.append(" - telefono : ").append(this.telefono)
			.append(" - email : ").append(this.email)
			.append(" - codice_fiscale : ").append(this.codice_fiscale)
			.append(" - indirizzo : ").append(this.indirizzo).append("]");
		return builder.toString();
	}
}
