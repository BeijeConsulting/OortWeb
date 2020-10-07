//package it.beije.oort.web;
//
//public class Utente {
//
//	private int id;
//
//	private String nome;
//
//	private String cognome;
//
//	private String telefono;
//
//	private String email;
//
//	private String password;
//
//
//	public Utente() {}
//
//	public Utente(String nome, String cognome, String telefono) {
//		this(nome, cognome, telefono, "");
//	}
//
//	public Utente(String nome, String cognome, String telefono, String email) {
//		this.nome = nome;
//		this.cognome = cognome;
//		this.telefono = telefono;
//		this.email = email;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public String getCognome() {
//		return cognome;
//	}
//	public void setCognome(String cognome) {
//		this.cognome = cognome;
//	}
//
//	public String getTelefono() {
//		return telefono;
//	}
//	public void setTelefono(String telefono) {
//		this.telefono = telefono;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//
//	public String toString() {
//		StringBuilder builder = new StringBuilder("contatto [");
//		builder.append("nome : ").append(this.nome)
//			.append(" - cognome : ").append(this.cognome)
//			.append(" - telefono : ").append(this.telefono)
//			.append(" - email : ").append(this.email).append("]");
//
//		return builder.toString();
//	}
//
//}
