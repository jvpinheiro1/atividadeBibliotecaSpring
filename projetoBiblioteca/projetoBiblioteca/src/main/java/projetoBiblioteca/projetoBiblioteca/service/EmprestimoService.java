package projetoBiblioteca.projetoBiblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoBiblioteca.projetoBiblioteca.dto.EmprestimoDTO;
import projetoBiblioteca.projetoBiblioteca.model.Cliente;
import projetoBiblioteca.projetoBiblioteca.model.Emprestimo;
import projetoBiblioteca.projetoBiblioteca.model.EmprestimoLivro;
import projetoBiblioteca.projetoBiblioteca.model.Livro;
import projetoBiblioteca.projetoBiblioteca.repository.ClienteRepository;
import projetoBiblioteca.projetoBiblioteca.repository.EmprestimoLivroRepository;
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
    @Autowired
    private EmprestimoLivroRepository emprestimoLivroRepository;

    public Emprestimo criarEmprestimo(EmprestimoDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        List<Livro> livros = livroRepository.findByIsbnIn(dto.getIsbns());
        if (livros.size() != dto.getIsbns().size()) {
            throw new RuntimeException("Alguns ISBNs não foram encontrados");
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataInicial(dto.getDataInicial());
        emprestimo.setDataDevolucao(dto.getDataDevolucao());
        emprestimo.setCliente(cliente);
        Emprestimo emprestimoSalvo = emprestimoRepository.save(emprestimo);

        // Cria as associações na tabela de junção
        for (Livro livro : livros) {
            EmprestimoLivro emprestimoLivro = new EmprestimoLivro();
            emprestimoLivro.setEmprestimo(emprestimoSalvo);
            emprestimoLivro.setLivro(livro);
            emprestimoLivroRepository.save(emprestimoLivro); // Agora deve funcionar
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

    public Emprestimo findById(Long id) {
        return emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado com o ID: " + id));
    }
    public void excluirEmprestimo(Long id) {
        emprestimoLivroRepository.deleteByEmprestimoId(id);
        emprestimoRepository.deleteById(id);
    }
}