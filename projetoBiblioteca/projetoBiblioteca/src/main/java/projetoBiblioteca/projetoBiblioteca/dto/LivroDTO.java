package projetoBiblioteca.projetoBiblioteca.dto;

import projetoBiblioteca.projetoBiblioteca.model.Livro;

import java.time.LocalDate;
import java.util.List;

public class LivroDTO {
    private String autor;
    private Long isbn;
    private String genero;

    public static Livro fromDTO(LivroDTO livroDTOdto) {
        Livro livro = new Livro();
        livro.setAutor(livroDTOdto.getAutor());
        livro.setIsbn(livroDTOdto.getIsbn());
        livro.setGenero(livroDTOdto.getGenero());
        return livro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
}
