package it.beije.oort.web.biblioteca;


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
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;

		@Column(name = "nome")
		private String nome;

		@Column(name = "cognome")
		private String cognome;

		@Column(name = "data_nascita")
		private String dataNascita;

		@Column(name = "data_morte")
		private String dataMorte;

		@Column(name = "biografia")
		private String biografia;

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

		public String getDataNascita() {
			return dataNascita;
		}

		public void setDataNascita(String dataNascita) {
			this.dataNascita = dataNascita;
		}

		public String getDataMorte() {
			return dataMorte;
		}

		public void setDataMorte(String dataMorte) {
			this.dataMorte = dataMorte;
		}

		public String getBiografia() {
			return biografia;
		}

		public void setBiografia(String biografia) {
			this.biografia = biografia;
		}

		public String toString() {
			StringBuilder builder = new StringBuilder("[");
			builder.append("ID: ").append(this.id)
				.append(" - NOME: ").append(this.nome)
				.append(" - COGNOME: ").append(this.cognome)
				.append(" - DATA NASCITA: ").append(this.dataNascita)
				.append(" - DATA MORTE: ").append(this.dataMorte)
				.append(" - BIOGRAFIA: ").append(this.biografia).append("]");

			return builder.toString();
		}
	}
