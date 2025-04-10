package projetoBiblioteca.projetoBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoBiblioteca.projetoBiblioteca.model.Livro;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIsbnIn(List<Long> isbns); // Novo método

    List<Livro> findByEmprestimoId(Long emprestimoId);


}
