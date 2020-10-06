package it.beije.oort.web.biblioteca.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente implements IBibliotecaModel {
    @Id
    @Column
    private String codice_fiscale;

    @Column
    private String nome;

    @Column
    private String cognome;

    @Column
    private String email;

    @Column
    private String cellulare;

    @Column
    private String indirizzo;

    @Column
    private String password;

    @Column(name = "admin")
    private boolean admin;

    public String getCodice_fiscale() {
        return codice_fiscale;
    }

    public void setCodice_fiscale(String codice_fiscale) {
        this.codice_fiscale = codice_fiscale;
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

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome +
                ". Cognome: " + cognome +
                " .Codice Fiscale: " + codice_fiscale +
                " .Cellulare: " + cellulare +
                ".\n\tEmail:  " + email +
                ".\n\tIndirizzo: " + indirizzo;
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
}
