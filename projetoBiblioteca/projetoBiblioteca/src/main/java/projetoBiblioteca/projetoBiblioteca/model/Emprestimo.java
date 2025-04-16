package projetoBiblioteca.projetoBiblioteca.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;

    private LocalDate dataInicial;
    private LocalDate dataDevolucao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "emprestimo", cascade = CascadeType.ALL)
    private List<EmprestimoLivro> livros;



    public Emprestimo(){
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public List<EmprestimoLivro> getLivros() {
        return livros;
    }

    public void setLivros(List<EmprestimoLivro> livros) {
        this.livros = livros;
    }

    public Long getId() {
        return idEmprestimo;
    }
}
