package it.beije.oort.web.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column
	private String cognome;
	@Column
	private String nome;
	@Column
	private String telefono;
	@Column
	private String email;
	@Column
	private String codice_fiscale;
	@Column
	private String indirizzo;
	@Column
	private String password;
	@Column
	private boolean admin;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getCodice_fiscale() {
		return codice_fiscale;
	}
	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.id).append(";")
		.append(this.nome).append(";")
		.append(this.cognome).append(";")
		.append(this.email).append(";")
		.append(this.telefono).append(";");
		return builder.toString();
	}
}
