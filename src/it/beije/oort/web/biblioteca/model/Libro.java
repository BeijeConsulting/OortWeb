package it.beije.oort.web.biblioteca.model;

import it.beije.oort.web.biblioteca.dbutils.DatabaseManager;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="libri")
public class Libro implements IBibliotecaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String titolo;

    @Column
    private String descrizione;

    @Column
    private Date anno_pubblicazione;

    @Column
    private Integer id_autore;

    @Column
    private Integer id_editore;

    public Autore getAutore(){
        if (id_autore != null){
            return (Autore) DatabaseManager.select(Autore.class, id_autore);
        } else return null;
    }

    public Editore getEditore(){
        if (id_editore != null){
            return (Editore) DatabaseManager.select(Editore.class, id_editore);
        } else return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getAnno_pubblicazione() {
        return anno_pubblicazione;
    }

    public void setAnno_pubblicazione(Date anno_pubblicazione) {
        this.anno_pubblicazione = anno_pubblicazione;
    }

    public Integer getId_autore() {
        return id_autore;
    }

    public void setId_autore(Integer id_autore) {
        this.id_autore = id_autore;
    }

    public Integer getId_editore() {
        return id_editore;
    }

    public void setId_editore(Integer id_editore) {
        this.id_editore = id_editore;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ") Titolo: " + titolo +
                ". Anno: " + anno_pubblicazione +
                ". ID Autore: " + id_autore +
                ". ID Editore: " + id_editore +
                ".\n\tDescrizione: " + descrizione;
    }
}
