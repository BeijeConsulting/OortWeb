package it.beije.oort.bm.rubrica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rubrica")
public class Contatto implements Comparable<Contatto>{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_rubrica")
	private int id;
	@Column
	private String nome;
	@Column
	private String cognome;
	@Column
	private String telefono;
	@Column
	private String email;
	
	public Contatto() {}
	
	public Contatto(int id) {
		this.id = id;
	}
	
	public Contatto(String nome, String cognome, String telefono) {
		this(nome, cognome, telefono, "");
	}
	
	public Contatto(String nome, String cognome, String telefono, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("| ").append("id: ").append(id).append(" | ")
			.append("surname : ").append(this.cognome).append(" | ")
			.append("name : ").append(this.nome).append(" | ")
			.append("phone_n� : ").append(this.telefono).append(" | ")
			.append("e-mail : ").append(this.email).append(" |");
		
		return builder.toString();
	}

	@Override
	public int compareTo(Contatto c) {
		int result = this.cognome.compareTo(c.cognome);
		if(result == 0) {
			result = this.nome.compareTo(c.nome);
		}
		return result;
	}
	
}
