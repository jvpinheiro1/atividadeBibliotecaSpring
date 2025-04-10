package projetoBiblioteca.projetoBiblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoBiblioteca.projetoBiblioteca.dto.EmprestimoDTO;
import projetoBiblioteca.projetoBiblioteca.model.Cliente;
import projetoBiblioteca.projetoBiblioteca.model.Emprestimo;
import projetoBiblioteca.projetoBiblioteca.model.Livro;
import projetoBiblioteca.projetoBiblioteca.repository.ClienteRepository;
import projetoBiblioteca.projetoBiblioteca.repository.EmprestimoRepository;
import projetoBiblioteca.projetoBiblioteca.repository.LivroRepository;

import java.util.List;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private LivroRepository livroRepository;

    public Emprestimo criarEmprestimo(EmprestimoDTO dto) {
        // Busca cliente
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Busca livros por ISBNs
        List<Livro> livros = livroRepository.findByIsbnIn(dto.getIsbns());
        if (livros.size() != dto.getIsbns().size()) {
            throw new RuntimeException("ISBNs inválidos");
        }

        // Cria empréstimo
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataInicial(dto.getDataInicial());
        emprestimo.setDataDevolucao(dto.getDataDevolucao());
        emprestimo.setCliente(cliente);
        Emprestimo emprestimoSalvo = emprestimoRepository.save(emprestimo);

        // Associa livros ao empréstimo
        for (Livro livro : livros) {
            livro.setEmprestimo(emprestimoSalvo);
            livroRepository.save(livro);
        }

        return emprestimoSalvo;
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo atualizarEmprestimo(Long id, EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow();
        emprestimo.setDataInicial(emprestimoDTO.getDataInicial());
        emprestimo.setDataDevolucao(emprestimoDTO.getDataDevolucao());
        return emprestimoRepository.save(emprestimo);
    }

    public void excluirEmprestimo(Long id) {
        emprestimoRepository.deleteById(id);
    }
}
