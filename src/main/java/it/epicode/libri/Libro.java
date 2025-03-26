package it.epicode.libri;

import it.epicode.autori.Autore;
import it.epicode.case_editrici.CasaEditrice;
import it.epicode.categorie.Categoria;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libri")

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, nullable = false)
    private String titolo;
    /*
    * libro 1 autore
    * libro 1 casa editrice
    * libro molte categoria
    *
    * autore molti libri
    * casaeditrice molti libri
    * categoria in quanti libri si trova molti
    *
    *
    * */
    // il cascade PERSIST permette quando salvo un libro di salvare anche l'autore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Autore autore;

    // il cascade PERSIST permette quando salvo un libro di salvare anche la casa editrice
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private CasaEditrice casaEditrice;

    //  il cascade PERSIST permette quando salvo un libro di salvare anche tutte le categorie
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Categoria> categorie = new ArrayList<>();


    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", autore=" + autore +
                ", casaEditrice=" + casaEditrice +
                ", categorie=" + categorie +
                '}';
    }

    public Libro(Long id, String titolo, Autore autore, CasaEditrice casaEditrice, List<Categoria> categorie) {
        this.id = id;
        this.titolo = titolo;
        this.autore = autore;
        this.casaEditrice = casaEditrice;
        this.categorie = categorie;
    }

    public Libro() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public CasaEditrice getCasaEditrice() {
        return casaEditrice;
    }

    public void setCasaEditrice(CasaEditrice casaEditrice) {
        this.casaEditrice = casaEditrice;
    }

    public List<Categoria> getCategorie() {
        return categorie;
    }

    public void setCategorie(List<Categoria> categorie) {
        this.categorie = categorie;
    }
}
