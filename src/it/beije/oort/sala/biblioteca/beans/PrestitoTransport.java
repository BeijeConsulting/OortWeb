package it.beije.oort.sala.biblioteca.beans;

public class PrestitoTransport {

	private Integer id;
	private String nome;
	private String cognome;
	private String titolo;
	private String inizio;
	private String fine;
	
	public PrestitoTransport(Prestito p, Utente u, Libro l) {
		this.id = p.getId_prestito();
		this.nome = u.getNome();
		this.cognome = u.getCognome();
		this.titolo = l.getTitolo();
		this.inizio = p.getData_inizio().toString();
		this.fine = (p.getData_fine()!=null)?p.getData_fine().toString():"";
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getInizio() {
		return inizio;
	}

	public String getFine() {
		return fine;
	}

	public String toString() {
		return "PrestitoTransport [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", titolo=" + titolo
				+ ", inizio=" + inizio + ", fine=" + fine + "]";
	}
}