package it.beije.oort.madonia.biblioteca.ebeans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autori")
public class Autore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_nascita")
	private Date dataNascita;
	
	@Column(name = "data_morte")
	private Date dataMorte;
	
	@Column(name = "biografia")
	private String biografia;
	
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
	
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	public Date getDataMorte() {
		return dataMorte;
	}
	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}
	
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder().append("Autore [");
		
		sb.append("cognome: ");
		if(cognome == null) {
			sb.append(cognome);
		} else {
			sb.append("\"").append(cognome).append("\"");
		}
		
		sb.append(" - ").append("nome: ");
		if(nome == null) {
			sb.append(nome);
		} else {
			sb.append("\"").append(nome).append("\"");
		}
		
		sb.append(" - ").append("data_nascita: ");
		if(dataNascita == null) {
			sb.append(dataNascita);
		} else {
			sb.append("\"").append(dataNascita).append("\"");
		}
		
		sb.append(" - ").append("data_morte: ");
		if(dataMorte == null) {
			sb.append(dataMorte);
		} else {
			sb.append("\"").append(dataMorte).append("\"");
		}
		
		sb.append(" - ").append("biografia: ");
		if(biografia == null) {
			sb.append(biografia);
		} else {
			sb.append("\"").append(biografia).append("\"");
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}
