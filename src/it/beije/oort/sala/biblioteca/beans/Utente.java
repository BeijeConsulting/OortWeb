package it.beije.oort.sala.biblioteca.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente implements Databasable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_utente")
	private Integer id_utente;
	@Column
	private String nome;
	@Column
	private String cognome;
	@Column
	private String email;
	@Column
	private String codice_fiscale;
	@Column
	private String telefono;
	@Column
	private String indirizzo;
	@Column
	private String password;
	@Column
	private boolean admin;

	public Utente() {
		this(null, "","","","","","","",false);
	}
	
	public Utente(Integer id_utente, String nome, String cognome, String codice_fiscale, 
				String email, String telefono, String indirizzo, String password, boolean admin) {
		super();
		this.id_utente = id_utente;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.codice_fiscale = codice_fiscale;
		this.telefono = telefono;
		this.indirizzo = indirizzo;
		this.password = password;
		this.admin = admin;
	}

	public Integer getId_utente() {
		return id_utente;
	}

	public void setId_utente(Integer id_utente) {
		this.id_utente = id_utente;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String toString() {
		return "Utente [id_utente=" + id_utente + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + "]";
	}

	

	
	
}
