package it.epicode.autori;


import it.epicode.libri.Libro;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autori")
public class Autore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String cognome;
    @Column(length = 50)
    private String nazionalita;
    @OneToMany(mappedBy = "autore", cascade = {CascadeType.REMOVE})
    private List<Libro> libri;
    //--------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Autore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", nazionalita='" + nazionalita + '\'' +
                '}';
    }




    public Autore() {
    }

    public Autore(Long id, String nome, String cognome, String nazionalita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.nazionalita = nazionalita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }
}
