package projetoBiblioteca.projetoBiblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    private String titulo;

    private String autor;

    @Column(unique = true)
    private Long isbn;

    private String genero;

    @OneToMany(mappedBy = "livro")
    @JsonIgnore
    private List<EmprestimoLivro> emprestimoLivros;


    public Livro() {
    }

    public List<EmprestimoLivro> getEmprestimoLivros() {
        return emprestimoLivros;
    }
    public void setEmprestimoLivros(List<EmprestimoLivro> emprestimoLivros) {
        this.emprestimoLivros = emprestimoLivros;
    }
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getId() {
        return idLivro;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
