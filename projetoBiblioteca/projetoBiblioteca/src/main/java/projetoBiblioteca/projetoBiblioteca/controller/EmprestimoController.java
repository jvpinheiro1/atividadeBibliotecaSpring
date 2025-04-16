package projetoBiblioteca.projetoBiblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoBiblioteca.projetoBiblioteca.dto.EmprestimoDTO;
import projetoBiblioteca.projetoBiblioteca.dto.LivroDTO;
import projetoBiblioteca.projetoBiblioteca.model.Emprestimo;
import projetoBiblioteca.projetoBiblioteca.model.Livro;
import projetoBiblioteca.projetoBiblioteca.service.EmprestimoService;
import projetoBiblioteca.projetoBiblioteca.service.LivroService;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Emprestimo> criar(@RequestBody EmprestimoDTO emprestimoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(emprestimoService.criarEmprestimo(emprestimoDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoDTO> getEmprestimoById(@PathVariable Long id) {
        Emprestimo emprestimo = emprestimoService.findById(id);
        EmprestimoDTO dto = EmprestimoDTO.fromEntity(emprestimo);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<Emprestimo>> listar() {
        return ResponseEntity.ok(emprestimoService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> atualizar(
            @PathVariable Long id,
            @RequestBody EmprestimoDTO emprestimoDTO) {
        return ResponseEntity.ok(emprestimoService.atualizarEmprestimo(id, emprestimoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        emprestimoService.excluirEmprestimo(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/livros/{isbn}")
    public ResponseEntity<LivroDTO> getLivro(@PathVariable Long isbn) {
        Livro livro = livroService.findByIsbn(isbn);  // ← Agora funciona
        return ResponseEntity.ok(LivroDTO.fromEntity(livro));
    }

    @GetMapping("/emprestimos/{id}")
    public ResponseEntity<EmprestimoDTO> getEmprestimo(@PathVariable Long id) {
        Emprestimo emprestimo = emprestimoService.findById(id);
        return ResponseEntity.ok(EmprestimoDTO.fromEntity(emprestimo));
    }

}
