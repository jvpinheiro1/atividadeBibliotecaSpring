package projetoBiblioteca.projetoBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoBiblioteca.projetoBiblioteca.model.EmprestimoLivro;

import java.util.List;

public interface EmprestimoLivroRepository extends JpaRepository<EmprestimoLivro, Long> {
    void deleteByEmprestimoId(Long emprestimoId);
    List<EmprestimoLivro> findByEmprestimoId(Long emprestimoId);
}
