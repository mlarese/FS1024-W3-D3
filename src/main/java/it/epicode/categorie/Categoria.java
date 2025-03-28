package it.epicode.categorie;

import it.epicode.libri.Libro;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @Column(length = 50, nullable = false)
    private String nome;

    // con mapped by dico che la relazione principale è quella che si trova in Libro
    @ManyToMany(mappedBy = "categorie")
    List<Libro> libri = new ArrayList<>();

    // per evitare un ciclo infinito non inserire nel tostring i libri
    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +

                '}';
    }

    public Categoria() {
    }

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
