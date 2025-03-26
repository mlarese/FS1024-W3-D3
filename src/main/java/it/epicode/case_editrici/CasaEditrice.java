package it.epicode.case_editrici;


import it.epicode.libri.Libro;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "case_editrici")
public class CasaEditrice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50)
    private String sede;

    // con mapped by dico che la relazione principale è quella che si trova in Libro
    @OneToMany(mappedBy = "casaEditrice")
    List<Libro> libri;

    // per evitare un ciclo infinito non inserire nel tostring i libri
    @Override
    public String toString() {
        return "CasaEditrice{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sede='" + sede + '\'' +

                ", dataFondazione=" + dataFondazione +
                '}';
    }

    private LocalDate dataFondazione;

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

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public LocalDate getDataFondazione() {
        return dataFondazione;
    }

    public void setDataFondazione(LocalDate dataFondazione) {
        this.dataFondazione = dataFondazione;
    }

    public CasaEditrice(Long id, String nome, String sede, LocalDate dataFondazione) {
        this.id = id;
        this.nome = nome;
        this.sede = sede;
        this.dataFondazione = dataFondazione;
    }

    public CasaEditrice() {
    }
}
