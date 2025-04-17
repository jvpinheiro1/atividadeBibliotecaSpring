package projetoBiblioteca.projetoBiblioteca.dto;

import projetoBiblioteca.projetoBiblioteca.model.Livro;
import projetoBiblioteca.projetoBiblioteca.model.Emprestimo;  // ← Adicione esta linha


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LivroDTO {
    private  String titulo;
    private String autor;
    private Long isbn;
    private String genero;
    private List<EmprestimoDTO> emprestimos;

    public static LivroDTO fromEntity(Livro livro) {
        LivroDTO dto = new LivroDTO();
        dto.setTitulo(livro.getTitulo());
        dto.setAutor(livro.getAutor());
        dto.setIsbn(livro.getIsbn());
        dto.setGenero(livro.getGenero());

        if(livro.getEmprestimoLivros() != null) {
            dto.setEmprestimos(livro.getEmprestimoLivros().stream()
                    .map(empLivro -> EmprestimoDTO.fromEntity(empLivro.getEmprestimo())) // Converter para DTO
                    .collect(Collectors.toList()));
        }
        return dto;
    }
    public static Livro fromDTO(LivroDTO dto) {
        Livro livro = new Livro();
        livro.setTitulo(dto.getAutor());
        livro.setAutor(dto.getAutor());
        livro.setIsbn(dto.getIsbn());
        livro.setGenero(dto.getGenero());
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

    public List<EmprestimoDTO> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<EmprestimoDTO> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
