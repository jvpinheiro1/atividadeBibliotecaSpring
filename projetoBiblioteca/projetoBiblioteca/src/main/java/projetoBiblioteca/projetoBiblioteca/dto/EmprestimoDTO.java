package projetoBiblioteca.projetoBiblioteca.dto;

import projetoBiblioteca.projetoBiblioteca.model.Emprestimo;

import java.time.LocalDate;
import java.util.List;

public class EmprestimoDTO {

    private LocalDate dataInicial;
    private LocalDate dataDevolucao;
    private Long clienteId;
    private List<Long> isbns; // Alterado para lista de ISBNs

    public static Emprestimo fromDTO(EmprestimoDTO emprestimoDTOdto) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataInicial(emprestimoDTOdto.getDataInicial());
        emprestimo.setDataDevolucao(emprestimoDTOdto.getDataDevolucao());
        return emprestimo;
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

    // Getters e Setters
    public List<Long> getIsbns() {
        return isbns;
    }

    public void setIsbns(List<Long> isbns) {
        this.isbns = isbns;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

}
